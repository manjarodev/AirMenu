package com.app.airmenu.utils

import android.content.Context
import android.content.DialogInterface
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


class AlertsDialogue {
    private var alertDialogBuilder: AlertDialog.Builder? = null
    private var alert: AlertDialog? = null

    fun AlertsDialogue(context: Context, title: String?, message: String?) {
        alertDialogBuilder = AlertDialog.Builder(context)
        alertDialogBuilder?.setTitle(title)
        alertDialogBuilder?.setIcon(com.app.airmenu.R.mipmap.ic_launcher)
        alertDialogBuilder?.setMessage(message)
            ?.setCancelable(false)
            ?.setPositiveButton(context.getString(com.app.airmenu.R.string.text_ok),
                DialogInterface.OnClickListener { dialog, which -> alert?.dismiss() })
        alert = alertDialogBuilder?.create()
        val window: Window? = alert?.getWindow()
        if (window != null) {
            // the important stuff..
            window.setType(WindowManager.LayoutParams.TYPE_TOAST)
            alert?.show()
        } else Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}