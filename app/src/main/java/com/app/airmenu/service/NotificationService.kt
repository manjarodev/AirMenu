package com.app.airmenu.service

import android.app.*
import android.content.*
import android.graphics.Color
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LifecycleService
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.android.volley.AuthFailureError
import com.android.volley.DefaultRetryPolicy
import com.android.volley.NetworkResponse
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.app.airmenu.BuildConfig
import com.app.airmenu.R
import com.app.airmenu.local.PreferenceRepository
import com.app.airmenu.models.*
import com.app.airmenu.network.response.OrderDetail
import com.app.airmenu.network.response.POSStatus
import com.app.airmenu.remote.RemoteRepository
import com.app.airmenu.room.database.DatabaseBuilder
import com.app.airmenu.room.database.DatabaseHelperImpl
import com.app.airmenu.room.model.OrderInfo
import com.app.airmenu.room.model.UberNotification
import com.app.airmenu.session.SessionManager
import com.app.airmenu.ui.HomeActivity
import com.app.airmenu.ui.MainActivity
import com.app.airmenu.utils.*
import com.app.airmenu.utils.decryption.RSA_cipher
import com.elvishew.xlog.XLog
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.net.PlacesClient
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import com.imprint.app.network.ApiClient
import com.squareup.okhttp.ResponseBody
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.*
import java.net.Socket
import java.net.URISyntaxException
import java.util.*
import java.util.concurrent.TimeoutException
import javax.inject.Inject
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext


private const val TAG = "NotificationService"
private const val NOTIFICATION = 1
private const val AIRMENU_ORDERS = 2

/**
 * This is the main service which will run in backgournd
 * always and monitor all incoming orders from UberEats and forward them
 * to AirMenu. Also this service is responsible to establish and
 * maintain the connection with AirMenu socket and monitor orders status
 * changed by AirMenu and update Uber accordingly.
 */
@AndroidEntryPoint
class NotificationService : LifecycleService(), CoroutineScope {

    companion object {

        private var socket: Socket? = null
        private var mFlag: Boolean = false
        var isServiceRunning = false
        fun isSocketConnected(): Boolean = socket != null && socket?.isConnected == true

    }

    private var retryCount: Int = 0
    private val SUCCESS_SOCKET_MESSAGE = "SUCCESS"
    private val PING_MESSAGE = "ping"
    private val PONG_MESSAGE = "pong"
    private val ORDER_SOCKET_MESSAGE = "ApiAction_GetOrders"
    private lateinit var job: Job
    private var bufOut: BufferedWriter? = null
    private var bufIn: BufferedReader? = null
    private var isSocketConnected = false
    private lateinit var sessionManager: SessionManager

    //    private lateinit var sharedManager: SharedManager
    private lateinit var placesClient: PlacesClient
    private lateinit var helper: DatabaseHelperImpl

    @Inject
    lateinit var prefRepository: PreferenceRepository

    @Inject
    lateinit var remoteRepository: RemoteRepository

