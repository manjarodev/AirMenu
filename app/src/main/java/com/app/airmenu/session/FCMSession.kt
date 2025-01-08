package com.app.airmenu.session

import android.content.Context
import android.content.SharedPreferences
import com.app.airmenu.utils.PREF_KEY_NOTIFICATION_TOKEN

class FCMSession(context: Context) {
    var context: Context

    // Shared Preferences
    var pref: SharedPreferences
    var editor: SharedPreferences.Editor

    // Shared pref mode
    var PRIVATE_MODE = 0

    init {
        this.context = context
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
        editor.apply()
    }

    companion object {
        private const val PREF_NAME = "com.app.airmenu.fcm"

    }

    var fcmToken: String?
        get() = pref.getString(PREF_KEY_NOTIFICATION_TOKEN, "")
        set(token) {
            if (token != null) {
                editor.putString(PREF_KEY_NOTIFICATION_TOKEN, token)
            }

            // commit changes
            editor.commit()
        }

}