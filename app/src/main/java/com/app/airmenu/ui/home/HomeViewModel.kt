package com.app.airmenu.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.airmenu.local.PreferenceRepository
import com.app.airmenu.models.LoginResponse
import com.app.airmenu.models.NotificationAccessResponse
import com.app.airmenu.remote.RemoteRepository
import com.app.airmenu.utils.*
import com.google.gson.Gson
import com.google.gson.JsonObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "HomeViewModel"

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val preferenceRepository: PreferenceRepository
) : ViewModel() {

    private val state: LiveData<RequestState>
    val requestState = MutableLiveData<RequestState>()

    private val error: LiveData<String>
    val errorDescription = MutableLiveData<String>()

    private val stateLogin: LiveData<RequestState>
    val requestStateLogin = MutableLiveData<RequestState>()

    private val errorLogin: LiveData<String>
    val errorDescriptionLogin = MutableLiveData<String>()

    init {
        state = requestState
        error = errorDescription

        stateLogin = requestStateLogin
        errorLogin = errorDescriptionLogin
    }

    fun getSelectedDivisionId(): String? {
        return preferenceRepository.getSelectedDivisionId()
    }

    fun getSocketInfo() {
        var notificationResponse: NotificationAccessResponse? = null
        viewModelScope.launch {
            try {
                requestState.postValue(RequestState.LOADING)
                val response = remoteRepository.getNotificationAccess(
                    ACTION_NOTIFICATION_ACCESS,
                    "1.0.0",
                    serverKey,
                    formatToJson(
                        preferenceRepository.getSessionId(),
                        preferenceRepository.getSelectedEnterpriseId(),
                        preferenceRepository.getSelectedPOSId()
                    )
                )

                if (response.isSuccessful && response.body() != null) {
                    val res = response.body()?.string()?.split("=")
                    if (res != null) {
                        notificationResponse = parseToJsonObj(res[1])
                        //save in preferences
                        if (notificationResponse?.statusCode == -1 && notificationResponse?.errorName.equals(
                                ERROR_SESSION_EXPIRED
                            )
                        ) {
                            requestState.postValue(RequestState.ERROR)
                            errorDescription.postValue("Session expired or user not logged in")
                            return@launch
                        }
                        preferenceRepository.saveNotificationResponse(notificationResponse!!)
                        Log.e(
                            TAG,
                            "getSocketInfo: notification response is=> $notificationResponse"
                        )
                        requestState.postValue(RequestState.DONE)
                    }
                } else {
                    //error message
                    requestState.postValue(RequestState.ERROR)
                    errorDescription.postValue("Session expired or user not logged in")
                }

            } catch (ex: Exception) {
                Log.e(TAG, "getSocketInfo: ", ex)
                requestState.postValue(RequestState.ERROR)
                if (notificationResponse?.statusCode == -1) {
                    errorDescription.postValue("Internal Server Error")
                } else {
                    errorDescription.postValue("Something went wrong")
                }
            }
        }//scope
    }

    private fun formatToJson(
        sessionId: String?,
        enterpriseId: String?,
        posId: String?
    ): String {
        val obj = JsonObject()
        obj.addProperty(KEY_SESSION_ID, sessionId)
        obj.addProperty(KEY_ENTERPRISE_ID, enterpriseId)
        obj.addProperty("posId", posId)
        Log.e(TAG, "formatToJson: $obj")
        return obj.toString()
    }


    private fun parseToJsonObj(json: String): NotificationAccessResponse? {
        var res: NotificationAccessResponse? = null
        val gson = Gson()
        try {
            res = gson.fromJson(json, NotificationAccessResponse::class.java)
        } catch (e: Exception) {
            Log.e(TAG, "parseToJsonObj: ", e)
        }
        return res
    }

    fun login() {
        loginWithCredentials(
            preferenceRepository.getUserEmail(),
            preferenceRepository.getUserPassword()
        )
    }


    fun loginWithCredentials(email: String?, password: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                requestStateLogin.postValue(RequestState.LOADING)
                val response = remoteRepository.loginWithCredentials(
                    "Authenticate",
                    "1.0.0",
                    serverKey,
                    formatToJsonLogin(email, password)
                )

                if (response.isSuccessful && response.body() != null) {

                    val res = response.body()?.string()?.split("=")

                    if (res != null) {
                        val loginResponse = parseToJsonObjLogin(res[1])

                        if (loginResponse?.status == STATUS_SUCCESS) {

                            REMOTE_REPO = remoteRepository

                            //save to user preferences
                            preferenceRepository.saveLoginResponse(loginResponse)
                            preferenceRepository.saveSessionId(loginResponse.sessionId!!)

                            //save user email & password
                            preferenceRepository.saveUserEmail(email.toString())
                            preferenceRepository.saveUserPassword(password.toString())

                            Log.e(TAG, "response is => $loginResponse")
                            requestStateLogin.postValue(RequestState.DONE)

                        } else if (loginResponse?.errorCode == 109) {
                            Log.e(TAG, "loginWithCredentials: error  ${loginResponse.errorCode}")
                            requestStateLogin.postValue(RequestState.SESSION_EXPIRED)

                        } else {
                            errorDescriptionLogin.postValue("Wrong username or password")
                        }
                    }
                }
            } catch (exception: Exception) {
                requestStateLogin.postValue(RequestState.ERROR)
                Log.e("mTAG", "loginWithCredentials: ", exception)
            }
        }//cScope
    }//end login

    private fun formatToJsonLogin(email: String?, password: String?): String {
        val obj = JsonObject()
        obj.addProperty(KEY_USER_NAME, email)
        obj.addProperty(KEY_USER_PASSWORD, password)
        Log.e(TAG, "formatToJson: $obj")
        return obj.toString()
    }


    private fun parseToJsonObjLogin(json: String): LoginResponse? {
        var loginRes: LoginResponse? = null
        val gson = Gson()
        try {
            loginRes = gson.fromJson(json, LoginResponse::class.java)
        } catch (e: Exception) {
            Log.e(TAG, "parseToJsonObj: ", e)
        }
        return loginRes
    }


}