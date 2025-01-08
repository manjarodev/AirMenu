package com.app.airmenu.ui

import android.content.*
import android.net.Uri
import android.os.Build
import android.os.Build.VERSION_CODES.N
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.app.airmenu.AirMenuApp
import com.app.airmenu.BuildConfig
import com.app.airmenu.R
import com.app.airmenu.databinding.ActivityHomeBinding
import com.app.airmenu.local.PreferenceRepository

import com.app.airmenu.network.response.POSAvailability
import com.app.airmenu.network.response.POSStatus
import com.app.airmenu.network.response.RestaurantStatus
import com.app.airmenu.network.response.TokenResponse
import com.app.airmenu.remote.RemoteRepository
import com.app.airmenu.service.NotificationService
import com.app.airmenu.session.FCMSession
import com.app.airmenu.session.SessionManager
import com.app.airmenu.ui.home.HomeViewModel
import com.app.airmenu.utils.*
import com.app.airmenu.utils.decryption.RSA_cipher
import com.elvishew.xlog.XLog
import com.google.firebase.firestore.FieldValue
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.storage.FirebaseStorage
import com.google.gson.Gson
import com.imprint.app.network.ApiClient
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.UnsupportedEncodingException
import java.lang.reflect.Method
import java.util.*
import javax.inject.Inject
import kotlin.collections.HashMap


