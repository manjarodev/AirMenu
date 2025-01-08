package com.app.airmenu.session

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.app.airmenu.models.NotificationAccessResponse
import com.app.airmenu.network.response.StoreDetails
import com.app.airmenu.network.response.TokenResponse
import com.app.airmenu.network.response.UberStores
import com.app.airmenu.utils.*
import com.google.gson.Gson

class SessionManager(context: Context) {

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
        private const val PREF_NAME = "com.app.airmenu"

    }

    // commit changes
    var uberOrderDetailToken: String?
        get() = pref.getString("token.eats.order", "")
        set(token) {
            if (token != null) {
                editor.putString("token.eats.order", token)
            }

            // commit changes
            editor.commit()
        }

    // uber auth token
    var uberOrderReadToken: String?
        get() = pref.getString("token.eats.store.orders.read", "")
        set(token) {
            if (token != null) {
                editor.putString("token.eats.store.orders.read", token)
            }

            // commit changes
            editor.commit()
        }

    // update firebase push notification token
    var shouldStopService: Boolean?
        get() = pref.getBoolean(PREF_KEY_SHOULD_STOP_SERVICE, false)
        set(token) {
            if (token != null) {
                editor.putBoolean(PREF_KEY_SHOULD_STOP_SERVICE, token)
            }

            // commit changes
            editor.commit()
        }

    // update firebase push notification token
    var isServiceRunning: Boolean?
        get() = pref.getBoolean(PREF_KEY_IS_SERVICE_RUNNING, false)
        set(token) {
            if (token != null) {
                editor.putBoolean(PREF_KEY_IS_SERVICE_RUNNING, token)
            }

            // commit changes
            editor.commit()
        }

    fun getNotificationResponse(): NotificationAccessResponse? {
        val response: NotificationAccessResponse
        val gson = Gson()
        val userJson = pref.getString(PREF_KEY_NOTIFICATION_RESPONSE, "")
        return try {
            response = gson.fromJson(userJson, NotificationAccessResponse::class.java)
            response
        } catch (e: Exception) {
            null
        }
    }

    fun getPOSTokenResponse(): TokenResponse? {
        val response: TokenResponse
        val gson = Gson()
        val userJson = pref.getString(PREF_KEY_POSTOKEN_RESPONSE, "")
        return try {
            response = gson.fromJson(userJson, TokenResponse::class.java)
            response
        } catch (e: Exception) {
            null
        }
    }

    fun savePOSTokenResponse(response: TokenResponse) {
        val gson = Gson()
        val userString = gson.toJson(response)
        editor.putString(PREF_KEY_POSTOKEN_RESPONSE, userString).apply()
    }

    fun saveSelectedStore(response: UberStores.Store) {

        val gson = Gson()
        val userString = gson.toJson(response)
        editor.putString(PREF_KEY_SELECTED_STORE, userString).apply()
    }

    fun getSelectedStore(): UberStores.Store? {
        val response: UberStores.Store
        val gson = Gson()
        val userJson = pref.getString(PREF_KEY_SELECTED_STORE, "")
        return try {
            response = gson.fromJson(userJson, UberStores.Store::class.java)
            response
        } catch (e: Exception) {
            null
        }

    }

    fun getSessionId() = pref.getString(PREF_KEY_SESSION_ID, "nil")
    fun getEnterpriseId() = pref.getString(PREF_KEY_ENTERPRISE_ID, "nil")
    fun saveStoreToken(accessToken: String) {
        editor.putString("key_eats.store.token", accessToken).commit()
    }

    fun getStoreToken(): String = pref.getString("key_eats.store.token", "").toString()

    fun getStoreStatusWriteToken(): String =
        pref.getString("key_eats.store.statuswrite.token", "").toString()

    fun saveStoreStatusWriteToken(s: String) {
        editor.putString("key_eats.store.statuswrite.token", s).commit()
    }

    fun saveOrderDeliveryToken(accessToken: String) {
        editor.putString("key.eats.store.delivery.status", accessToken).commit()
    }

    fun getOrderDeliveryToken(): String? {
        return pref.getString("key.eats.store.delivery.status", "")
    }

    fun saveStoreDetails(body: StoreDetails) {
        val gson = Gson()
        val userString = gson.toJson(body)
        Log.e("TAG", "saveStoreDetails: details saved... ${body.avgPrepTime}")
        editor.putString(PREF_KEY_SELECTED_STORE_DETAILS, userString).apply()
    }

    fun getSelectedStoreDetails(): StoreDetails? {
        val response: StoreDetails
        val gson = Gson()
        val userJson = pref.getString(PREF_KEY_SELECTED_STORE_DETAILS, "")
        return try {
            response = gson.fromJson(userJson, StoreDetails::class.java) as StoreDetails
            response
        } catch (e: Exception) {
            null
        }

    }

    fun clearSession() {
        editor.clear().commit()
    }
}