package com.app.airmenu.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import com.app.airmenu.service.NotificationService
import com.app.airmenu.utils.ACTION_SERVICE_DESTROYED

private const val TAG = "OnServiceDestroyReceive"

class OnServiceDestroyReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        Log.e(TAG, "onReceive:")

        intent?.let { int ->
            if (int.action == ACTION_SERVICE_DESTROYED) {
                //restart service
                val serviceIntent = Intent(context , NotificationService::class.java)
                startService(serviceIntent , context)
            }
        }
    }//onReceive

    private fun startService(serviceIntent: Intent, context: Context?) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context?.startForegroundService(serviceIntent)
        } else {
            context?.startService(serviceIntent)
        }
    }
}//end class