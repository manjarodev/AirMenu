package com.app.airmenu.fcm

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.app.airmenu.AirMenuApp
import com.app.airmenu.R
import com.app.airmenu.models.NotificationMessage
import com.app.airmenu.session.FCMSession
import com.app.airmenu.session.SessionManager
import com.app.airmenu.ui.HomeActivity
import com.app.airmenu.utils.*
import com.elvishew.xlog.XLog
import com.google.firebase.firestore.FieldValue
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.firebase.storage.FirebaseStorage
import java.io.File
import java.util.*

//6d063b97-1c00-40a5-adf9-6c99cd107de9
class MyFirebaseMessagingService : FirebaseMessagingService() {

    private val TAG: String = MyFirebaseMessagingService::class.java.simpleName

    private var fcmSession =
        AirMenuApp.getInstance()?.applicationContext?.let { FCMSession(it) }


    override fun onNewToken(token: String) {
        super.onNewToken(token)
        XLog.e("got new token => $token")
        fcmSession?.fcmToken = token
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        XLog.e("notification received: ${message.data}")
        val status = message.data.get("status")

        AppState.errorCount = 0

        when (status) {
            "logs" -> {
                XLog.e("Uploading logs...")
                uploadFile()
            }
            "created" -> {
                val orderDetailsUrl = message.data.get("orderDetailsUrl")
                val orderId = message.data.get("orderId")
                val storeId = message.data.get("storeId")
                val time = message.data.get("time")
                val id = message.data.get("id")
                val notificationMessage =
                    NotificationMessage(id, orderId, storeId, time, orderDetailsUrl)

                val intent = Intent(ACTION_NEW_ORDER)
                intent.putExtra("message", notificationMessage)
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
            }
            "cancelled" -> {
                val notificationMessage =
                    NotificationMessage(
                        "status",
                        message.data.get("orderId"),
                        message.data.get("storeId"),
                        "cancelled",
                        "orderDetailsUrl"
                    )

                val intent = Intent(ACTION_NEW_ORDER)
                intent.putExtra("message", notificationMessage)
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
            }
            "store.deprovisioned" -> {
                val intent =
                    Intent(this@MyFirebaseMessagingService, HomeActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP

                        action = Intent.ACTION_VIEW
                    }
                showNotification(
                    this,
                    "Store Provisioned successfully.",
                    message.data.get("storeId"),
                    intent
                )
            }
            "store.provisioned" -> {
                val intent =
                    Intent(this@MyFirebaseMessagingService, HomeActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP

                        action = Intent.ACTION_VIEW
                    }
                showNotification(
                    this,
                    "Store Deprovisioned successfully.",
                    message.data.get("storeId"),
                    intent
                )
            }
        }
    }


    fun showNotification(context: Context, title: String?, body: String?, intent: Intent?) {
        val notificationManager =
            context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val notificationId = Random().nextInt(10000)
        val channelId = "channel-03"
        val channelName = "Store Provisioning Status Notifications"
        val importance = NotificationManager.IMPORTANCE_HIGH
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val mChannel = NotificationChannel(
                channelId, channelName, importance
            )
            notificationManager.createNotificationChannel(mChannel)
        }
        val mBuilder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.mipmap.ic_launcher)
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

    private fun uploadFile() {

        val fullPath = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS).toString()
        val file = File(fullPath)
        if (file.exists()) {

            val list = file.listFiles()
            var storageRef = FirebaseStorage.getInstance().getReference()
            list.forEach {
                Log.e(TAG, "onOptionsItemSelected: ${it.absolutePath}")

                var file = Uri.fromFile(it)
                val riversRef = storageRef.child("logs/${file.lastPathSegment}")

                val uploadTask = riversRef.putFile(file)

                uploadTask.addOnFailureListener {
                    XLog.e("Logs uploaded")
                    Toast.makeText(this, "upload failure ${it.message}", Toast.LENGTH_SHORT).show()
                }.addOnSuccessListener { taskSnapshot ->
                    Toast.makeText(this, "upload success", Toast.LENGTH_SHORT).show()
                    XLog.e("Logs upload failure")

                }

            }
        }
    }

}