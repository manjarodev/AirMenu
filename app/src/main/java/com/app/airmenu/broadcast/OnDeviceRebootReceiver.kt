package com.app.airmenu.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import com.app.airmenu.service.NotificationService

private const val TAG = "OnDeviceRebootReceiver"

class OnDeviceRebootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        if (intent != null && intent.action != null) {
            if (Intent.ACTION_BOOT_COMPLETED == intent.action) {
                Log.e(TAG, "onReceive: rebooted")
                //start service
                val serviceIntent = Intent(context, NotificationService::class.java)
                startService(serviceIntent, context)
            }
        }
    }

    private fun startService(serviceIntent: Intent, context: Context?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context?.startForegroundService(serviceIntent)
        } else {
            context?.startService(serviceIntent)
        }
    }
}