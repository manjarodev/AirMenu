package com.app.airmenu.utils

import android.app.Activity
import android.content.Context
import android.os.Build
import android.telephony.TelephonyManager
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.app.airmenu.AirMenuApp
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*


class Utils {
    companion object {
        fun getUserCountry(context: Context): String? {
            try {
                val tm = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
                val simCountry = tm.simCountryIso
                if (simCountry != null && simCountry.length == 2) { // SIM country code is available
                    return simCountry.lowercase(Locale.US)
                } else if (tm.phoneType != TelephonyManager.PHONE_TYPE_CDMA) { // device is not 3G (would be unreliable)
                    val networkCountry = tm.networkCountryIso
                    if (networkCountry != null && networkCountry.length == 2) { // network country code is available
                        return networkCountry.lowercase(Locale.US)
                    }
                }
            } catch (e: Exception) {

            }
            return null
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun getDateInMilis(calendar: Calendar): Long {
            val formatter =
                DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH)
            val localDate: LocalDateTime = LocalDateTime.parse(calendar.time.toString(), formatter)
            val timeInMilliseconds: Long =
                localDate.atOffset(ZoneOffset.UTC).toInstant().toEpochMilli()
            return timeInMilliseconds
        }

        fun showShortMessage(context: Context, msg: String) {
            (context as Activity).runOnUiThread {
                Toast.makeText(
                    AirMenuApp.getInstance()?.applicationContext,
                    msg,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}