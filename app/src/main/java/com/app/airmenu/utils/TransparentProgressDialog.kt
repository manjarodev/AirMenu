package com.app.airmenu.utils

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import com.app.airmenu.R


class TransparentProgressDialog(
    context: Context?
) : Dialog(context!!, R.style.TransparentProgressDialog) {
    override fun show() {
        super.show()

    }

    override fun dismiss() {
        super.dismiss()
    }

    init {
        try {
            val view =
                LayoutInflater.from(context).inflate(R.layout.custom_loading_dialog, null)
            setContentView(view)
            setCancelable(false)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}