    override val coroutineContext: CoroutineContext
        get() = job + Main


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)

        // change flag to true
        isServiceRunning = true

        //open a socket connection
        try {

            val uri = prefRepository.getNotificationResponse()?.host ?: "null"
            val authToken = prefRepository.getNotificationResponse()?.token ?: "null"
            val port = prefRepository.getNotificationResponse()?.port ?: "null"

            thread {

                createSocketForMessages(uri, port, authToken)

                Log.e("mTAG", "onStartCommand: uri:: $uri port:: $port auth:: $authToken")


            }

        } catch (e: URISyntaxException) {
            XLog.e("onStartCommand: exception $e")
        }

        return START_STICKY
    }

    /**
     * This method is responsible to establish the socket connection
     * @param host
     * @param port
     * @param authToken
     */
    @Suppress("DEPRECATED_IDENTITY_EQUALS")
    private fun createSocketForMessages(
        host: String,
        port: String,
        authToken: String
    ) {

        // replace the special characters and http form url.
        var tempHost: String = host.replace("^\"|\"$", "")
        tempHost = tempHost.replace("http://", "")
        tempHost = tempHost.replace("/", "")

        try {
            HomeActivity.onSocketEvent?.invoke(SocketState.CONNECTING)
            XLog.e("connecting with socket...")
            socket = Socket(tempHost, port.toInt())
            socket!!.soTimeout = 1000 * 60 * 60
            bufOut = BufferedWriter(OutputStreamWriter(socket?.getOutputStream()))
            bufIn = BufferedReader(InputStreamReader(socket?.getInputStream()))
            bufOut?.write(authToken)
            bufOut?.newLine()
            bufOut?.flush()

            val handShakeResponce = StringBuilder()
            val buf = CharArray(1)

            do {
                bufIn?.read(buf)
                handShakeResponce.append(buf[0])
            } while (handShakeResponce.length < SUCCESS_SOCKET_MESSAGE.length)

            if (handShakeResponce.toString() != SUCCESS_SOCKET_MESSAGE) {
                XLog.e("socket disconnected")
                isSocketConnected = false
                updateSessionId(NOTIFICATION)
                HomeActivity.onSocketEvent?.invoke(SocketState.DISCONNECTED)
                return
            } else {
                XLog.e("socket connected")
                isSocketConnected = true
                getNewOrderFromAirMenu()
                HomeActivity.onSocketEvent?.invoke(SocketState.CONNECTED)
            }

            startPingCycle(bufOut)

            val message = java.lang.StringBuilder()

            if (bufIn != null) {
                do {
                    bufIn?.read(buf)
                    if (buf[0] == '\u0000') {
                        val messageStr = message.toString()
                        handleSocketMessage(messageStr)
                        message.setLength(0)
                    } else {
                        message.append(buf[0])
                    }
                    if (message.toString() == PONG_MESSAGE) {
                        val messageStr = message.toString()
                        handleSocketMessage(messageStr)
                        message.setLength(0)
                    }
                } while (true)
            } else {
                XLog.e("Reinitializing the buffer....")
                HomeActivity.onSocketEvent?.invoke(SocketState.DISCONNECTED)
                if (sessionManager.shouldStopService == false)
                    shouldConnectSocketAgain()
            }


        } catch (e: IOException) {
            e.printStackTrace()
            XLog.e("IOEeception in catch for socket => ${e.message}")
            HomeActivity.onSocketEvent?.invoke(SocketState.DISCONNECTED)
            if (sessionManager.shouldStopService == false)
                shouldConnectSocketAgain()
        } finally {
            if (bufOut != null) {
                try {
                    bufOut!!.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
            if (bufIn != null) {
                try {
                    bufIn!!.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }

            if (socket != null) {
                try {
                    socket!!.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }

    }

    /**
     * This method is reponsible to update AirMenu sessionId
     * for All other APIs at runtime (during order placement)
     * @param api
     */
    private fun updateSessionId(api: Int) {
        Log.e(TAG, "updateSessionId: called")
        CoroutineScope(IO).launch {
            try {
                val response = remoteRepository.loginWithCredentials(
                    ACTION_LOGIN,
                    "1.0.0",
                    serverKey,
                    formatToJsonAuth(
                        prefRepository.getUserEmail()!!,
                        prefRepository.getUserPassword()!!
                    )
                )


                Log.e("mTAG", "updateSessionId: ${prefRepository.getUserPassword()}")

                if (response.isSuccessful && response.body() != null) {
                    val res = response.body()?.string()?.split("=")
                    if (res != null) {
                        val mainResponse = parseToJsonObjLogin(res[1]) as LoginResponse

                        if (mainResponse.statusCode == 1) {
                            prefRepository.saveLoginResponse(mainResponse)
                            prefRepository.saveSessionId(mainResponse.sessionId!!)

                            when (api) {
                                NOTIFICATION -> {
                                    getNotificationCredentials()
                                }
                                AIRMENU_ORDERS -> {
                                    getNewOrderFromAirMenu()
                                }
                            }
                        } else if (mainResponse.errorCode == 109) {

//                            sessionOut("updateSessionId")  //exit user on login failed

                        } else {
                            Handler(Looper.getMainLooper()).postDelayed(
                                {
                                    updateSessionId(api)
                                }, 3000
                            )

                        }
                    }
                }
            } catch (e: Exception) {
                XLog.e("getSessionId: exception while getting => ${e.message}")
            }
        }
    }

    /**
     * This method will get and update the socket credentials
     * such as accessToken for socket connection and upate them
     * in local data structure (sharedPrefrences)
     */
    private fun getNotificationCredentials() {
        CoroutineScope(IO).launch {
            isSocketConnected = false
            HomeActivity.onSocketEvent?.invoke(SocketState.CONNECTING)
            try {
                val response = remoteRepository.getNotificationAccess(
                    ACTION_NOTIFICATION_ACCESS,
                    "1.0.0",
                    serverKey,
                    formatToJsonNotification(
                        prefRepository.getSessionId(),
                        prefRepository.getSelectedEnterpriseId(),
                        prefRepository.getSelectedPOSId()
                    )
                )

                if (response.isSuccessful && response.body() != null) {
                    val res = response.body()?.string()?.split("=")
                    if (res != null) {

                        val mainResponse =
                            parseToJsonObjNotification(res[1]) as NotificationAccessResponse
                        if (mainResponse.statusCode == 1) {
                            prefRepository.saveNotificationResponse(mainResponse)

                            try {
                                val uri =
                                    prefRepository.getNotificationResponse()?.host
                                        ?: "null"
                                val authToken =
                                    prefRepository.getNotificationResponse()?.token
                                        ?: "null"
                                val port =
                                    prefRepository.getNotificationResponse()?.port
                                        ?: "null"
                                thread {
                                    createSocketForMessages(
                                        uri,
                                        port,
                                        authToken
                                    )
                                }
                            } catch (e: Exception) {
                                XLog.e("exception while getting socket credentials => $e")
                                updateSessionId(NOTIFICATION)
                            }
                        } else if (mainResponse.statusCode == -1) {
                            updateSessionId(NOTIFICATION)
                        }
                    } else {
                        updateSessionId(NOTIFICATION)
                    }
                }
            } catch (e: Exception) {
                XLog.e(
                    "shouldConnectSocketAgain: exception while calling api " + e.message
                )
                isSocketConnected = false
                HomeActivity.onSocketEvent?.invoke(SocketState.DISCONNECTED)
                if (e is TimeoutException) {
                    Log.e(TAG, "getNotificationCredentials: time out exception calling again")
                    getNotificationCredentials()
                }
            }
        }
    }

    /**
     * This method will be used when socket will disconnected
     * And it will make sure that after socket disconnected
     * buffer and socket should be null before initializing them
     * again. Also it will initiate new socket connection request
     * if the network will be available.
     */
    private fun shouldConnectSocketAgain() {
        if (bufOut != null) {
            // XLog.e("buffer was not null, closing")
            try {
                bufOut!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        if (bufIn != null) {
            // XLog.e("bufferIn was not null, closing")

            try {
                bufIn!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        if (socket != null) {
            //XLog.e("socket was not null, closing")
            try {
                socket!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        XLog.e("shouldConnectSocketAgain: :::::::::>>")

        if (NetworkHelper.isNetworkAvailable(this)) {
            XLog.e("network available getting notification credentials")
            getNotificationCredentials()
        } else XLog.e("shouldConnectSocketAgain: internet not available")

    }

    /**
     * This method will be fired each time socket will
     * receive any message and take action if the message
     * will be of order message.
     */
    private fun handleSocketMessage(messageStr: String) {
        XLog.e("handleSocketMessage: is called")
        if (messageStr.equals(ORDER_SOCKET_MESSAGE)) {
            getNewOrderFromAirMenu()
        } else {
            XLog.e("server message => $messageStr")
        }
    }

    /**
     * This method is responsible to get new orders from
     * AirMenu right after socket will get message form AirMenu
     * Also it will check the order status and call Order status
     * APIs accordingly.
     */
    private fun getNewOrderFromAirMenu() {
        XLog.e("Getting new orders from AirMenu...")
        CoroutineScope(IO).launch {
            try {
                val response = remoteRepository.getOrders(
                    ACTION_GET_ORDERS,
                    "1.0.0",
                    serverKey,
                    getNewOrderJson()
                )

                if (response.isSuccessful && response.body() != null) {
                    val mainString = response.body()!!.string()
                    val resString = mainString.substring(
                        mainString.indexOf("{"),
                        mainString.lastIndexOf("}") + 1
                    )
                    val jsonRes = JSONObject(resString)
                    val statusCode = jsonRes.getInt("statusCode")
                    val ordersDatum = mutableListOf<orderDatum>()
                    val mainResponse = parseOrders(resString)

                    if (statusCode == 1) {
                        var uberOrderId = ""
                        var status = ""
                        var airmenuOrderId = ""
                        var shouldUpdateStatus = false
                        var reason = ""
                        mainResponse.forEach {
                            XLog.e("uk...")

                            if (it.childs[0].plu.equals("TYPE")) {

                                status = getLastFlag(it.activeFlags)
                                airmenuOrderId = it.activeFlags[0].orderId

                                if (status.equals("ACCEPT") || status.equals("CANCEL") || status.equals(
                                        "DENY"
                                    )
                                ) {
                                    shouldUpdateStatus = false
                                    if (status.equals("ACCEPT")) {
                                    } else {
                                        if (status.equals("DENY")) {
                                            reason = getReasonForDeny(it.extraInfo)

                                        } else if (status.equals("CANCEL")) {
                                            reason = getReasonForCancel(it.extraInfo)
                                        }
                                    }
                                } else {
                                    shouldUpdateStatus = true
                                }

                                uberOrderId = getUberOrderId(it.extraInfo).toString()
                                ordersDatum.add(
                                    orderDatum(
                                        uberOrderId,
                                        airmenuOrderId,
                                        status,
                                        shouldUpdateStatus,
                                        reason
                                    )
                                )
                            }
                            //}


                        }

                        Log.e(TAG, "orders list size for UK=> ${ordersDatum.size}")
                        ordersDatum.forEach {
                            Log.e(
                                TAG,
                                "list-details ${it.airmenuId}::::${it.status}::::${it.reason}::::${it.uberId}::::${it.shouldUpdateStatus}"
                            )

                            try {
                                if (it.shouldUpdateStatus) {
                                    Log.e(
                                        TAG,
                                        "getNewOrderFromAirMenu: updating status...${it.airmenuId}"
                                    )
                                    updateDeliveryStatus(
                                        it.status,
                                        it.uberId.toString(),
                                        it.airmenuId.toString()
                                    )
                                } else {
                                    Log.e(
                                        TAG,
                                        "getNewOrderFromAirMenu: accept/deny with reason $reason id=> ${it.airmenuId}"
                                    )
                                    updateOrderStatusAtUber(
                                        it.status,
                                        it.uberId.toString(),
                                        it.airmenuId.toString(),
                                        it.reason
                                    )
                                }

                            } catch (e: Exception) {
                                Log.e(TAG, "exception in forEach ${e.message}")
                            }

                        }

                        ordersDatum.clear()


                    } else {
                        if (jsonRes.getInt("errorName").equals(ERROR_SESSION_EXPIRED)) {
                            updateSessionId(AIRMENU_ORDERS)
                        }
                    }
                }

            } catch (e: Exception) {
                XLog.e("exception while getting new orders => ${e.message}")
            }
        }
    }

    /**
     * This method will get the uber order id from active flags
     * get from AirMenu Order information.
     * @param activeFlags
     * @return response as String
     */
    private fun getUberOrderId(activeFlags: List<Object>): String? {
        Log.e(TAG, "getUberOrderId: getting the order id")
        var response: String? = null
        for (info in activeFlags) {
            val jsonString = info.toString()
            if (jsonString.contains("nif")) {
                try {
                    val a = jsonString.substring(
                        jsonString.indexOf("uberOrder=") + 10,
                        jsonString.length
                    )
                    val b = a.substring(0, a.indexOf(","))
                    response = b
                    Log.e(TAG, "getUberOrderId: $response")
                } catch (t: Throwable) {
                    Log.e(
                        TAG,
                        "Could not parse malformed JSON: ${t} "
                    )
                }
            }
        }

        return response
    }


    /**
     * This method will update Order Delivery status at Uber
     * Also it will call showNotification to update user through
     * notification.
     * @param status
     * @param uberOrderId
     * @param airmenuOrderId
     */
    private fun updateDeliveryStatus(status: String, uberOrderId: String, airmenuOrderId: String) {
        ApiClient.token = "Bearer ${sessionManager.getOrderDeliveryToken()}"
        Log.e(TAG, "updateDeliveryStatus: status is=> ${status.lowercase(Locale.getDefault())}")
        val jsonObject = JSONObject()

        jsonObject.put("status", status.lowercase(Locale.getDefault()))

        val intent = Intent(this@NotificationService, HomeActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP

            action = Intent.ACTION_VIEW
        }
        showNotification1(
            this@NotificationService,
            "Got new order",
            "OrderId => $airmenuOrderId Status=> $status",
            intent
        )


        val body = jsonObject.toString()
            .toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
        ApiClient.retrofitService.updateDeliveryStatus(uberOrderId, body)
            .enqueue(
                object : Callback<ResponseBody> {
                    override fun onResponse(
                        call: Call<ResponseBody>,
                        response: Response<ResponseBody>
                    ) {
                        Log.e(TAG, "onResponse: in status api ${response.body()}")
                        if (response.isSuccessful && response.body() != null) {
                            Log.e(TAG, "onResponse: successfully updated order status")
                        } else if (response.code() == 404) {
                            XLog.e("Order not found=> $uberOrderId")
                        }

                        XLog.e("While update delviery status  ${response.body()}")
                    }

                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        Log.e(TAG, "onFailure: updting status", t)
                    }
                })
    }

    /**
     * This method will show notification to user on order status upate from AirMenu.
     * @param context
     * @param title
     * @param body (body of the message)
     * @param intent
     */
    fun showNotification1(context: Context, title: String?, body: String?, intent: Intent?) {
        val notificationManager =
            context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val notificationId = Random().nextInt(10000)
        val channelId = "channel-01"
        val channelName = "Order Notifications"
        val importance = NotificationManager.IMPORTANCE_HIGH
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val mChannel = NotificationChannel(
                channelId, channelName, importance
            )
            notificationManager.createNotificationChannel(mChannel)
        }
        val mBuilder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.ic_launcher_01)
            .setContentTitle(title)
            .setContentText(body)
        val stackBuilder = TaskStackBuilder.create(context)
        stackBuilder.addNextIntent(intent)
        val resultPendingIntent = stackBuilder.getPendingIntent(
            0,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        mBuilder.setContentIntent(resultPendingIntent)
        notificationManager.notify(notificationId, mBuilder.build())
    }


    /**
     * This method will show notification on error.
     * @param context
     * @param title
     * @param body (body of the message)
     * @param intent
     */
    fun showErrorNotification(title: String?, message: String?) {
        val notificationManager =
            applicationContext.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val notificationId = Random().nextInt(10000)
        val channelId = "channel-02"
        val channelName = "Error Notifications"
        val importance = NotificationManager.IMPORTANCE_HIGH
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val mChannel = NotificationChannel(
                channelId, channelName, importance
            )
            notificationManager.createNotificationChannel(mChannel)
        }
        val mBuilder = NotificationCompat.Builder(applicationContext, channelId)
            .setSmallIcon(R.drawable.ic_launcher_01)
            .setContentTitle(title)
            .setContentText(message)
        notificationManager.notify(notificationId, mBuilder.build())
    }


    /**
     * This method will extract the order deny/ cancel reason
     */
    private fun getReasonForCancel(extraInfo: List<Object>): String {
        var response: ExtraInfoCancel? = null
        for (info in extraInfo) {
            val jsonString = info.toString()
            if (jsonString.contains("KITCHEN_CLOSED")) {
                try {
                    val obj =
                        JSONObject(info.toString())
                    Log.e(TAG, "jsonObject is  $obj")
                    response = parseCancelResponse(obj)

                } catch (t: Throwable) {
                    Log.e(
                        TAG,
                        "Could not parse malformed JSON: ${t} "
                    )
                }
            }
        }

        response.let {
            if (it?.outOfItems == true) {
                return "OUT_OF_ITEMS"
            } else if (it?.restaurantTooBusy == true) {
                return "RESTAURANT_TOO_BUSY"
            } else if (it?.customerCalledCancel == true) {
                return "CUSTOMER_CALLED_TO_CANCEL"
            } else if (it?.kitchenClosed == true) {
                return "KITCHEN_CLOSED"
            } else if (it?.connotCompleteCustomerNote == true) {
                return "CANNOT_COMPLETE_CUSTOMER_NOTE"
            } else {
                return "OUT_OF_ITEMS"
            }
        }
    }

    private fun getReasonForDeny(extraInfo: List<Object>): String {
        var response: ExtraInfo2? = null
        for (info in extraInfo) {
            val jsonString = info.toString()

            Log.e(TAG, "getReasonForDeny: $jsonString")

            if (jsonString.contains("POS_OFFLINE")) {
                try {
                    val obj =
                        JSONObject(info.toString())
                    Log.e(TAG, "jsonObject is  $obj")
                    response = parseDenyResponse(obj)

                } catch (t: Throwable) {
                    Log.e(
                        TAG,
                        "Could not parse malformed JSON: ${t} "
                    )
                }
            }
        }

        response.let {
            if (it?.aDDRESS == true) {
                return "ADDRESS"
            } else if (it?.cAPACITY == true) {
                return "CAPACITY"
            } else if (it?.iTEMAVAILABILITY == true) {
                return "ITEM_AVAILABILITY"
            } else if (it?.oTHER == true) {
                return "OTHER"
            } else if (it?.pOSNOTREADY == true) {
                return "POS_NOT_READY"
            } else if (it?.mISSINGINFO == true) {
                return "MISSING_INFO"
            } else if (it?.pRICING == true) {
                return "PRICING"
            } else if (it?.pOSOFFLINE == true) {
                return "POS_OFFLINE"
            } else if (it?.sTORECLOSED == true) {
                return "STORE_CLOSED"
            } else if (it?.mISSINGITEM == true) {
                return "MISSING_ITEM"
            } else if (it?.sPECIALINSTRUCTIONS == true) {
                return "SPECIAL_INSTRUCTIONS"
            } else {
                Log.e(TAG, "getReasonForDeny: returing from response else")
                return "POS_OFFLINE"
            }

        }

    }

    private fun getLastFlag(activeFlags: List<OrderResponseAirMenu.Orders.UK.ActiveFlag>): String {
        var lastFlag = activeFlags[0].key
        var lastTime = activeFlags[0].datetime

        for (flag in activeFlags) {
            if (flag.datetime > lastTime) {
                lastTime = flag.datetime
                lastFlag = flag.key
            }
        }

        Log.e(TAG, "getLastFlag: returnign=> $lastFlag")
        return lastFlag

    }

    private fun updateOrderStatusAtUber(
        status: String,
        uberOrderId: String,
        airmenuOrderId: String,
        reason: String?
    ) {
        XLog.e("updateOrderStatusAtUber: is called $status,\n $uberOrderId")
        ApiClient.token = sessionManager.uberOrderDetailToken.toString()
//        if (AirMenuApp.isInForeGround) {
//            HomeActivity.onNewOrder?.invoke(status, uberOrderId, airmenuOrderId)
//
//        } else {
        val intent = Intent(this@NotificationService, HomeActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP

            action = Intent.ACTION_VIEW
        }
        showNotification1(
            this@NotificationService,
            "Got new order",
            "OrderId => $airmenuOrderId Status=> $status",
            intent
        )

        //}
        when (status) {
            "ACCEPT" -> {
                val obj = JSONObject()
                obj.put("reason", status)


                val request = ApiClient.retrofitService.acceptOrder(uberOrderId, obj)

                request.enqueue(object : Callback<ResponseBody> {
                    override fun onResponse(
                        call: Call<ResponseBody>,
                        response: Response<ResponseBody>
                    ) {
                        XLog.e("onResponse status update: ${response.body()}")
                        if (response.isSuccessful) {
                            XLog.e("onResponse: success")
                        }
                    }

                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        XLog.e("onFailure: status update failure ${t.message}")
                    }
                })
            }
            "CANCEL" -> {
                Log.e(TAG, "updating with cancel:::: $reason")


                val jsonObject = JSONObject()
                jsonObject.put("reason", reason)
                jsonObject.put("cancelling_party", "MERCHANT")
                jsonObject.put("explanation", "failed to submit order")
                val body = jsonObject.toString()
                    .toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())

                val request = ApiClient.retrofitService.cancelOrder(uberOrderId, body)



                request.enqueue(object : Callback<ResponseBody> {
                    override fun onResponse(
                        call: Call<ResponseBody>,
                        response: Response<ResponseBody>
                    ) {
                        XLog.e("onResponse in CancelOrder: ${response.body()}")
                        if (response.isSuccessful) {
                            XLog.e("onResponse: order canceled")
                        }
                    }

                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        XLog.e("onFailure: canceling order${t.message}")
                    }
                })
            }
            "DENY" -> {
                Log.e(TAG, "updating with deny:::: $reason")
                val mainObject = JSONObject()
                val jsonObject = JSONObject()
                jsonObject.put("code", reason)
                jsonObject.put("explanation", "failed to submit order: reason > $reason")

                mainObject.put("reason", jsonObject)
                val body = mainObject.toString()
                    .toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())

                ApiClient.retrofitService.denyOrder(uberOrderId, body)
                    .enqueue(object : Callback<ResponseBody> {
                        override fun onResponse(
                            call: Call<ResponseBody>,
                            response: Response<ResponseBody>
                        ) {
                            XLog.e("on order deny  ${response.body()}")
                            Log.e(TAG, "onResponse: deny order ${response.body()}")
                            if (response.isSuccessful) {
                                Log.e(TAG, "onResponse: order denied successfully ")
                            }
                        }

                        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                            Log.e(TAG, "onFailure: denying the order", t)
                        }
                    })

            }
        }


    }


    private fun getSessionIdForUpdateFlag(orderId: String?) {
        CoroutineScope(IO).launch {
            try {
                val response = remoteRepository.loginWithCredentials(
                    ACTION_LOGIN,
                    "1.0.0",
                    serverKey,
                    formatToJsonAuth(
                        prefRepository.getUserEmail()!!,
                        prefRepository.getUserPassword()!!
                    )
                )

                Log.e("mTAG", "getSessionIdForUpdateFlag: ${prefRepository.getUserPassword()}")

                if (response.isSuccessful && response.body() != null) {
                    val res = response.body()?.string()?.split("=")
                    if (res != null) {

                        XLog.e("while getting session id for update flag  ${response.body()}")

                        val mainResponse = parseToJsonObjLogin(res[1]) as LoginResponse

                        if (mainResponse.statusCode == 1) {
                            prefRepository.saveLoginResponse(mainResponse)
                            prefRepository.saveSessionId(mainResponse.sessionId!!)
                            updateOrderStatusAtAirMenu(orderId)

                        } else if (mainResponse.errorCode == 109) {

                            sessionOut("getSessionIdForUpdateFlag")  //exit user on login failed

                        }
                    }
                }
            } catch (e: java.lang.Exception) {

                showErrorNotification("SessionIdForUpdateFlag", e.message)

                XLog.e("getSessionId: exception while getting => ${e.message}")
            }
        }
    }

    private fun getSessionIdForUser(body: OrderDetail, result: GoogleAddress.Result?) {
        CoroutineScope(IO).launch {
            try {
                val response = remoteRepository.loginWithCredentials(
                    ACTION_LOGIN,
                    "1.0.0",
                    serverKey,
                    formatToJsonAuth(
                        prefRepository.getUserEmail()!!,
                        prefRepository.getUserPassword()!!
                    )
                )

                Log.e("mTAG", "getSessionIdForUser: ${prefRepository.getUserPassword()}")

                if (response.isSuccessful && response.body() != null) {
                    val res = response.body()?.string()?.split("=")
                    if (res != null) {

                        XLog.e(
                            "getting session id for user ${
                                Gson().toJson(response.body())
                            }"
                        )

                        val mainResponse = parseToJsonObjLogin(res[1]) as LoginResponse

                        if (mainResponse.statusCode == 1) {
                            prefRepository.saveLoginResponse(mainResponse)
                            prefRepository.saveSessionId(mainResponse.sessionId!!)
                            createUserWithChoosenLDE(body, result)

                        } else if (mainResponse.errorCode == 109) {

                            sessionOut("getSessionIdForUser")  //exit user on login failed

                        }
                    }
                }
            } catch (e: java.lang.Exception) {
                showErrorNotification("getSessionId", e.message)
                XLog.e("getSessionId: exception while getting => ${e.message}")
            }
        }
    }

    private fun parseToJsonObjLogin(json: String): LoginResponse? {
        var loginRes: LoginResponse? = null
        val gson = Gson()
        try {
            loginRes = gson.fromJson(json, LoginResponse::class.java)
        } catch (e: Exception) {
            XLog.e("parseToJsonObj: exception $e")
        }
        return loginRes
    }

    private fun parseDenyResponse(json: JSONObject): ExtraInfo2? {
        var response = ExtraInfo2(
            json.getBoolean("ADDRESS"),
            json.getBoolean("CAPACITY"),
            json.getBoolean("ITEM_AVAILABILITY"),
            json.getBoolean("MISSING_INFO"),
            json.getBoolean("MISSING_ITEM"),
            json.getBoolean("OTHER"),
            json.getBoolean("POS_NOT_READY"),
            json.getBoolean("POS_OFFLINE"),
            json.getBoolean("PRICING"),
            json.getBoolean("SPECIAL_INSTRUCTIONS"),
            json.getBoolean("STORE_CLOSED")
        )

        return response
    }

    private fun parseCancelResponse(json: JSONObject): ExtraInfoCancel? {
        var response = ExtraInfoCancel(
            json.getBoolean("OUT_OF_ITEMS"),
            json.getBoolean("RESTAURANT_TOO_BUSY"),
            json.getBoolean("CUSTOMER_CALLED_TO_CANCEL"),
            json.getBoolean("KITCHEN_CLOSED"),
            json.getBoolean("CANNOT_COMPLETE_CUSTOMER_NOTE")
        )

        return response
    }

    private fun formatToJsonAuth(email: String, password: String): String {
        val obj = JsonObject()
        obj.addProperty(KEY_USER_NAME, email)
        obj.addProperty(KEY_USER_PASSWORD, password)
        XLog.e("formatToJsonAuth: $obj")
        return obj.toString()
    }

    private fun getNewOrderJson(): JSONObject {
        val obj = JSONObject()
        obj.put(KEY_SESSION_ID, prefRepository.getSessionId())
        obj.put(KEY_ENTERPRISE_ID, prefRepository.getSelectedEnterpriseId())
        obj.put("posId", prefRepository.getSelectedPOSId())

        XLog.e("getNewOrderJson: $obj")
        return obj
    }

    override fun onCreate() {
        super.onCreate()
        job = Job()
        sessionManager = SessionManager(this)

//        sharedManager = SharedManager.getInstance(this@NotificationService)!!


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startMyOwnForeground()
        } else {
            //todo start something else...
        }

        helper = DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext))

        LocalBroadcastManager.getInstance(this).registerReceiver(
            mMessageReceiver, IntentFilter(
                ACTION_NEW_ORDER
            )
        )

        placesClient = Places.createClient(this)

        updatePOSStatus(true)


    }

    private var mObserver: androidx.lifecycle.Observer<Boolean>? =
        androidx.lifecycle.Observer<Boolean> {
            XLog.i("is internet available? - ${if (it) "Yes" else "No"}")
            if (!mFlag) {
                mFlag = true
                return@Observer
            }
            if (it) {

                Handler(Looper.getMainLooper()).postDelayed(
                    {
                        Log.e(TAG, "inside handler ")
                        if (socket?.isClosed == true && NetworkHelper.isNetworkAvailable(this)) {
                            shouldConnectSocketAgain()
                        } else Log.e(TAG, "else: ")
                    }, 500
                )

            } else {
                if (bufOut != null) {
                    try {
                        bufOut!!.close()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
                if (bufIn != null) {
                    try {
                        bufIn!!.close()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }

                if (socket != null) {
                    try {
                        socket!!.close()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }

        }

    private val mMessageReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) {
            XLog.e("new order received.")
            val message = intent.getSerializableExtra("message") as NotificationMessage


            if (message.notificationId.equals("status")) {
                if (message.time.equals("cancelled")) {
                    CoroutineScope(IO).launch {
                        helper.insertNewUberNotification(
                            UberNotification(
                                0,
                                message.orderId.toString(),
                                message.storeId.toString(),
                                ISO8601.formatDate(message.time?.toLong()!!),
                                ISO8601.formatDate(System.currentTimeMillis()),
                                "Cancelled"
                            )
                        )
                    }
                    updateOrderStatusAtAirMenu(message.orderId)
                }
                return
            }
            CoroutineScope(IO).launch {
                helper.insertNewUberNotification(
                    UberNotification(
                        0,
                        message.orderId.toString(),
                        message.storeId.toString(),
                        ISO8601.formatDate(message.time?.toLong()!!),
                        ISO8601.formatDate(System.currentTimeMillis()),
                        "Created"
                    )
                )
            }
            getOrderDetails(message)
        }
    }

    private fun updateOrderStatusAtAirMenu(orderId: String?) {
        CoroutineScope(IO).launch {
            try {

                val getOrderId = helper.getOrderId(orderId.toString())

                if (getOrderId.isNotEmpty()) {
                    val request = remoteRepository.updateFlags(
                        ACTION_UPDATE_FLAGS,
                        "1.0.0",
                        serverKey,
                        getOrderUpdateAirMenuJson(getOrderId)
                    )

                    if (request.body() != null) {
                        XLog.e("updateOrderStatusAtAirMenu: response=> $request")
                        val res = request.body()?.string()?.split("=")

                        if (res != null) {
                            val jsonObject = JSONObject(res[1])
                            if (jsonObject.getInt(STATUS_CODE) == 1) {
                                XLog.e(
                                    "order status updated at AirMenu => $jsonObject"
                                )
                            } else if (jsonObject.getInt(STATUS_CODE) == -1 && jsonObject.getString(
                                    ERROR_NAME
                                ).equals(
                                    ERROR_SESSION_EXPIRED
                                )
                            ) {
                                getSessionIdForUpdateFlag(orderId)
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                showErrorNotification("updateOrderStatusAtAirMenu", e.message)
                XLog.e("updateOrderStatusAtAirMenu: exception ${e.message}")
            }
        }
    }

    private fun getOrderUpdateAirMenuJson(orderInfo: String): JSONObject {
        val jsonObject = JSONObject()

        jsonObject.put("orderId", orderInfo)
        jsonObject.put("sessionId", prefRepository.getSessionId())
        jsonObject.put("enterpriseId", prefRepository.getSelectedEnterpriseId())
        jsonObject.put("flagKey", "CANCELEDBYUBER")
        jsonObject.put("operatorEmail", "script@airmenu.com")
        jsonObject.put("flagActivationType", "toggle")
        jsonObject.put("asExecutor", "false")
        jsonObject.put("executorEmail", "")

        XLog.e("getOrderUpdateAirMenuJson: $jsonObject")

        return jsonObject

    }

    private fun getOrderDetails(notificationMessage: NotificationMessage) {
        XLog.e("getting order details from Uber for order for id => ${notificationMessage.orderId}")
        sessionManager.uberOrderDetailToken.let {
            if (it != null) {
                ApiClient.token = it
            }
        }

        val request =
            ApiClient.retrofitService.getOrderDetails(notificationMessage.orderId.toString())

        request.enqueue(object : Callback<OrderDetail> {
            override fun onResponse(call: Call<OrderDetail>, response: Response<OrderDetail>) {
                retryCount = 0
                if (response.isSuccessful && response.body() != null) {
                    val gson = Gson()
                    val userString = gson.toJson(response.body())
                    XLog.e("Order Detail response  ${userString}")

                    if (response.body()!!.type.equals("DELIVERY_BY_UBER")) {
                        handleOrderResponse(response.body()!!, false)
                    } else if (response.body()!!.type.equals("PICK_UP")) {
                        handleOrderResponse(response.body()!!)
                    } else {
                        handleOrderResponse(response.body()!!)
                    }

                } else {
                    XLog.e("onResponse: error while getting order details from uber ${response.body()}")
                }
            }

            override fun onFailure(call: Call<OrderDetail>, t: Throwable) {
                retryCount += 1
                XLog.e("onFailure while getting order details: ${t.message}")
                if (t is TimeoutException || t is IOException) {
                    if (retryCount < 3) {
                        XLog.e("retrying getting order details.")
                        getOrderDetails(notificationMessage)
                    }
                }
            }
        })
    }

    private fun handleOrderResponse(body: OrderDetail, b: Boolean) {
        createUserWithChoosenLDE(body, null)
    }

    private fun getOrderDetailsForFutureOrder(
        orderId: String,
        orderjson: JSONObject,
        body: OrderDetail,
        divisionId: String,
        result: GoogleAddress.Result?,
        username: String
    ) {

        try {
            var time = ISO8601.toCalendarGmt(body.placedAt)
            var averageTime = sessionManager.getSelectedStoreDetails()?.avgPrepTime?.times(60000)
            XLog.e("Updating the order timestamp with average time  => ${averageTime}")

            time = time.plus(averageTime!!)

            orderjson.put(KEY_BOOKING_TIME, time)
            XLog.e(
                "estimated time=> ${body.estimatedReadyForPickupAt}\n placed at=> ${body.placedAt} \nafter conversion=> ${
                    ISO8601.toCalendarGmt(
                        body.placedAt
                    )
                }\n final time=> $time"
            )
            placeOrderAtAirMenu(orderjson, divisionId, body, result, username)
        } catch (e: Exception) {
            showErrorNotification("getOrderDetailsForFutureOrder", e.message)
            XLog.e("Exception while adding the average time to meantime ${e.message}")
        }


    }

    override fun onDestroy() {
        XLog.d("onDestroy: in service")

        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver)

        mObserver = null

        if (bufOut != null) {
            try {
                bufOut!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        if (bufIn != null) {
            try {
                bufIn!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        if (socket != null) {
            try {
                socket!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        sessionManager.isServiceRunning = false

        updatePOSStatus(false)

        super.onDestroy()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun startMyOwnForeground() {
        val notificationChannelId = packageName.toString()
        val channelName = "Redialing service start"
        val chan = NotificationChannel(
            notificationChannelId,
            channelName,
            NotificationManager.IMPORTANCE_LOW
        )
        val notificationIntent = Intent(applicationContext, HomeActivity::class.java)

        notificationIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP

        val contentIntent = PendingIntent.getActivity(
            this,
            System.currentTimeMillis().toInt(),
            notificationIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        chan.lightColor = Color.BLUE
        chan.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        val manager = (getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)
        manager.createNotificationChannel(chan)
        val notificationBuilder: NotificationCompat.Builder =
            NotificationCompat.Builder(this, notificationChannelId)
        val notification: Notification = notificationBuilder.setOngoing(false)
            .setContentTitle("Socket connection in progress")
            .setAutoCancel(true)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentIntent(contentIntent)
            .setPriority(NotificationManager.IMPORTANCE_LOW)
            .setCategory(Notification.CATEGORY_SERVICE)
            .build()
        startForeground(2, notification)
    }

    private fun startPingCycle(bufOut: BufferedWriter?) {
        val pingTimer = Timer()
        val PING_PERIOD: Long = 1000 * 60 * 3
        pingTimer.schedule(object : TimerTask() {
            override fun run() {
                if (bufOut != null) {
                    try {
                        XLog.e("run: ping call")
                        bufOut.write(PING_MESSAGE)
                        bufOut.newLine()
                        bufOut.flush()
                    } catch (e: IOException) {
                        XLog.d("run: run exception ${e.message}")
                        try {
                            pingTimer.cancel()
                        } catch (ex: Exception) {
                            ex.printStackTrace()
                        }
                        e.printStackTrace()
                        try {
                            if (socket != null) socket!!.close()
                        } catch (ex: Exception) {
                            ex.printStackTrace()
                        }
                    }
                } else {
                    XLog.d("buffer output was null,  stopping the timer.")
                    try {
                        pingTimer.cancel()
                    } catch (ex: Exception) {
                        ex.printStackTrace()
                    }
                    try {
                        if (socket != null) socket!!.close()
                    } catch (ex: Exception) {
                        ex.printStackTrace()
                    }
                }

            }
        }, PING_PERIOD, PING_PERIOD)
    }

    private fun handleOrderResponse(body: OrderDetail) {
        XLog.e("handling order details...")
        if (prefRepository.getSelectedDivisionId().equals("divisionByCustomerAddress")) {
            XLog.e("getting user address from GooglePlaces")
            if (body.eater.delivery.location.type.equals("GOOGLE_PLACE")) {

                CoroutineScope(IO).launch {
                    try {
                        val response =
                            remoteRepository.getAddressByPlaceId(body.eater.delivery.location.googlePlaceId)

                        if ((response.isSuccessful && response.body() != null)) {
                            if (response.body()!!.status.equals("OK") && response.body()!!.result != null) {
                                getDivisionIdByUserAddress(response.body()!!.result, body)
                            }
                        }

                    } catch (e: Exception) {
                        XLog.e("exception getting lat-lang $e")
                    }
                }

            }
        } else {

            try {

                if (body.eater.delivery.location.type.equals("GOOGLE_PLACE")) {
                    XLog.e("getting user address from GooglePlaces")

                    CoroutineScope(IO).launch {
                        try {
                            val response =
                                remoteRepository.getAddressByPlaceId(body.eater.delivery.location.googlePlaceId)

                            if ((response.isSuccessful && response.body() != null)) {
                                if (response.body()!!.status.equals("OK") && response.body()!!.result != null) {
                                    createUserWithChoosenLDE(body, response.body()!!.result)
                                }
                            }

                        } catch (e: Exception) {
                            XLog.e("exception getting lat-lang $e")
                        }
                    }

                }


            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }

//    E/HomeActivity: FetchPlaceResponse{place=Place{address=242 Hagley Rd, Hayley Green, Halesowen B63 1EF, UK
//    , addressComponents=null, businessStatus=null, attributions=[]
//    , id=ChIJWwHBaVGRcEgRMcxio7mC9hs, latLng=null, name=242 Hagley Rd
//    , openingHours=null, phoneNumber=null, photoMetadatas=null
//    , plusCode=PlusCode{compoundCode=CWP7+27 Halesowen, UK, globalCode=9C4VCWP7+27}
//    , priceLevel=null, rating=null, types=null, userRatingsTotal=null
//    , utcOffsetMinutes=null, viewport=null, websiteUri=null}}

    private fun createUserWithChoosenLDE(body: OrderDetail, result: GoogleAddress.Result?) {
        XLog.e("createUserWithChoosenLDE: createing user with choosen lde")

        CoroutineScope(IO).launch {
            try {
                val username = body.eaters[0].id + "@anonymous.com"
                var mphone = body.eater.phone.replace("+", "")
                mphone = mphone.replace(" ", "")
                val mPhoneCode = body.eater.phoneCode.replace(" ", "")

//                val nifCipherText = body.eater.nifTaxId.nifCipherText
//                val nifSymmetricKey = body.eater.nifTaxId.nifKey

//                val nifCipherText = RSA_cipher.CipherText
//                val nifSymmetricKey = RSA_cipher.SymmetricKey
//
//                if (nifCipherText != null && nifSymmetricKey != null){
//                    val rsaCipher = RSA_cipher(
//                        this@NotificationService,
//                        nifSymmetricKey,
//                        nifCipherText
//                    )
//                    try {
//                        rsaCipher.decryptedNif()
//                    } catch (e: Exception) {
//                    }
//                }

                val response = remoteRepository.createUser(
                    ACTION_CREATE_USER,
                    "1.0.0",
                    serverKey,
                    createUserJson(
                        body.eater.firstName,
                        body.eater.lastName,
                        result,
                        mphone,
                        mPhoneCode,
                        username
                    )
                )

                if (response.isSuccessful && response.body() != null) {
                    val res = response.body()?.string()?.split("=")
                    if (res != null) {
                        val jsonObject = JSONObject(res[1])
                        val statusCode = jsonObject.getInt(STATUS_CODE)
                        XLog.e("createUser response => $jsonObject")
                        if (statusCode == 1) {
                            XLog.e("createUserWithChoosenLDE: status code 1")
                            placeOrderAtAirMenu(
                                getOrderjson(
                                    prefRepository.getSelectedDivisionId().toString(),
                                    body,
                                    result,
                                    username
                                ),
                                prefRepository.getSelectedDivisionId().toString(),
                                body,
                                result, username
                            )
                        } else if (statusCode == -1) {
                            XLog.e("createUserWithChoosenLDE: status code --1")
                            val errorName = jsonObject.getString(ERROR_NAME)

                            if (errorName.equals(ERROR_USER_ALREADY_EXISTS)) {
                                XLog.e("user already exists")
                                placeOrderAtAirMenu(
                                    getOrderjson(
                                        prefRepository.getSelectedDivisionId().toString(),
                                        body,
                                        result,
                                        username
                                    ),
                                    prefRepository.getSelectedDivisionId().toString(),
                                    body,
                                    result, username
                                )
                            } else if (errorName.equals("INVALID_SESSION")) {
                                getSessionIdForUser(body, result)
                            } else if (errorName.equals("INVALID_PARAMETER")) {
                                CoroutineScope(Main).launch {
                                    AlertsDialogue().AlertsDialogue(
                                        this@NotificationService,
                                        "Error while creating user.",
                                        jsonObject.getString("message")
                                    )
                                }
                            }
                        }
                    }
                }

            } catch (e: Exception) {
//                showErrorNotification("createUserWithCustomLDE", e.message)
                XLog.e(
                    "createUserWithCustomLDE: exception while creating user ${e.message}"
                )
            }
        }
    }

    private fun getDivisionIdByUserAddress(result: GoogleAddress.Result, body: OrderDetail) {
        XLog.e("getting DivisionId by Address...")

        CoroutineScope(IO).launch {

            try {
                val response = remoteRepository.getLocationDivisionEnterprises(
                    ACTION_LOCATION_DIVISION_ENTERPRISES,
                    "1.0.0",
                    serverKey,
                    getLocationDivisionJson(
                        prefRepository.getSessionId(),
                        prefRepository.getSelectedEnterpriseId(),
                        result
                    )
                )

                if (response.isSuccessful && response.body() != null) {
                    val res = response.body()?.string()?.split("=")
                    if (res != null) {
                        val mainResponse = parseLDEResponse(res[1])
                        XLog.e(
                            "Division id by user addres response=> ${
                                response.body().toString()
                            }"
                        )
                        if (mainResponse?.statusCode == 1) {
                            createUserWithCustomLDE(mainResponse, body, result)
                        } else if (mainResponse?.statusCode == -1) {
                            getSessionIdForLDE(body, result)
                        }

                    }
                }
            } catch (e: Exception) {
                showErrorNotification("getDivisionIdByUserAddress", e.message)
                XLog.e("got exception from diviosn enterprise id => ${e.message}")
            }
        }

    }

    private fun getSessionIdForLDE(body: OrderDetail, result: GoogleAddress.Result) {
        XLog.e("updating session id for LDE...")
        CoroutineScope(IO).launch {
            try {
                val response = remoteRepository.loginWithCredentials(
                    ACTION_LOGIN,
                    "1.0.0",
                    serverKey,
                    formatToJsonAuth(
                        prefRepository.getUserEmail()!!,
                        prefRepository.getUserPassword()!!
                    )
                )

                Log.e("mTAG", "getSessionIdForLDE: ${prefRepository.getUserPassword()}")

                if (response.isSuccessful && response.body() != null) {
                    val res = response.body()?.string()?.split("=")
                    if (res != null) {
                        val mainResponse = parseToJsonObjLogin(res[1]) as LoginResponse

                        if (mainResponse.statusCode == 1) {
                            prefRepository.saveLoginResponse(mainResponse)
                            prefRepository.saveSessionId(mainResponse.sessionId!!)
                            getDivisionIdByUserAddress(result, body)

                        } else if (mainResponse.errorCode == 109) {

                            sessionOut("getSessionIdForLDE")  //exit user on login failed

                        } else {
                            Handler(Looper.getMainLooper()).postDelayed(
                                {
                                    getSessionIdForLDE(body, result)
                                }, 3000
                            )

                        }
                    }
                }
            } catch (e: Exception) {
                showErrorNotification("getSessionId", e.message)
                XLog.e("getSessionId: exception while getting => ${e.message}")
            }
        }
    }

    private fun createUserWithCustomLDE(
        mainResponse: LocationDivisionEnterpriseResponse,
        body: OrderDetail,
        result: GoogleAddress.Result
    ) {
        XLog.e("creating new user with CustomLDE.")
        CoroutineScope(IO).launch {
            try {
                val username = body.eaters[0].id + "@anonymous.com"

                var mphone = body.eater.phone.replace("+", "")
                mphone = mphone.replace(" ", "")
                val mPhoneCode = body.eater.phoneCode.replace(" ", "")

//                val nifCipherText = body.eater.nifTaxId.nifCipherText
//                val nifSymmetricKey = body.eater.nifTaxId.nifKey
//                val nifCipherText = RSA_cipher.CipherText
//                val nifSymmetricKey = RSA_cipher.SymmetricKey
//
//                if (nifCipherText != null && nifSymmetricKey != null){
//                    val rsaCipher = RSA_cipher(
//                        this@NotificationService,
//                        nifSymmetricKey,
//                        nifCipherText
//                    )
//                    try {
//                        rsaCipher.decryptedNif()
//                    } catch (e: Exception) {
//                    }
//                }

                val response = remoteRepository.createUser(
                    ACTION_CREATE_USER,
                    "1.0.0",
                    serverKey,
                    createUserJson(
                        body.eater.firstName,
                        body.eater.lastName,
                        result,
                        mphone,
                        mPhoneCode,
                        username
                    )
                )

                if (response.isSuccessful && response.body() != null) {
                    val res = response.body()?.string()?.split("=")
                    if (res != null) {
                        val jsonObject = JSONObject(res[1])
                        val statusCode = jsonObject.getInt(STATUS_CODE)
                        if (statusCode == 1) {
                            XLog.e("user created status code 1")
                            placeOrderAtAirMenu(
                                getOrderjson(
                                    mainResponse.foundDivisionsIdAndName[0].id,
                                    body,
                                    result,
                                    username
                                ),
                                mainResponse.foundDivisionsIdAndName[0].id,
                                body,
                                result, username
                            )
                        } else if (statusCode == -1) {
                            XLog.e("user not created. status code -1")
                            val errorName = jsonObject.getString(ERROR_NAME)
                            if (errorName.equals(ERROR_USER_ALREADY_EXISTS)) {
                                XLog.e("user already exists")
                                placeOrderAtAirMenu(
                                    getOrderjson(
                                        mainResponse.foundDivisionsIdAndName[0].id,
                                        body,
                                        result,
                                        username
                                    ),
                                    mainResponse.foundDivisionsIdAndName[0].id,
                                    body,
                                    result,
                                    username
                                )
                            } else if (errorName.equals(ERROR_SESSION_EXPIRED)) {
                                getSessionIdForCustomLDE(mainResponse, body, result)
                            }
                        }
                    }
                }

            } catch (e: Exception) {

                showErrorNotification("createUserWithCustomLDE", e.message)

                XLog.e(
                    "createUserWithCustomLDE: exception while creating user ${e.message}"
                )
            }
        }

    }

    private fun getSessionIdForCustomLDE(
        mainResponse1: LocationDivisionEnterpriseResponse,
        body: OrderDetail,
        result: GoogleAddress.Result
    ) {
        XLog.e("updating session id for CustomLDE...")
        CoroutineScope(IO).launch {
            try {
                val response = remoteRepository.loginWithCredentials(
                    ACTION_LOGIN,
                    "1.0.0",
                    serverKey,
                    formatToJsonAuth(
                        prefRepository.getUserEmail()!!,
                        prefRepository.getUserPassword()!!
                    )
                )

                Log.e("mTAG", "getSessionIdForCustomLDE: ${prefRepository.getUserPassword()}")

                if (response.isSuccessful && response.body() != null) {
                    val res = response.body()?.string()?.split("=")
                    if (res != null) {
                        val mainResponse = parseToJsonObjLogin(res[1]) as LoginResponse

                        Log.e("mTAG", "getSessionIdForCustomLDE: ${mainResponse.errorCode}")

                        if (mainResponse.statusCode == 1) {
                            prefRepository.saveLoginResponse(mainResponse)
                            prefRepository.saveSessionId(mainResponse.sessionId!!)

                            createUserWithCustomLDE(mainResponse1, body, result)
                        } else if (mainResponse.errorCode == 109) {

                            sessionOut("getSessionIdForCustomLDE")  //exit user on login failed

                        } else {
                            Handler(Looper.getMainLooper()).postDelayed(
                                {
                                    getSessionIdForCustomLDE(mainResponse1, body, result)
                                }, 3000
                            )

                        }
                    }
                }
            } catch (e: Exception) {
                showErrorNotification("getSessionIdForCustomLDE", e.message)
                XLog.e("getSessionId: exception while getting => ${e.message}")
            }
        }
    }

    private fun placeOrderAtAirMenu(
        orderjson: JSONObject,
        divisionId: String,
        body: OrderDetail,
        result: GoogleAddress.Result?,
        username: String
    ) {
        XLog.e("placing new order at Airmenue... \n $orderjson")

        CoroutineScope(IO).launch {
            try {
                val response = remoteRepository.placeOrder(
                    ACTION_SEND_ORDER,
                    "1.0.0",
                    serverKey,
                    orderjson
                )

                if (response.isSuccessful && response.body() != null) {
                    val res = response.body()?.string()?.split("=")
                    if (res != null) {
                        val jsonObject = JSONObject(res[1])
                        val statusCode = jsonObject.getInt(STATUS_CODE)
                        XLog.e("response=> $jsonObject")
                        if (statusCode == 1) {
                            XLog.e("order placed successfully at Airmenu")
                            val orderId = jsonObject.getString("orderId")
                            val orderinfo = OrderInfo(0, orderId, body.id, "none")

                            CoroutineScope(IO).launch {
                                helper.insertOrderInfo(orderinfo)
                            }
                        } else if (statusCode == -1) {
                            if (jsonObject.getString(ERROR_NAME).equals(ERROR_SESSION_EXPIRED)) {
                                updateSessionIdForNewOrder(
                                    orderjson,
                                    divisionId,
                                    body,
                                    result,
                                    username
                                )
                            } else if (jsonObject.getString(ERROR_NAME)
                                    .equals("INVALID_PARAMETER")
                            ) {
                                if (AppState.errorCount == 3) {
                                    CoroutineScope(Main).launch {
                                        Toast.makeText(
                                            this@NotificationService,
                                            "App stuck in loop of createMenu, stopping......",
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }
                                    AppState.errorCount = 0
                                    this@NotificationService.stopSelf()
                                    HomeActivity.onServiceError?.invoke("App stuck in loop of createMenu, stopping......")
                                } else {
                                    AppState.errorCount += 1
                                }
                                XLog.e("Got error invalid parameter...")
                                CoroutineScope(Main).launch {
                                    Toast.makeText(
                                        this@NotificationService,
                                        "Error ${jsonObject.getString("message")}",
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                                val property = jsonObject.getString(PROPERTY)
                                if (property.equals("pluList")) {
                                    placeAlertOrder(
                                        orderjson,
                                        divisionId,
                                        body,
                                        result,
                                        username
                                    )
                                } else if (jsonObject.getString("message")
                                        .equals("Booking details are invalid.")
                                ) {
                                    XLog.e("Updating time manually...")
                                    // should get order details again.
                                    getOrderDetailsForFutureOrder(
                                        body.id,
                                        orderjson,
                                        body,
                                        divisionId,
                                        result,
                                        username
                                    )
                                }
                            } else {
                                XLog.e("Got error for PLU list property...")
                                CoroutineScope(Main).launch {
                                    Toast.makeText(
                                        this@NotificationService,
                                        "Error ${jsonObject.getString("message")}",
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                                val property = jsonObject.getString(PROPERTY)
                                if (property.equals("pluList")) {
                                    placeAlertOrder(
                                        orderjson,
                                        divisionId,
                                        body,
                                        result,
                                        username
                                    )

                                }
                            }

                        }
                    }
                }
            } catch (e: Exception) {
                showErrorNotification("placeOrderAtAirMenu", e.message)
                XLog.e("exception in sendOrder to Airmenu ${e.message}")
            }
        }

    }

    private fun placeAlertOrder(
        orderjson: JSONObject,
        divisionId: String,
        body: OrderDetail,
        result: GoogleAddress.Result?,
        username: String
    ) {
        val previousPlulist = orderjson.getJSONArray("pluList")
        val newPluList = JSONArray()
        for (i in 0..previousPlulist.length() - 1) {
            val objec = previousPlulist.get(i) as JSONObject
            if (objec.getString("plu").equals("TYPE")) {
                newPluList.put(previousPlulist.get(i))
            } else {
                val formsObjectType = JSONObject()
                formsObjectType.put("obs", "Missing item, Please check Uber Dashboard")

                val alterObject = JSONObject()
                alterObject.put("plu", "AlterOrder")
                alterObject.put("count", 1)
                alterObject.put("forms", formsObjectType)
                newPluList.put(alterObject)
            }
        }

        orderjson.put("pluList", newPluList)
        placeOrderAtAirMenu(
            orderjson,
            divisionId,
            body,
            result,
            username
        )
    }

    private fun updateSessionIdForNewOrder(
        orderjson: JSONObject,
        divisionId: String,
        body: OrderDetail,
        result: GoogleAddress.Result?,
        username: String
    ) {
        XLog.e("updating session id for NewOrder...")
        CoroutineScope(IO).launch {
            try {
                val response = remoteRepository.loginWithCredentials(
                    ACTION_LOGIN,
                    "1.0.0",
                    serverKey,
                    formatToJsonAuth(
                        prefRepository.getUserEmail()!!,
                        prefRepository.getUserPassword()!!
                    )
                )


                Log.e("mTAG", "updateSessionIdForNewOrder: ${prefRepository.getUserPassword()}")


                if (response.isSuccessful && response.body() != null) {
                    val res = response.body()?.string()?.split("=")
                    if (res != null) {
                        val mainResponse = parseToJsonObjLogin(res[1]) as LoginResponse

                        if (mainResponse.statusCode == 1) {
                            prefRepository.saveLoginResponse(mainResponse)
                            prefRepository.saveSessionId(mainResponse.sessionId!!)

                            placeOrderAtAirMenu(
                                orderjson,
                                divisionId,
                                body,
                                result,
                                username
                            )
                        } else if (mainResponse.errorCode == 109) {

                            sessionOut("updateSessionIdForNewOrder")  //exit user on login failed

                        } else {
                            Handler(Looper.getMainLooper()).postDelayed(
                                {
                                    updateSessionIdForNewOrder(
                                        orderjson, divisionId, body, result, username
                                    )
                                }, 3000
                            )

                        }
                    }
                }
            } catch (e: Exception) {
                showErrorNotification("updateSessionIdForNewOrder", e.message)
                XLog.e("getSessionId: exception while getting => ${e.message}")
            }
        }
    }

    private fun createMenuAtAirMenu(
        divisionId: String,
        body: OrderDetail,
        result: GoogleAddress.Result?,
        orderjson: JSONObject,
        username: String
    ) {
        XLog.e("creating menu at Airmenu...")

        CoroutineScope(IO).launch {
            try {
                val response = remoteRepository.createMenu(
                    ACTION_SAVE_MENU,
                    "1.0.0",
                    serverKey,
                    getCreateMenuJson(body)
//                    getCreateMissingMenuJson(body)
                )

                if (response.isSuccessful && response.body() != null) {
                    val res = response.body()?.string()?.split("=")
                    if (res != null) {
                        try {
                            val jsonObject = JSONObject(res[1])
                            val statusCode = jsonObject.getInt(STATUS_CODE)
                            if (statusCode == 1) {
                                XLog.e("menu created successfully")
                                placeOrderAtAirMenu(
                                    orderjson,
                                    divisionId,
                                    body,
                                    result,
                                    username
                                )
                            } else if (statusCode == -1 && jsonObject.getString(ERROR_NAME).equals(
                                    ERROR_SESSION_EXPIRED
                                )
                            ) {
                                XLog.e(
                                    "couldn't create menu => ${jsonObject.getString("message")}"
                                )

                                getSessionIdForSaveMenu(
                                    divisionId,
                                    body,
                                    result,
                                    orderjson,
                                    username
                                )


                            }
                        } catch (e: Exception) {
                            XLog.e("exception while conveting to json=> $e")
                        }
                    }
                }

            } catch (e: Exception) {
                XLog.e("exception while creating menu => ${e.message}")
            }
        }

    }

    private fun getSessionIdForSaveMenu(
        divisionId: String,
        body: OrderDetail,
        result: GoogleAddress.Result?,
        orderjson: JSONObject,
        username: String
    ) {
        XLog.e("Updating session id for saveMenu...")
        CoroutineScope(IO).launch {
            try {
                val response = remoteRepository.loginWithCredentials(
                    ACTION_LOGIN,
                    "1.0.0",
                    serverKey,
                    formatToJsonAuth(
                        prefRepository.getUserEmail()!!,
                        prefRepository.getUserPassword()!!
                    )
                )

                Log.e("mTAG", "getSessionIdForSaveMenu: ${prefRepository.getUserPassword()}")

                if (response.isSuccessful && response.body() != null) {
                    val res = response.body()?.string()?.split("=")
                    if (res != null) {
                        val mainResponse = parseToJsonObjLogin(res[1]) as LoginResponse

                        if (mainResponse.statusCode == 1) {
                            prefRepository.saveLoginResponse(mainResponse)
                            prefRepository.saveSessionId(mainResponse.sessionId!!)

                            createMenuAtAirMenu(divisionId, body, result, orderjson, username)
                        } else if (mainResponse.errorCode == 109) {

                            sessionOut("getSessionIdForSaveMenu")  //exit user on login failed

                        } else {
//                            Handler(Looper.getMainLooper()).postDelayed(
//                                {
//                                    updateSessionId(api)
//                                }, 3000
//                            )

                        }
                    }
                }
            } catch (e: Exception) {
                showErrorNotification("getSessionIdForSaveMenu", e.message)
                XLog.e("getSessionId: exception while getting => ${e.message}")
            }
        }
    }

    fun getCreateMenuJson(body: OrderDetail): JSONObject {

        Log.e(TAG, "getCreateMenuJson: Create Menu JSON called")

        val mainObject = JSONObject()

        val menuInstanceObject = JSONObject()
        menuInstanceObject.put("title", "Menu")
        menuInstanceObject.put("menuRelation", "family")

        mainObject.put(KEY_SESSION_ID, prefRepository.getSessionId())
        mainObject.put(KEY_ENTERPRISE_ID, prefRepository.getSelectedDivisionIdMenu())
        mainObject.put(KEY_DIVISION_ID, prefRepository.getSelectedDivisionId())
        mainObject.put("menuInstance", menuInstanceObject)

        val childsArray = JSONArray()

        body.cart.items.forEach {
            val itemObject = JSONObject()
            if (!it.externalData.isNullOrEmpty()) {
                itemObject.put("plu", it.externalData)

            } else {
                itemObject.put("plu", it.id)

            }
            itemObject.put("title", it.title)
            itemObject.put("menuRelation", "item")
            Log.e(TAG, "getCreateMenuJson: item price ${it.price.unitPrice.amount / 100}")


            itemObject.put(
                "price",
                it.price.unitPrice.amount.toDouble() / 100
            )


            if (!it.selectedModifierGroups.isNullOrEmpty()) {
                val complementArray = JSONArray()

                it.selectedModifierGroups.forEach { modifires ->

                    Log.e(TAG, "getCreateMenuJson: inside for each")
                    val complementObject = JSONObject()

                    complementObject.put("menuRelation", "complement")
                    complementObject.put("min", 0)
                    complementObject.put("max", 999)
                    if (!modifires.externalData.isNullOrEmpty()) {
                        complementObject.put("plu", modifires.externalData)

                    } else {
                        complementObject.put("plu", modifires.id)

                    }
                    complementObject.put("title", modifires.title)

                    val complemenItemArray = JSONArray()

                    modifires.selectedItems.forEach {
                        val complementItemObject = JSONObject()
                        if (!it.externalData.isNullOrEmpty()) {
                            complementItemObject.put("plu", it.externalData)

                        } else {
                            complementItemObject.put("plu", it.id)

                        }
                        complementItemObject.put("title", it.title)

                        complementItemObject.put(
                            "price",
                            it.price.unitPrice.amount.toDouble() / 100
                        )


                        complementItemObject.put("menuRelation", "complementItem")
                        complemenItemArray.put(complementItemObject)

                    }
                    complementObject.put("childs", complemenItemArray)

                    complementArray.put(complementObject)

                }

                itemObject.put("childs", complementArray)
            }
            childsArray.put(itemObject)
        }

        menuInstanceObject.put("childs", childsArray)


        XLog.e("createMenuJson => $mainObject")

        return mainObject
    }

    fun getCreateMissingMenuJson(body: OrderDetail): JSONObject {

        val mainObject = JSONObject()
        val menuInstanceObject = JSONObject()
        val childObject = JSONObject()
        val childsArray = JSONArray()
        val thirdChildObject = JSONObject()
        val thirdChildArray = JSONArray()

        mainObject.put(KEY_SESSION_ID, prefRepository.getSessionId())
        mainObject.put(KEY_ENTERPRISE_ID, prefRepository.getSelectedDivisionIdMenu())
        mainObject.put(KEY_DIVISION_ID, prefRepository.getSelectedDivisionId())

        menuInstanceObject.put("title", "Menu")
        menuInstanceObject.put("plu", "Menu")
        menuInstanceObject.put("menuRelation", "family")
        mainObject.put("menuInstance", menuInstanceObject)


        body.cart.items.forEach {

            if (!it.externalData.isNullOrEmpty()) {
                thirdChildObject.put("plu", it.externalData)
            } else {
                thirdChildObject.put("plu", it.id)
            }

            thirdChildObject.put("title", it.title)
            thirdChildObject.put("menuRelation", "item")
            thirdChildObject.put("price", it.price.unitPrice.amount.toDouble() / 100)
        }


        thirdChildArray.put(thirdChildObject)

        childObject.put("plu", "MissingItems")
        childObject.put("title", "MissingItems")
        childObject.put("menuRelation", "family")
        childObject.put("childs", thirdChildArray)
        childsArray.put(childObject)

        menuInstanceObject.put("childs", childsArray)


        XLog.e("createMenuJson => $mainObject")

        return mainObject
    }


    fun getOrderjson(
        id: String,
        body: OrderDetail,
        result: GoogleAddress.Result?,
        username: String
    ): JSONObject {
        val obj = JSONObject()
        val pluList = JSONArray()


        body.cart.items.forEach {
            val pluObject = JSONObject()
            if (!it.externalData.isNullOrEmpty()) {
                pluObject.put("plu", it.externalData)
            } else {
                pluObject.put("plu", it.id)
            }
            pluObject.put("count", it.quantity)


            if (!it.instructions.isNullOrEmpty()) {
                val formsObjectMain = JSONObject()
                formsObjectMain.put(
                    "obs",
                    "${it.instructions}"
                )
                pluObject.put("forms", formsObjectMain)
            }

            if (!it.selectedModifierGroups.isNullOrEmpty()) {
                val childPluList = JSONArray()
                it.selectedModifierGroups.forEach {
                    if (!it.selectedItems.isNullOrEmpty()) {
                        for (i in 0..it.selectedItems.get(0).quantity - 1) {
                            if (!it.selectedItems[0].externalData.isNullOrEmpty()) {
                                childPluList.put(it.selectedItems[0].externalData)

                            } else {
                                childPluList.put(it.selectedItems[0].id)

                            }
                        }
                    }
                }
                pluObject.put(KEY_CHHILD_PLU_LIST, childPluList)
            }


            pluList.put(pluObject)
        }

        val formsObjectMain = JSONObject()
        if (!body.cart.instructions.isNullOrEmpty()) {
            Log.e(TAG, "getOrderjson: adding the instructions")
            formsObjectMain.put(
                "obs",
                "${body.cart.instructions}"
            )
        }

        formsObjectMain.put("uberOrder", body.id)

        obj.put("forms", formsObjectMain)

        val formsObjectType = JSONObject()
        formsObjectType.put("desc", body.type)

        val typeObject = JSONObject()
        typeObject.put("plu", "TYPE")
        typeObject.put("count", 1)
        typeObject.put("forms", formsObjectType)

        pluList.put(typeObject)

        if (body.payment.promotions != null && body.payment.promotions.promotions != null) {
            if (body.payment.promotions.promotions.isNotEmpty()) {

                body.payment.promotions.promotions.forEach {
                    val promotionObject = JSONObject()
                    promotionObject.put("plu", "PROMO")
                    val forms = JSONObject()
                    forms.put("value", it.promoDiscountValue.toDouble() / 100)
                    forms.put("promoName", it.promoType)
                    promotionObject.put("forms", forms)
                    pluList.put(promotionObject)
                }

            }
        }

        obj.put(KEY_SESSION_ID, prefRepository.getSessionId())
        obj.put(KEY_ENTERPRISE_ID, prefRepository.getSelectedEnterpriseId())
        obj.put(KEY_DIVISION_ID, id)
        obj.put(KEY_BOOKING_TIME, ISO8601.toCalendarGmt(body.estimatedReadyForPickupAt))
        obj.put(KEY_USERNAME, username)
        obj.put(KEY_PLU_LIST, pluList)
        XLog.e(
            "orignal time=> ${body.estimatedReadyForPickupAt} after conversion=> ${
                ISO8601.toCalendarGmt(
                    body.estimatedReadyForPickupAt
                )
            }"
        )
        XLog.e("final order object =>\n $obj")
        return obj


    }

    private fun createUserJson(
        firstName: String,
        lastName: String,
        result: GoogleAddress.Result?,
        phone: String,
        phoneCode: String,
        username: String
    ): JSONObject {
        val obj = JSONObject()
        val addressFormObject = JSONObject()

        if (result != null) {

            addressFormObject.put("address", result.formattedAddress)

            if (!result.addressComponents.isNullOrEmpty()) {
                result.addressComponents.forEach {
                    if (it.types.contains("postal_code")) {
                        addressFormObject.put("postalCode", it.longName)
                    }
                }
            }
        }

//        var mphone = phone.replace("+", "")
//        mphone = mphone.replace(" ", "")

        addressFormObject.put("phone", phone)
        addressFormObject.put("phone2", phoneCode)

        // if (countryCode != null)
        addressFormObject.put("countryCode", sessionManager.getSelectedStore()?.location?.country)


        obj.put(KEY_SESSION_ID, prefRepository.getSessionId())
        obj.put(KEY_ENTERPRISE_ID, prefRepository.getSelectedEnterpriseId())
        obj.put("username", username)
        obj.put("password", UBER_NEW_USER_PASSWORD)
        obj.put("firstName", firstName)
        obj.put("lastName", lastName)
        obj.put("addressForm", addressFormObject)

        val userFormObject = JSONObject()
        userFormObject.put("name", firstName + " " + lastName)
        userFormObject.put("nif", "123456789")

        obj.put("userForm", userFormObject)
        XLog.e("createUserJson: $obj")
        return obj
    }

    private fun parseLDEResponse(json: String): LocationDivisionEnterpriseResponse? {
        var res: LocationDivisionEnterpriseResponse? = null
        val gson = Gson()
        try {
            res = gson.fromJson(json, LocationDivisionEnterpriseResponse::class.java)
        } catch (e: Exception) {
            XLog.e("parseLDEResponse: exception $e")
        }
        return res
    }

    private fun parseOrders(json: String): MutableList<AirMenuOrders.Orders.OrdDtl> {
        val mainObject = JSONObject(json)
        val ordersObject = mainObject.get("orders") as JSONObject
        val orders = mutableListOf<AirMenuOrders.Orders.OrdDtl>()
        ordersObject.keys().forEach {
            val countryArray = ordersObject.getJSONArray(it) as JSONArray
            for (i in 0..countryArray.length() - 1) {
                var res: AirMenuOrders.Orders.OrdDtl? = null
                val gson = Gson()
                try {
                    res = gson.fromJson(
                        countryArray[i].toString(),
                        AirMenuOrders.Orders.OrdDtl::class.java
                    )
                    orders.add(res)
                } catch (e: Exception) {
                    XLog.e("parseOrderResponse: exception $e")
                }
            }
        }
        Log.e(TAG, "parseOrders: ${json.length}")
        return orders
    }


    private fun getLocationDivisionJson(
        sessionId: String?,
        enterpriseId: String?,
        result: GoogleAddress.Result
    ): String {
        val obj = JSONObject()
        obj.put(KEY_SESSION_ID, sessionId)
        obj.put(KEY_ENTERPRISE_ID, enterpriseId)
        obj.put("latitude", result.geometry.location.lat)
        obj.put("longitude", result.geometry.location.lng)

        XLog.e("getLocationDivisionJson: $obj")
        return obj.toString()
    }

    private fun parseToJsonObjNotification(json: String): NotificationAccessResponse? {
        var res: NotificationAccessResponse? = null
        val gson = Gson()
        try {
            res = gson.fromJson(json, NotificationAccessResponse::class.java)
        } catch (e: Exception) {
            XLog.e("parseToJsonObj: exception $e")
        }
        return res
    }

    private fun formatToJsonNotification(
        sessionId: String?,
        enterpriseId: String?,
        posId: String?
    ): String {
        val obj = JsonObject()
        obj.addProperty(KEY_SESSION_ID, sessionId)
        obj.addProperty(KEY_ENTERPRISE_ID, enterpriseId)
        obj.addProperty("posId", posId)
        XLog.e("formatToJson: $obj")
        return obj.toString()
    }

    fun showMessage(title: String?, messageStr: String) {
        AlertDialog.Builder(this@NotificationService)
            .setTitle(title)
            .setMessage(messageStr) // Specifying a listener allows you to take an action before dismissing the dialog.
            // The dialog is automatically dismissed when a dialog button is clicked.
            .setPositiveButton("OK",
                DialogInterface.OnClickListener { dialog, which ->
                    // Continue with delete operation
                }) // A null listener allows the button to dismiss the dialog and take no further action.
            //  .setNegativeButton("No", null)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .show()
    }

    private fun updatePOSStatus(status: Boolean) {
        Log.e(TAG, "updatePOSStatus: called")

        if (!sessionManager.getStoreToken().isEmpty()) {

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {

                val token = "Bearer " + sessionManager.getStoreToken()
                val jsonObject = JSONObject()
                jsonObject.put("pos_integration_enabled", status)

                Log.e(TAG, "updatePOSStatus: ${sessionManager.getSelectedStore()!!.storeId}")

                val request: JsonObjectRequest = object :
                    JsonObjectRequest(
                        Method.PATCH,
                        "${BuildConfig.BASE_URL}v1/eats/stores/${sessionManager.getSelectedStore()?.storeId.toString()}/pos_data",
                        jsonObject,
                        com.android.volley.Response.Listener { response ->
                            Log.e("Response ", response!!.toString())
                        },
                        com.android.volley.Response.ErrorListener { error ->
                            Log.e("Response ERROR:: ", "${error.message}   ${error.cause}")
                        }
                    ) {
                    @Throws(AuthFailureError::class)
                    override fun getHeaders(): MutableMap<String, String> {
                        val params: MutableMap<String, String> = HashMap()
                        params["Authorization"] = token
                        params["Content-Type"] = "application/json"
                        return params
                    }

                    override fun parseNetworkResponse(response: NetworkResponse?): com.android.volley.Response<JSONObject> {
                        val statusCode = response!!.statusCode
                        Log.e(TAG, "parseNetworkResponse: $status")

                        if (statusCode == 204) {
                            sendMessageToActivity(true, status)
                        } else {
                            sendMessageToActivity(false, status)
                        }

                        return super.parseNetworkResponse(response)
                    }
                }

                request.retryPolicy = DefaultRetryPolicy(2000, 3, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
                Volley.newRequestQueue(this).add(request)


            } else {

                ApiClient.token = "Bearer " + sessionManager.getStoreToken()
                val jsonObject = JSONObject()
                jsonObject.put("pos_integration_enabled", status)
                val body = jsonObject.toString()
                    .toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())

                ApiClient.retrofitService.updatePOSStatus(
                    sessionManager.getSelectedStore()?.storeId.toString(),
                    body
                ).enqueue(object : Callback<POSStatus> {
                    override fun onResponse(
                        call: Call<POSStatus>,
                        response: Response<POSStatus>
                    ) {
                        if (response.isSuccessful) {
                            sendMessageToActivity(true, status)
                            Log.e(TAG, "POS status onResponse: ${response.code()}")
                        }
                    }

                    override fun onFailure(call: Call<POSStatus>, t: Throwable) {
                        sendMessageToActivity(false, status)
                        Log.e(TAG, "onFailure: updating pos status", t)
                    }
                })

            }

        }
    }

    private fun sendMessageToActivity(msg: Boolean, status: Boolean) {
        val intent = Intent("POSStatus")
        intent.putExtra("msg", msg)
        intent.putExtra("Status", status)
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
    }

    private fun sessionOut(msg: String) {

        Log.e(TAG, "sessionOut: $msg")

        CoroutineScope(Main).launch {
            try {
                Utils.showShortMessage(
                    this@NotificationService,
                    "Session Timeout.."
                )  //show toast to user for logout
            } catch (e: Exception) {
            }
        }

        val intentToScreen = Intent(applicationContext, MainActivity::class.java)
        intentToScreen.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
        intentToScreen.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intentToScreen)

        sessionManager.clearSession()  //clear shared prefers
        stopSelf() //stop service

    }


}

data class ExtraInfo2(
    @SerializedName("ADDRESS")
    val aDDRESS: Boolean,
    @SerializedName("CAPACITY")
    val cAPACITY: Boolean,
    @SerializedName("ITEM_AVAILABILITY")
    val iTEMAVAILABILITY: Boolean,
    @SerializedName("MISSING_INFO")
    val mISSINGINFO: Boolean,
    @SerializedName("MISSING_ITEM")
    val mISSINGITEM: Boolean,
    @SerializedName("OTHER")
    val oTHER: Boolean,
    @SerializedName("POS_NOT_READY")
    val pOSNOTREADY: Boolean,
    @SerializedName("POS_OFFLINE")
    val pOSOFFLINE: Boolean,
    @SerializedName("PRICING")
    val pRICING: Boolean,
    @SerializedName("SPECIAL_INSTRUCTIONS")
    val sPECIALINSTRUCTIONS: Boolean,
    @SerializedName("STORE_CLOSED")
    val sTORECLOSED: Boolean
)

data class ExtraInfoCancel(
    @SerializedName("OUT_OF_ITEMS")
    val outOfItems: Boolean,
    @SerializedName("RESTAURANT_TOO_BUSY")
    val restaurantTooBusy: Boolean,
    @SerializedName("CUSTOMER_CALLED_TO_CANCEL")
    val customerCalledCancel: Boolean,
    @SerializedName("KITCHEN_CLOSED")
    val kitchenClosed: Boolean,
    @SerializedName("CANNOT_COMPLETE_CUSTOMER_NOTE")
    val connotCompleteCustomerNote: Boolean
)

data class orderDatum(
    val uberId: String?,
    val airmenuId: String?,
    val status: String,
    val shouldUpdateStatus: Boolean,
    val reason: String?
)