@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val TAG: String = HomeActivity::class.java.simpleName

    private lateinit var binding: ActivityHomeBinding
    private lateinit var sessionManager: SessionManager
    private lateinit var fcmSession: FCMSession
    private val mViewModel: HomeViewModel by viewModels()
    private lateinit var mDialog: TransparentProgressDialog

    @Inject
    lateinit var remoteRepository: RemoteRepository

    companion object {
        var onSocketEvent: ((SocketState) -> Unit)? = null
        var onNewOrder: ((String, String, String) -> Unit)? = null
        var onServiceError: ((String) -> Unit)? = null
    }

    @Inject
    lateinit var prefRepository: PreferenceRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                val intent =
                    Intent(
                        Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:$packageName")
                    )
                startActivityForResult(intent, 0)
            }
        }

        initViews()

        if (intent.hasExtra("is")) {
            startService()
            binding.startServiceBtn.text = "Stop AirMenu service"
            sessionManager.shouldStopService = false
        }

        val jsonObject = JSONObject(
            "{\"orders\":{\"UK\":[{\"childs\":[{\"childs\":[],\"count\":1,\"extraInfo\":[{\"desc\":\"DELIVERY_BY_RESTAURANT\"}],\"available\":true,\"menuRelation\":\"item\",\"title\":\"Type\",\"price\":0.0,\"id\":\"4274592\",\"plu\":\"TYPE\"}],\"username\":\"e6beedbb-01cd-5187-aa0e-c8d59db1ff9b@anonymous.com\",\"orderCounter\":459,\"orderId\":1431369,\"extraInfo\":[{\"date\":\"08/10/2021\",\"time\":\"18:33\"},{\"obs\":\"No instructions for order \\n \",\"uberOrder\":\"4192265f-b801-4bdd-b490-63751aca19f4\",\"name\":\"\",\"nif\":\"\"},{\"address\":\"242 Hagley Rd, Hayley Green, Halesowen B63 1EF, UK\",\"city\":\"\",\"phone\":\"441388436844\",\"timezone\":\"Europe/London\",\"postalCode\":\"B63 1EF\",\"latitude\":\"52.4350134\",\"United Kingdom\":\"\",\"state\":\"\",\"complement\":\"\",\"longitude\":\"-2.0868658\"}],\"orderDate\":1633713512499,\"firstName\":\"AirMenu\",\"lastName\":\"D.\",\"activeFlags\":[{\"operatorEmail\":\"script@airmenu.com\",\"datetime\":1633713513633,\"orderId\":\"1431369\",\"key\":\"DELIVERY_BY_RESTAURANT\",\"operator\":\"script@airmenu.com\"},{\"operatorEmail\":\"kashan.badar@catalyic.com\",\"datetime\":1633713563110,\"orderId\":\"1431369\",\"key\":\"ACCEPT\",\"operator\":\"kashan.badar@catalyic.com\"}],\"userId\":\"340406\",\"paymentMethod\":\"Money\",\"available\":true,\"trackingUrl\":\"https://www.airmenu.com/?r\\u003d1621845469992\\u0026tracking\\u003d0YFE67r5wHVdwRN7s+XpJg%3D%3D\",\"menuRelation\":\"family\",\"title\":\"Menu2\",\"plu\":\"Menu2\"},{\"childs\":[{\"childs\":[],\"count\":1,\"available\":true,\"menuRelation\":\"item\",\"title\":\"Chicken sandwich\",\"price\":7.0,\"id\":\"4295172\",\"plu\":\"Chicken-sandwich\"}],\"username\":\"e6beedbb-01cd-5187-aa0e-c8d59db1ff9b@anonymous.com\",\"orderCounter\":459,\"orderId\":1431369,\"extraInfo\":[{\"date\":\"08/10/2021\",\"time\":\"18:33\"},{\"obs\":\"No instructions for order \\n \",\"uberOrder\":\"4192265f-b801-4bdd-b490-63751aca19f4\",\"name\":\"\",\"nif\":\"\"},{\"address\":\"242 Hagley Rd, Hayley Green, Halesowen B63 1EF, UK\",\"city\":\"\",\"phone\":\"441388436844\",\"timezone\":\"Europe/London\",\"postalCode\":\"B63 1EF\",\"latitude\":\"52.4350134\",\"United Kingdom\":\"\",\"state\":\"\",\"complement\":\"\",\"longitude\":\"-2.0868658\"}],\"orderDate\":1633713512499,\"firstName\":\"AirMenu\",\"lastName\":\"D.\",\"activeFlags\":[{\"operatorEmail\":\"script@airmenu.com\",\"datetime\":1633713513633,\"orderId\":\"1431369\",\"key\":\"DELIVERY_BY_RESTAURANT\",\"operator\":\"script@airmenu.com\"},{\"operatorEmail\":\"kashan.badar@catalyic.com\",\"datetime\":1633713563110,\"orderId\":\"1431369\",\"key\":\"ACCEPT\",\"operator\":\"kashan.badar@catalyic.com\"}],\"userId\":\"340406\",\"paymentMethod\":\"Money\",\"available\":true,\"trackingUrl\":\"https://www.airmenu.com/?r\\u003d1621845469992\\u0026tracking\\u003d0YFE67r5wHVdwRN7s+XpJg%3D%3D\",\"menuRelation\":\"family\",\"title\":\"Menu2\",\"plu\":\"Menu2\"}]},\"action\":\"GetOrders\",\"version\":\"1.0.0\",\"status\":\"SUCCESS\",\"statusCode\":1}"
        )

        fcmSession = FCMSession(this)
        val ordersObject = jsonObject.get("orders") as JSONObject
        val size = ordersObject.length()
        ordersObject.keys().forEach {
            Log.e(TAG, "onCreate: $it")
        }
        for (i in 0..size) {
            Log.e(TAG, "onCreate: ${ordersObject.keys()} &&&&& ${ordersObject.names()}")
        }
        onNewOrder = { status, uber, airmne ->
            runOnUiThread {
                val builder1 = AlertDialog.Builder(this)
                builder1.setMessage("New order: Id=> $airmne Status=> $status")
                builder1.setCancelable(true)

                builder1.setPositiveButton(
                    "Yes"
                ) { dialog, id -> dialog.cancel() }

//            builder1.setNegativeButton(
//                "No"
//            ) { dialog, id -> dialog.cancel() }

                val alert11 = builder1.create()
                alert11.show()

            }


        }

        onServiceError = {

            stopService(Intent(this, NotificationService::class.java))
            showMessage("Error - Service stopped", it)
        }


    }


    fun showMessage(title: String?, messageStr: String) {
        android.app.AlertDialog.Builder(this)
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


    private fun initViews() {
        setSupportActionBar(binding.toolbar)
        sessionManager = SessionManager(this)
        mDialog = TransparentProgressDialog(this)

        setNetworkStatus()

        binding.tvConfigurations.setOnClickListener {

            val nifCipherText = RSA_cipher.CipherText
            val nifSymmetricKey = RSA_cipher.SymmetricKey

            if (nifCipherText != null && nifSymmetricKey != null) {
                val rsaCipher = RSA_cipher(
                    this,
                    nifSymmetricKey,
                    nifCipherText
                )
                try {
                    rsaCipher.decryptedNif()
                } catch (e: Exception) {
                }
            }


            //refresh firebase token and add to firestore
//            FirebaseMessaging.getInstance().token.addOnCompleteListener {
//                val token = it.result
//                fcmSession.fcmToken = token
//                val ref =
//                    FireManager.tokenReference.document(sessionManager.getSelectedStore()?.storeId!!)
//                ref.update("fcmTokens", FieldValue.arrayUnion(token))
//                    .addOnSuccessListener {
//                        Log.e(TAG, "token updated successfully")
//                    }.addOnFailureListener {
//                        val fcmTokens = arrayListOf<String>(token)
//                        val map = HashMap<String, Any>()
//                        map.put("fcmTokens", fcmTokens)
//                        ref.set(map).addOnSuccessListener {
//                            Log.e(TAG, "Token created successfully.")
//                        }.addOnFailureListener {
//                            Log.e(TAG, "failure while creating token at firebase ${it.message}")
//                        }
//                    }
//
//                XLog.e("while refresh token in firebase ${fcmSession.fcmToken}")
//
//            }

        }

        binding.airmenuStatusText.setOnClickListener {
            val orignalTime = "2021-08-29T18:34:23+01:00"
//            val orignalTime = "2021-08-29T08:02:03+01:00"
            Log.e(TAG, "after=> ${ISO8601.toCalendar(orignalTime)}")
            Log.e(TAG, "GMT=> ${ISO8601.toCalendarGmt(orignalTime)}")
            try {
                //"estimated_ready_for_pickup_at":"2021-09-21T21:42:59+01:00"
                var time = ISO8601.toCalendarGmt("2021-09-21T20:19:06+01:00")
                Log.e(
                    TAG,
                    "initViews: average time${sessionManager.getSelectedStoreDetails()?.name}"
                )
                var averageTime =
                    sessionManager.getSelectedStoreDetails()?.avgPrepTime?.times(60000)
                time = time.plus(averageTime!!)

                var orderjson = 1632253041000

                Log.e(TAG, "initViews: final time=> ${orderjson.plus(averageTime)}")


                // placeOrderAtAirMenu(orderjson,divisionId,body,result,username)
            } catch (e: Exception) {
                XLog.e("Exception while adding the average time to meantime ${e.message}")
            }

        }

        setAirMenuStatus()

        if (!intent.hasExtra("is"))
            setUberStatus()


        updateStatusLocal()

        onSocketEvent = { event ->

            runOnUiThread {
                when (event) {
                    SocketState.CONNECTING -> {
                        binding.airmenuStatusText.text = "Connecting..."
                        binding.statusImageAirmenu.setImageResource(R.drawable.x_button)
                        binding.connectingStatusAnimation.visibility = View.VISIBLE
                    }
                    SocketState.CONNECTED -> {
                        binding.airmenuStatusText.text = "Connected."
                        binding.statusImageAirmenu.setImageResource(R.drawable.checked)
                        binding.connectingStatusAnimation.visibility = View.GONE
                        try {
                            mViewModel.requestState.removeObserver(requestStateObserver)
                            mViewModel.requestStateLogin.removeObserver(logingStateObserver)
                        } catch (e: Exception) {
                            XLog.e("Exception while removing the observer")

                        }
                    }
                    SocketState.DISCONNECTED -> {
                        binding.airmenuStatusText.text = "Disconnected. Try restart service."
                        binding.statusImageAirmenu.setImageResource(R.drawable.x_button)
                        binding.connectingStatusAnimation.visibility = View.GONE
                        try {
                            mViewModel.requestState.removeObserver(requestStateObserver)
                            mViewModel.requestStateLogin.removeObserver(logingStateObserver)

                        } catch (e: Exception) {
                            XLog.e("Exception while removing the observer")
                        }
                    }
                }
            }
        }

        binding.startServiceBtn.setOnClickListener {
            if (!sessionManager.isServiceRunning!!) {
                Log.e(TAG, "initViews: starting service")
                startService()
                sessionManager.isServiceRunning = true
                sessionManager.shouldStopService = false
                binding.startServiceBtn.text = "Stop AirMenu service"
            } else {
                Log.e(TAG, "initViews: stopping service")
                stopService(Intent(this, NotificationService::class.java))
                sessionManager.shouldStopService = true
                sessionManager.isServiceRunning = false
                binding.startServiceBtn.text = "Start AirMenu service"
            }
        }

        binding.logoutbutton.setOnClickListener {
//            AlertDialog.Builder(this)
//                .setTitle("Logout!")
//                .setMessage("Are you sure you want logout and switch off the service?") // Specifying a listener allows you to take an action before dismissing the dialog.
//                // The dialog is automatically dismissed when a dialog button is clicked.
//                .setPositiveButton("Yes",
//                    DialogInterface.OnClickListener { dialog, which ->
//
//                        updatePOSStatus(false, true)
//
//
//                    }) // A null listener allows the button to dismiss the dialog and take no further action.
//                .setNegativeButton("No", null)
//                .setIcon(android.R.drawable.ic_dialog_alert)
//                .show()
        }

        binding.updateStoreStatus.setOnClickListener {

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Update your restaurant status")
            builder.setItems(
                arrayOf<CharSequence>("Set status to PAUSE", "Set status to ONLINE")
            ) { dialog, which -> // The 'which' argument contains the index position
                // of the selected item
                when (which) {
                    0 -> {
                        updateRestaurantStatus(com.app.airmenu.utils.RestaurantStatus.PAUSED.toString())
                    }
                    1 -> {
                        updateRestaurantStatus(com.app.airmenu.utils.RestaurantStatus.ONLINE.toString())
                    }

                }
            }
            builder.create().show()
        }

        updateDeliveryToken()
    }

    private fun updateStatusLocal() {
        if (sessionManager.uberOrderReadToken.isNullOrEmpty())
            getAndSaveUberTokens()

        if (sessionManager.getSelectedStore() != null) {
            Log.e(TAG, "setUberStatus: ${sessionManager.getSelectedStore()!!.name}")
            binding.storeName.text = sessionManager.getSelectedStore()!!.name
            binding.countryCode.text = sessionManager.getSelectedStore()!!.location.country
        }
    }

    private fun updatePOSStatus(status: Boolean, isLogout: Boolean) {
        if (!sessionManager.getStoreToken().isNullOrEmpty()) {
            mDialog.show()

            if (Build.VERSION.SDK_INT < N) {

                val jsonObject = JSONObject()
                val token = "Bearer " + sessionManager.getStoreToken()
                jsonObject.put("pos_integration_enabled", status)

                val request: JsonObjectRequest = object :
                    JsonObjectRequest(
                        Method.PATCH,
                        "${BuildConfig.BASE_URL}v1/eats/stores/${sessionManager.getSelectedStore()?.storeId.toString()}/pos_data",
                        jsonObject,
                        com.android.volley.Response.Listener { response ->
                            Log.e("Response ", response!!.toString())
                            mDialog.dismiss()
                        },
                        com.android.volley.Response.ErrorListener { error ->
                            Log.e("Response ERROR:: ", "${error.message}   ${error.cause}")
                            mDialog.dismiss()

                        }
                    ) {
                    @Throws(AuthFailureError::class)
                    override fun getHeaders(): MutableMap<String, String> {
                        val params: MutableMap<String, String> = HashMap()
                        params["Authorization"] = token
//                        params["Content-Type"] = "application/json"
                        return params
                    }

                    override fun parseNetworkResponse(response: NetworkResponse?): com.android.volley.Response<JSONObject> {
                        val statusCode = response!!.statusCode
                        Log.e(TAG, "parseNetworkResponse: $status")

                        if (statusCode == 204) {

                            try {
                                Utils.showShortMessage(this@HomeActivity, "POS status changed.")
                            } catch (e: Exception) {
                            }

                            runOnUiThread {


                                if (status) {
                                    binding.uberStatusText.text =
                                        "POS enabled and Connected with Uber."
                                    binding.enablePosButton.visibility = View.VISIBLE
                                    binding.disablePosButton.visibility = View.GONE
                                    binding.statusImageUber.setImageResource(R.drawable.checked)

                                } else {
                                    binding.uberStatusText.text =
                                        "POS disabled and not connected with Uber."
                                    binding.enablePosButton.visibility = View.GONE
                                    binding.disablePosButton.visibility = View.VISIBLE
                                    binding.statusImageUber.setImageResource(R.drawable.x_button)

                                    if (isLogout) {
                                        if (sessionManager.shouldStopService != true) {
                                            sessionManager.shouldStopService = true
                                            stopService(
                                                Intent(
                                                    this@HomeActivity,
                                                    NotificationService::class.java
                                                )
                                            )
                                            binding.startServiceBtn.text = "Start AirMenu service"
                                        }

                                        prefRepository.clearSession()
                                        AppState.shouldClearCache = true
                                        val intentToScreen =
                                            Intent(applicationContext, MainActivity::class.java)
                                        intentToScreen.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                                        intentToScreen.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                                        startActivity(intentToScreen)
                                        overridePendingTransition(0, 0)
                                        finish()
                                    }
                                }
                            }

                        } else {
                            try {
                                Utils.showShortMessage(
                                    this@HomeActivity,
                                    "Error while enabling the POS for store."
                                )
                            } catch (e: Exception) {
                            }
                        }

                        return super.parseNetworkResponse(response)
                    }
                }

                request.retryPolicy =
                    DefaultRetryPolicy(2000, 3, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
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
                        mDialog.dismiss()
                        if (response.isSuccessful) {
                            try {
                                Utils.showShortMessage(this@HomeActivity, "POS status changed.")
                            } catch (e: Exception) {
                            }
                            if (status) {
                                binding.uberStatusText.text = "POS enabled and Connected with Uber."
                                binding.enablePosButton.visibility = View.VISIBLE
                                binding.disablePosButton.visibility = View.GONE
                                binding.statusImageUber.setImageResource(R.drawable.checked)

                            } else {
                                binding.uberStatusText.text =
                                    "POS disabled and not connected with Uber."
                                binding.enablePosButton.visibility = View.GONE
                                binding.disablePosButton.visibility = View.VISIBLE
                                binding.statusImageUber.setImageResource(R.drawable.x_button)

                                if (isLogout) {
                                    if (sessionManager.shouldStopService != true) {
                                        sessionManager.shouldStopService = true
                                        stopService(
                                            Intent(
                                                this@HomeActivity,
                                                NotificationService::class.java
                                            )
                                        )
                                        binding.startServiceBtn.text = "Start AirMenu service"
                                    }

                                    prefRepository.clearSession()
                                    AppState.shouldClearCache = true
                                    val intentToScreen =
                                        Intent(applicationContext, MainActivity::class.java)
                                    intentToScreen.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                                    intentToScreen.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                                    startActivity(intentToScreen)
                                    overridePendingTransition(0, 0)
                                    finish()
                                }
                            }
                        }
                    }

                    override fun onFailure(call: Call<POSStatus>, t: Throwable) {
                        Log.e(TAG, "onFailure: updating pos status", t)
                        mDialog.dismiss()
                        try {
                            Utils.showShortMessage(
                                this@HomeActivity,
                                "Error while enabling the POS for store. ${t.message}"
                            )
                        } catch (e: Exception) {
                        }
                    }
                })


            }

        } else {
            //TODO should get the token first
        }
    }


    private fun updateDeliveryToken() {
        Log.e(TAG, "updateDeliveryToken: getting the token......")


        if (Build.VERSION.SDK_INT < N) {

            val token = "Bearer " + sessionManager.getStoreToken()
            Log.e(TAG, "updateDeliveryToken: if called  TOKEN:: $token")


            val stringRequest = object : StringRequest(
                Method.POST,
                UBER_AUTH_URL,
                com.android.volley.Response.Listener {
//                    Log.e(TAG, "Response updateDeliveryToken: $it")

                    if (!it.isNullOrEmpty()) {
                        val jsonString = JSONObject(it)
                        sessionManager.saveOrderDeliveryToken(jsonString.getString("access_token"))
                        Log.e(TAG, "updateDeliveryToken: ${jsonString.getString("access_token")}")
                    }


                },
                com.android.volley.Response.ErrorListener {
                    Log.e(TAG, "Error updateDeliveryToken: $it")
                }
            ) {
                @Throws(AuthFailureError::class)
                override fun getHeaders(): MutableMap<String, String> {
                    val params: MutableMap<String, String> = HashMap()
                    params["Authorization"] = token
//                    params["Content-Type"] = "application/json"
                    return params
                }

                override fun parseNetworkResponse(response: NetworkResponse?): com.android.volley.Response<String> {
                    Log.e(TAG, "parseNetworkResponse: ${response!!.statusCode}")
                    return super.parseNetworkResponse(response)
                }

                override fun getParams(): Map<String, String> {
                    val params = HashMap<String, String>()

                    params[KEY_CLIENT_ID] = UBER_CLIENT_ID
                    params[KEY_CLIENT_SECRET] = UBER_CLIENT_SECRET
                    params[KEY_GRANT_TYPE] = GRANT_TYPE
                    params[KEY_SCOPE] = SCOPE_EATS_ORDER_DELIVERY_STATUS

                    return params
                }

//                override fun getBodyContentType(): String? {
//                    return "application/x-www-form-urlencoded; charset=UTF-8"
//                }
            }

            stringRequest.retryPolicy =
                DefaultRetryPolicy(2000, 3, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
            Volley.newRequestQueue(this).add(stringRequest)


        } else {

            Log.e(TAG, "updateDeliveryToken: else called")
            val request = ApiClient.retrofitService.getOrderToken(
                UBER_AUTH_URL,
                UBER_CLIENT_ID,
                UBER_CLIENT_SECRET,
                GRANT_TYPE,
                SCOPE_EATS_ORDER_DELIVERY_STATUS
            )
            request.enqueue(object : Callback<TokenResponse> {
                override fun onResponse(
                    call: Call<TokenResponse>,
                    response: Response<TokenResponse>
                ) {
                    Log.e(TAG, "onResponse: while getting the token ${response.body()}")
                    XLog.e("update delivery token  ${response.body()}")
                    if (response.isSuccessful && response.body() != null) {
                        sessionManager.saveOrderDeliveryToken(response.body()!!.accessToken)
                        Log.e(TAG, "onResponse: token updted")
                    }
                }

                override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                    Log.e(TAG, "onFailure: getting deliverStatusToken", t)
                }
            })
        }


    }

    private fun updateRestaurantStatus(status: String) {
        val jsonObject = JSONObject()
        jsonObject.put("status", status)
        val body = jsonObject.toString()
            .toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())

        mDialog.show()

        ApiClient.token = "Bearer ${sessionManager.getStoreStatusWriteToken()}"

        ApiClient.retrofitService.setRestaurantStatus(
            sessionManager.getSelectedStore()?.storeId.toString(),
            body
        )
            .enqueue(object : Callback<POSAvailability> {
                override fun onResponse(
                    call: Call<POSAvailability>,
                    response: Response<POSAvailability>
                ) {
                    mDialog.dismiss()
                    if (response.isSuccessful) {
                        binding.storeStatus.text = status
                        Toast.makeText(
                            this@HomeActivity,
                            "Status updated.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<POSAvailability>, t: Throwable) {
                    Log.e(TAG, "onFailure: ", t)
                    mDialog.dismiss()
                    Toast.makeText(
                        this@HomeActivity,
                        "Error while updating status ${t.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
    }

    private fun getandUpdateStoreStatus() {
        Log.e(TAG, "getandUpdateStoreStatus: called")
        ApiClient.token = "Bearer " + sessionManager.getStoreToken()

        val resquest =
            ApiClient.retrofitService.getRestaurantStatus(sessionManager.getSelectedStore()?.storeId.toString())

        resquest.enqueue(object : Callback<RestaurantStatus> {
            override fun onResponse(
                call: Call<RestaurantStatus>,
                response: Response<RestaurantStatus>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    Log.e(TAG, "onResponse getting store token: ${response.body().toString()}")
                    if (response.body()?.status!!.equals("ONLINE")) {
                        binding.storeStatus.text =
                            com.app.airmenu.utils.RestaurantStatus.ONLINE.toString()
                    } else {
                        binding.storeStatus.text = response.body()!!.status
                    }

                }
            }

            override fun onFailure(call: Call<RestaurantStatus>, t: Throwable) {
                Log.e(TAG, "onFailure: ", t)
                Toast.makeText(
                    this@HomeActivity,
                    "Error while getting status ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun deProvisionStore() {
        mDialog.show()
        ApiClient.token = "Bearer " + sessionManager.getPOSTokenResponse()?.accessToken

        ApiClient.retrofitService.deProisionStore(sessionManager.getSelectedStore()?.storeId.toString())
            .enqueue(object : Callback<okhttp3.ResponseBody> {
                override fun onResponse(
                    call: Call<okhttp3.ResponseBody>,
                    response: Response<okhttp3.ResponseBody>
                ) {
                    mDialog.dismiss()
                    Log.e(TAG, "onResponse: logging out ${response.body()}")
                    if (response.isSuccessful) {
                        prefRepository.clearSession()
                        val intentToScreen = Intent(applicationContext, MainActivity::class.java)
                        intentToScreen.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                        intentToScreen.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        startActivity(intentToScreen)
                        overridePendingTransition(0, 0)
                        finish()
                    } else {
                        Toast.makeText(
                            this@HomeActivity,
                            "Something went wrong while deprovisioning store.",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                }

                override fun onFailure(call: Call<okhttp3.ResponseBody>, t: Throwable) {
                    mDialog.dismiss()
                    Toast.makeText(
                        this@HomeActivity,
                        "Something went wrong while deprovisioning store.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
    }

    private fun setUberStatus() {
        if (!sessionManager.getStoreToken().isNullOrEmpty()) {

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {

                val token = "Bearer ${sessionManager.getStoreToken()}"
                val stringRequest = object : StringRequest(
                    Method.GET,
                    BuildConfig.BASE_URL + "/v1/eats/stores/${sessionManager.getSelectedStore()?.storeId.toString()}/pos_data",
                    com.android.volley.Response.Listener {

                        if (!it.isNullOrEmpty()) {
                            val jsonString = JSONObject(it)

                            val storeId = jsonString.getString("store_id")
                            val posIntegrationEnabled = jsonString.getString("auto_accept_enabled")
                            val onlineStatus = jsonString.getString("pos_integration_enabled")
                            val orderReleaseEnabled = jsonString.getString("online_status")
                            val autoAcceptEnabled = jsonString.getString("order_release_enabled")
                            val posMetaData = jsonString.getString("pos_metadata")


                            if (onlineStatus.equals("online")) {
                                binding.storeStatus.text = "Online"
                            } else {
                                binding.storeStatus.text = onlineStatus
                            }
                            if (posIntegrationEnabled.equals("true")) {
                                binding.uberStatusText.text =
                                    "POS enabled and Connected with Uber."
                                binding.statusImageUber.setImageResource(R.drawable.checked)
                                binding.enablePosButton.visibility = View.VISIBLE
                                binding.disablePosButton.visibility = View.GONE


                            } else {
                                binding.uberStatusText.text =
                                    "POS disabled not connected with Uber."
                                binding.statusImageUber.setImageResource(R.drawable.x_button)
                                binding.enablePosButton.visibility = View.GONE
                                binding.disablePosButton.visibility = View.VISIBLE
                            }


                        } else {
                            Utils.showShortMessage(
                                this@HomeActivity,
                                "Error while getting POS status"
                            )
                        }

                    },
                    com.android.volley.Response.ErrorListener {
                        Log.e(TAG, "onFailure: getting pos status ${it.message}")
                        Utils.showShortMessage(
                            this@HomeActivity,
                            "Error while getting POS status ${it.message}"
                        )
                    }
                ) {
                    @Throws(AuthFailureError::class)
                    override fun getHeaders(): MutableMap<String, String> {
                        val params: MutableMap<String, String> = HashMap()
                        params["Authorization"] = token
                        return params
                    }

                    override fun parseNetworkResponse(response: NetworkResponse?): com.android.volley.Response<String> {
                        Log.e(TAG, "parseNetworkResponse: ${response!!.statusCode}")
                        return super.parseNetworkResponse(response)
                    }
                }

                stringRequest.retryPolicy =
                    DefaultRetryPolicy(2000, 3, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
                Volley.newRequestQueue(this).add(stringRequest)


            } else {

                ApiClient.token = "Bearer ${sessionManager.getStoreToken()}"
                ApiClient.retrofitService.getPOSStatus(sessionManager.getSelectedStore()?.storeId.toString())
                    .enqueue(object : Callback<POSStatus> {
                        override fun onResponse(
                            call: Call<POSStatus>,
                            response: Response<POSStatus>
                        ) {
                            if (response.isSuccessful && response.body() != null) {

                                if (response.body()!!.onlineStatus.equals("online")) {
                                    binding.storeStatus.text = "Online"
                                } else {
                                    binding.storeStatus.text = response.body()!!.onlineStatus
                                }
                                if (response.body()!!.posIntegrationEnabled == true) {
                                    binding.uberStatusText.text =
                                        "POS enabled and Connected with Uber."
                                    binding.statusImageUber.setImageResource(R.drawable.checked)
                                    binding.enablePosButton.visibility = View.VISIBLE
                                    binding.disablePosButton.visibility = View.GONE


                                } else {
                                    binding.uberStatusText.text =
                                        "POS disabled not connected with Uber."
                                    binding.statusImageUber.setImageResource(R.drawable.x_button)
                                    binding.enablePosButton.visibility = View.GONE
                                    binding.disablePosButton.visibility = View.VISIBLE
                                }
                            } else
                                Utils.showShortMessage(
                                    this@HomeActivity,
                                    "Error while getting POS status"
                                )
                        }

                        override fun onFailure(call: Call<POSStatus>, t: Throwable) {
                            Log.e(TAG, "onFailure: getting pos status ", t)
                            Utils.showShortMessage(
                                this@HomeActivity,
                                "Error while getting POS status ${t.message}"
                            )
                        }
                    })
            }
        }


    }

    private fun setAirMenuStatus() {
        if (NotificationService.isServiceRunning && NotificationService.isSocketConnected()) {
            binding.airmenuStatusText.text = "Connected."
            binding.statusImageAirmenu.setImageResource(R.drawable.checked)
            binding.startServiceBtn.text = "Stop Service"
        } else {
            binding.airmenuStatusText.text = "Disconnected."
            binding.statusImageAirmenu.setImageResource(R.drawable.x_button)
            sessionManager.shouldStopService = true
            sessionManager.isServiceRunning = false
        }

        if (!prefRepository.getSelectedEnterPriseName().isNullOrEmpty())
            binding.enterpriseName.text = prefRepository.getSelectedEnterPriseName()

        if (!prefRepository.getSelectedPOSId().equals("nil"))
            binding.posName.text = prefRepository.getSelectedPOSId()

        if (!prefRepository.getSelectedDivisionName().isNullOrEmpty())
            binding.divisionName.text = prefRepository.getSelectedDivisionName()

        if (!prefRepository.getSelectedDivisionName().isNullOrEmpty())
            binding.divisionNameMenu.text = prefRepository.getSelectedDivisionNameMenu()

    }

    private fun setNetworkStatus() {
        if (NetworkHelper.isNetworkAvailable(this)) {
            binding.internetStatusText.text = "Connected."
            binding.statusImageInternet.setImageResource(R.drawable.wifi_connection)
        } else {
            binding.internetStatusText.text = "Disconnected."
            binding.statusImageInternet.setImageResource(R.drawable.no_signal)
        }

        if (Build.VERSION.SDK_INT > N) {

            ConnectivityWatcher(this).observe(this, connectionObserver)

        } else {

            Log.e(TAG, "setNetworkStatus: receiver called")

            AirMenuApp.getInstance()!!
                .setConnectivityListener { isConnected ->
                    Log.e(
                        "mTAG",
                        "onNetworkConnectionChanged: $isConnected"
                    )
                    if (isConnected) {
                        //restart service
                        startServiceUi()

                    } else {
                        binding.internetStatusText.text = "Disconnected."
                        binding.statusImageInternet.setImageResource(R.drawable.no_signal)
                        binding.uberStatusText.text = "Disconnected."
                        binding.statusImageUber.setImageResource(R.drawable.x_button)

                        //stop service
                        stopServiceUi()

                    }


                }


        }
    }

    private fun getAndSaveUberTokens() {
        val request = ApiClient.retrofitService.getOrderToken(
            UBER_AUTH_URL,
            UBER_CLIENT_ID, UBER_CLIENT_SECRET, GRANT_TYPE, SCOPE_EATS_ORDER
        )

        request.enqueue(object : Callback<TokenResponse> {
            override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
                if (response.isSuccessful) {
                    Log.e(TAG, "onResponse: got firstToken")
                    val response = response.body()
                    sessionManager.uberOrderDetailToken =
                        response?.tokenType + " " + response?.accessToken

                    val requestForAuthToken = ApiClient.retrofitService.getOrderToken(
                        UBER_AUTH_URL, UBER_CLIENT_ID, UBER_CLIENT_SECRET, GRANT_TYPE,
                        SCOPE_EATS_STORE_ORDER_READ
                    )

                    requestForAuthToken.enqueue(object : Callback<TokenResponse> {
                        override fun onResponse(
                            call: Call<TokenResponse>,
                            response: Response<TokenResponse>
                        ) {
                            if (response.isSuccessful) {
                                Log.e(TAG, "onResponse: gotSecondToken")
                                sessionManager.uberOrderReadToken =
                                    response.body()?.tokenType + " " + response.body()?.accessToken

                                binding.uberStatusText.text = "Connected."

                                getStoreToken()
                            }
                        }

                        override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                            Log.e(TAG, "onFailure: error while getting second token ${t.message}")
                        }
                    })
                }
            }

            override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: error while getting token ${t.message}")
            }
        })
    }

    private fun getStoreToken() {
        Log.e(TAG, "getStoreToken: called")
        val request = ApiClient.retrofitService.getOrderToken(
            UBER_AUTH_URL,
            UBER_CLIENT_ID, UBER_CLIENT_SECRET, GRANT_TYPE, SCOPE_EATS_STORE
        )

        request.enqueue(object : Callback<TokenResponse> {
            override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
                Log.e(TAG, "onResponse: storeTokenResponse => ${response.body().toString()} ")
                if (response.isSuccessful && response.body() != null) {

                    XLog.e("while getting store token ${response.body()}")

                    sessionManager.saveStoreToken(response.body()!!.accessToken)
                }
            }

            override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: getting storeToken ", t)
            }
        })
    }

    private fun startService() {
        mViewModel.getSocketInfo()
        //observers
        mViewModel.requestState.observe(this, requestStateObserver)
    }

    private fun initLoginObservers() {
        mViewModel.requestStateLogin.observe(this, logingStateObserver)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.e(TAG, "onOptionsItemSelected: called")
        when (item.itemId) {
            R.id.sync_logs -> {
                uploadFile()
            }
            R.id.update_pos_status -> {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Update your POS status")
                builder.setItems(
                    arrayOf<CharSequence>("Enable POS", "Disable POS")
                ) { dialog, which -> // The 'which' argument contains the index position
                    // of the selected item
                    when (which) {
                        0 -> {
                            runOnUiThread {
                                updatePOSStatus(true, false)
                            }

                        }
                        1 -> {
                            AlertDialog.Builder(this)
                                .setTitle("Disable POS!")
                                .setMessage("Are you sure you want to disable the POS for this store?\nPlease note if you do it then you will not be able to recieve the new orders in this application.") // Specifying a listener allows you to take an action before dismissing the dialog.
                                // The dialog is automatically dismissed when a dialog button is clicked.
                                .setPositiveButton("Yes",
                                    DialogInterface.OnClickListener { dialog, which ->

                                        runOnUiThread {
                                            updatePOSStatus(false, false)
                                        }


                                    }) // A null listener allows the button to dismiss the dialog and take no further action.
                                .setNegativeButton("No", null)
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show()
                        }

                    }
                }
                builder.create().show()
            }
            R.id.setting -> {
                startActivity(Intent(this, com.app.airmenu.ui.Settings::class.java))
            }
            R.id.uber_notification -> {
                startActivity(Intent(this, UberOrderNotification::class.java))
            }
            R.id.logout_app -> {
                AlertDialog.Builder(this)
                    .setTitle("Logout!")
                    .setMessage("Are you sure you want logout and switch off the service?") // Specifying a listener allows you to take an action before dismissing the dialog.
                    // The dialog is automatically dismissed when a dialog button is clicked.
                    .setPositiveButton(
                        "Yes"
                    ) { dialog, which ->

                        updatePOSStatus(false, true)


                    } // A null listener allows the button to dismiss the dialog and take no further action.
                    .setNegativeButton("No", null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show()
            }
//            R.id.sync_menu -> {
//                //upload airmenu menu to ubereats
////                val repo = RemoteRepository
//            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun uploadFile() {

        val fullPath = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS).toString()
        val file = File(fullPath)
        if (file.exists()) {

            val list = file.listFiles()
            var storageRef = FirebaseStorage.getInstance().reference
            list.forEach {
                Log.e(TAG, "onOptionsItemSelected: ${it.absolutePath}")

                var file = Uri.fromFile(it)
                val riversRef = storageRef.child("logs/${file.lastPathSegment}")

                val uploadTask = riversRef.putFile(file)

                uploadTask.addOnFailureListener {
                    Toast.makeText(this, "upload failure ${it.message}", Toast.LENGTH_SHORT).show()
                }.addOnSuccessListener { taskSnapshot ->
                    Toast.makeText(this, "upload success", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }


    var requestStateObserver = Observer<RequestState> { state ->
        when (state) {
            RequestState.LOADING -> {
                // Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show()
                binding.airmenuStatusText.text =
                    "Updating Airmenu socket credentials, please wait..."
            }
            RequestState.DONE -> {
                binding.airmenuStatusText.text =
                    "Connecting with Airmenu service, please wait..."

                val serviceIntent = Intent(this, NotificationService::class.java)

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    startForegroundService(serviceIntent)
                } else {
                    startService(serviceIntent)
                }
                sessionManager.isServiceRunning = true
                binding.startServiceBtn.text = "Stop service"

            }
            RequestState.ERROR -> {
                binding.airmenuStatusText.text =
                    "Getting session id for AirMenu, please wait..."
                mViewModel.login()
                initLoginObservers()
            }
            else -> {

            }
        }
    }

    var logingStateObserver = Observer<RequestState>
    { state ->

        when (state) {
            RequestState.LOADING -> {
                // Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show()
                binding.airmenuStatusText.text =
                    "Updating Airmenu socket credentials, please wait..."
            }

            RequestState.DONE -> {
                binding.airmenuStatusText.text =
                    "Connecting with Airmenu service, please wait..."
                mViewModel.getSocketInfo()
            }
            RequestState.ERROR -> {
                mViewModel.errorDescription.observe(this) {
                    Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                    binding.airmenuStatusText.text = it
                }
            }
            RequestState.SESSION_EXPIRED -> {
                sessionOut(TAG)
            }
            else -> {

            }
        }
    }

    override fun onResume() {
        AirMenuApp.isInForeGround = true
        super.onResume()
    }

    override fun onPause() {
        AirMenuApp.isInForeGround = false
        super.onPause()
    }

    override fun onStart() {
        super.onStart()

        LocalBroadcastManager.getInstance(this)
            .registerReceiver(receiver, IntentFilter("POSStatus"))
    }

    override fun onDestroy() {
        super.onDestroy()

        /**
         * receive broadcast intent from notification service
         * on POS status changed
         */
        LocalBroadcastManager.getInstance(this)
            .unregisterReceiver(receiver)

        //remove connectivity watcher observer
        ConnectivityWatcher(this).removeObserver(connectionObserver)
    }

    private val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val message = intent!!.getBooleanExtra("msg", false)
            val status = intent.getBooleanExtra("Status", false)
            Log.e(TAG, "onReceive: $message   $status")

            if (status) {
                binding.uberStatusText.text = "POS enabled and Connected with Uber."
                binding.enablePosButton.visibility = View.VISIBLE
                binding.disablePosButton.visibility = View.GONE
                binding.statusImageUber.setImageResource(R.drawable.checked)
            } else {
                binding.uberStatusText.text = "POS disabled and not connected with Uber."
                binding.enablePosButton.visibility = View.GONE
                binding.disablePosButton.visibility = View.VISIBLE
                binding.statusImageUber.setImageResource(R.drawable.x_button)
            }

            if (message) {
                Utils.showShortMessage(this@HomeActivity, "POS status changed.")
            } else {
                Utils.showShortMessage(this@HomeActivity, "Error while enabling the POS for store.")
            }

        }
    }

    private var connectionObserver = Observer<Boolean> {
        Log.e(TAG, "observer called: ")
        if (it) {
            //restart service on reconnect
            startServiceUi()

        } else {
            binding.internetStatusText.text = "Disconnected."
            binding.statusImageInternet.setImageResource(R.drawable.no_signal)
            binding.uberStatusText.text = "Disconnected."
            binding.statusImageUber.setImageResource(R.drawable.x_button)

            //stop service on no internet connection
            stopServiceUi()
        }
    }


    private fun startServiceUi() {
        if (!sessionManager.shouldStopService!! && !sessionManager.isServiceRunning!!) {
            Log.e(TAG, "NetworkStatus: starting service")
            binding.internetStatusText.text = "Connected."
            binding.statusImageInternet.setImageResource(R.drawable.wifi_connection)

            startService()
            sessionManager.isServiceRunning = true
            sessionManager.shouldStopService = false
            binding.startServiceBtn.text = "Stop AirMenu service"
        }
    }

    private fun stopServiceUi() {
        Log.e(TAG, "NetworkStatus: stopping service")
        stopService(Intent(this, NotificationService::class.java))
        sessionManager.isServiceRunning = false
        binding.startServiceBtn.text = "Start AirMenu service"
    }

    private fun sessionOut(msg: String) {

        Log.e(TAG, "sessionOut: $msg")

        CoroutineScope(Dispatchers.Main).launch {
            Utils.showShortMessage(
                this@HomeActivity,
                "Session Timeout.."
            )  //show toast to user for logout
        }

        val intentToScreen = Intent(applicationContext, MainActivity::class.java)
        intentToScreen.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
        intentToScreen.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intentToScreen)

        sessionManager.clearSession()  //clear shared prefers
        stopService(Intent(this, NotificationService::class.java))

        finish()
    }


}


