package com.app.airmenu.ui.divisionIds

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.airmenu.local.PreferenceRepository
import com.app.airmenu.models.DivisionIdsResponse
import com.app.airmenu.models.NotificationAccessResponse
import com.app.airmenu.remote.RemoteRepository
import com.app.airmenu.utils.*
import com.google.gson.Gson
import com.google.gson.JsonObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "DivisionIdsViewModel"

@HiltViewModel
class DivisionIdsViewModel @Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val preferenceRepository: PreferenceRepository
) : ViewModel() {

    private val state: LiveData<RequestState>
    val requestState = MutableLiveData<RequestState>()

    private val error: LiveData<String>
    val errorDescription = MutableLiveData<String>()

    init {
        state = requestState
        error = errorDescription
    }

    fun getDivisionList(): List<DivisionIdsResponse.DivisionTree>? {
        return preferenceRepository.getDivisionIdsResponse()?.divisionTree
    }

    fun saveSelectedDivisionId(divisionId: String) {
        Log.e(TAG, "saveSelectedDivisionId: division is saved => $divisionId", )
        preferenceRepository.saveSelectedDivisonId(divisionId)

    }

    fun saveSelectedDivisionName(divisionId: String) {
        preferenceRepository.saveSelectedDivisonName(divisionId)

    }


    fun getSocketInfo(posId: String) {
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
                        preferenceRepository.getSelectedEnterpriseId()
                    )
                )

                if (response.isSuccessful && response.body() != null) {
                    val res = response.body()?.string()?.split("=")
                    if (res != null) {
                        notificationResponse = parseToJsonObj(res[1])
                        //save in preferences
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
        enterpriseId: String?
    ): String {
        val obj = JsonObject()
        obj.addProperty(KEY_SESSION_ID, sessionId)
        obj.addProperty(KEY_ENTERPRISE_ID, enterpriseId)
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

}