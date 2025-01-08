package com.app.airmenu.ui.login

import android.content.Context
import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.*
import com.app.airmenu.local.PreferenceRepository
import com.app.airmenu.models.LoginResponse
import com.app.airmenu.remote.RemoteRepository
import com.app.airmenu.ui.login.work.SessionUpdateWorker
import com.app.airmenu.utils.*
import com.google.common.util.concurrent.ListenableFuture
import com.google.gson.Gson
import com.google.gson.JsonObject
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

private const val TAG = "LoginViewModel"

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: RemoteRepository,
    private val prefRepository: PreferenceRepository
) : ViewModel() {

    private val state: LiveData<RequestState>
    val requestState = MutableLiveData<RequestState>()

    private val error: LiveData<String>
    val errorDescription = MutableLiveData<String>()

    init {
        state = requestState
        error = errorDescription
    }

    fun loginWithCredentials(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                requestState.postValue(RequestState.LOADING)
                val response = repository.loginWithCredentials(
                    "Authenticate",
                    "1.0.0",
                    serverKey,
                    formatToJson(email, password)
                )
                if (response.isSuccessful && response.body() != null) {

                    val res = response.body()?.string()?.split("=")

                    if (res != null) {
                        val loginResponse = parseToJsonObj(res[1])

                        if (loginResponse?.status == STATUS_SUCCESS) {

                            REMOTE_REPO = repository

                            //save to user preferences
                            prefRepository.saveLoginResponse(loginResponse)
                            prefRepository.saveSessionId(loginResponse.sessionId!!)

                            //save user email & password
                            prefRepository.saveUserEmail(email)
                            prefRepository.saveUserPassword(password)

                            Log.e(TAG, "response is => $loginResponse")
                            requestState.postValue(RequestState.DONE)

                        } else {
                            errorDescription.postValue("Wrong username or password")
                        }
                    }
                }
            } catch (exception: Exception) {
                requestState.postValue(RequestState.ERROR)
                Log.e(TAG, "loginWithCredentials: ", exception)
            }
        }//cScope
    }//end login

    fun validator(email: String, password: String): Boolean {
        return email.isNotEmpty() && password.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email)
            .matches()
    }

    private fun formatToJson(email: String, password: String): String {
        val obj = JsonObject()
        obj.addProperty(KEY_USER_NAME, email)
        obj.addProperty(KEY_USER_PASSWORD, password)
        Log.e(TAG, "formatToJson: $obj")
        return obj.toString()
    }

    private fun parseToJsonObj(json: String): LoginResponse? {
        var loginRes: LoginResponse? = null
        val gson = Gson()
        try {
            loginRes = gson.fromJson(json, LoginResponse::class.java)
        } catch (e: Exception) {
            Log.e(TAG, "parseToJsonObj: ", e)
        }
        return loginRes
    }

    /**
     * gasdfgjdgh
     * @param context
     * @return LiveData<WorkInfo>
     */
    fun scheduleSessionUpdateTask(context: Context): LiveData<WorkInfo> {

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val myWork = PeriodicWorkRequestBuilder<SessionUpdateWorker>(
            25, TimeUnit.MINUTES
        )
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            "AverageTimeUpdateWork",
            ExistingPeriodicWorkPolicy.KEEP,
            myWork
        )

        return WorkManager.getInstance(context).getWorkInfoByIdLiveData(myWork.id)

    }//end schedule


}