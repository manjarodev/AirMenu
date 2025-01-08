package com.app.airmenu.local

import android.app.Application
import android.content.Context
import com.app.airmenu.models.DivisionIdsResponse
import com.app.airmenu.models.LoginResponse
import com.app.airmenu.models.NotificationAccessResponse
import com.app.airmenu.models.PosIdsResponse
import com.app.airmenu.utils.*
import com.google.gson.Gson
import javax.inject.Inject

class PreferenceRepository @Inject constructor(private val app: Application) {

    private val prefs = app.getSharedPreferences(
        "com.app.airmenu", Context.MODE_PRIVATE
    )

    fun saveSessionId(id: String) {
        prefs.edit().putString(PREF_KEY_SESSION_ID, id).apply()
    }

    fun clearSession() {
        prefs.edit().clear().commit()
    }

    fun getSessionId() = prefs.getString(PREF_KEY_SESSION_ID, "nil")

    fun saveUserEmail(email: String) {
        prefs.edit().putString(PREF_KEY_USER_EMAIL, email).apply()
    }

    fun saveUserPassword(password: String) {
        prefs.edit().putString(PREF_KEY_USER_PASSWORD, password).apply()
    }

    fun getUserEmail() = prefs.getString(PREF_KEY_USER_EMAIL, "nil")

    fun getUserPassword() = prefs.getString(PREF_KEY_USER_PASSWORD, "nil")

    fun saveLoginResponse(response: LoginResponse) {
        val gson = Gson()
        val userString = gson.toJson(response)
        prefs.edit().putString(PREF_KEY_LOGIN_RESPONSE, userString).apply()
    }

    fun saveNotificationResponse(response: NotificationAccessResponse) {
        val gson = Gson()
        val userString = gson.toJson(response)
        prefs.edit().putString(PREF_KEY_NOTIFICATION_RESPONSE, userString).apply()
    }

    fun savePosIds(response: PosIdsResponse) {
        val gson = Gson()
        val userString = gson.toJson(response)
        prefs.edit().putString(PREF_KEY_POS_ID_RESPONSE, userString).apply()
    }

    fun getLoginResponse(): LoginResponse? {
        val response: LoginResponse
        val gson = Gson()
        val userJson = prefs.getString(PREF_KEY_LOGIN_RESPONSE, "")
        return try {
            response = gson.fromJson(userJson, LoginResponse::class.java)
            response
        } catch (e: Exception) {
            null
        }
    }

    fun getPosIdsResponse(): PosIdsResponse? {
        val response: PosIdsResponse
        val gson = Gson()
        val userJson = prefs.getString(PREF_KEY_POS_ID_RESPONSE, "")
        return try {
            response = gson.fromJson(userJson, PosIdsResponse::class.java)
            response
        } catch (e: Exception) {
            null
        }
    }

    fun getNotificationResponse(): NotificationAccessResponse? {
        val response: NotificationAccessResponse
        val gson = Gson()
        val userJson = prefs.getString(PREF_KEY_NOTIFICATION_RESPONSE, "")
        return try {
            response = gson.fromJson(userJson, NotificationAccessResponse::class.java)
            response
        } catch (e: Exception) {
            null
        }
    }

    fun saveSelectedEnterpriseId(id: String) {
        prefs.edit().putString(PREF_KEY_ENTERPRISE_ID, id).apply()
    }

    fun saveSelectedEnterpriseName(id: String) {
        prefs.edit().putString(PREF_KEY_ENTERPRISE_NAME, id).apply()
    }

    fun getSelectedEnterPriseName(): String? = prefs.getString(PREF_KEY_ENTERPRISE_NAME, "")

    fun getSelectedEnterpriseId() = prefs.getString(PREF_KEY_ENTERPRISE_ID, "nil")
    fun getSelectedDivisionIdMenu() = prefs.getString(PREF_KEY_DIVISION_ID_Menu, "nil")


    fun savePushNotificationToken(token: String) =
        prefs.edit().putString(PREF_KEY_NOTIFICATION_TOKEN, token).commit()

    fun saveSelectedPOSId(posId: String) = prefs.edit().putString(PREF_KEY_POS_ID, posId).commit()
    fun getSelectedPOSId() = prefs.getString(PREF_KEY_POS_ID, "nil")
    fun saveDivisionIds(divisionIdsResponse: DivisionIdsResponse?) {
        val gson = Gson()
        val userString = gson.toJson(divisionIdsResponse)
        prefs.edit().putString(PREF_KEY_DIVISION_ID_RESPONSE, userString).apply()
    }

    fun getDivisionIdsResponse(): DivisionIdsResponse? {
        val response: DivisionIdsResponse
        val gson = Gson()
        val userJson = prefs.getString(PREF_KEY_DIVISION_ID_RESPONSE, "")
        return try {
            response = gson.fromJson(userJson, DivisionIdsResponse::class.java)
            response
        } catch (e: Exception) {
            null
        }
    }

    fun saveSelectedDivisonId(divisionId: String) =
        prefs.edit().putString(PREF_KEY_DIVISION_ID, divisionId).commit()

    fun saveSelectedDivisonIdMenu(divisionId: String) = prefs.edit().putString(
        PREF_KEY_DIVISION_ID_Menu, divisionId
    ).commit()

    fun saveSelectedDivisonName(divisionId: String) =
        prefs.edit().putString(PREF_KEY_DIVISION_NAME, divisionId).commit()

    fun saveSelectedDivisonNameMenu(divisionId: String) =
        prefs.edit().putString(PREF_KEY_DIVISION_NAME_Menu, divisionId).commit()


    fun getSelectedDivisionName(): String? = prefs.getString(PREF_KEY_DIVISION_NAME, "")
    fun getSelectedDivisionNameMenu(): String? = prefs.getString(PREF_KEY_DIVISION_NAME_Menu, "")

    fun getSelectedDivisionId() = prefs.getString(PREF_KEY_DIVISION_ID, "")

    companion object {
        @Volatile
        private var instance: PreferenceRepository? = null

        fun getInstance(app: Application) =
            instance ?: synchronized(this) {
                instance ?: PreferenceRepository(app).also { instance = it }
            }
    }


}