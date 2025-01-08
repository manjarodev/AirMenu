package com.app.airmenu.ui.notification

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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "NotificationAccessViewM"

@HiltViewModel
class NotificationAccessViewModel @Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val preferenceRepository: PreferenceRepository
) : ViewModel() {

    private val state: LiveData<RequestState>
    val requestState = MutableLiveData<RequestState>()

    private val error: LiveData<String>
    val errorMessage = MutableLiveData<String>()

    init {
        state = requestState
        error = errorMessage
    }

    fun getPosIdsList(): List<String>? {
        return preferenceRepository.getPosIdsResponse()?.posIds
    }

    fun getPosIdAtPosition(position: Int): String {
        val posIds = preferenceRepository.getPosIdsResponse()?.posIds
        return if (posIds != null) {
            posIds[position]
        } else {
            "nil"
        }
    }

    fun getDivisionIdsResponse(): DivisionIdsResponse? {
        val response = preferenceRepository.getDivisionIdsResponse()
        return response
    }

    fun getDivisionIds() {
        val sessionId = preferenceRepository.getLoginResponse()?.sessionId
        val enterpriseId = preferenceRepository.getSelectedEnterpriseId()
        if (sessionId == null || enterpriseId == null) {
            return
        }
        viewModelScope.launch(Dispatchers.IO) {
            try {
                requestState.postValue(RequestState.LOADING)
                val response = remoteRepository.getDivisionIds(
                    ACTION_DIVISION_IDS,
                    "1.0.0",
                    serverKey,
                    formatToJson(sessionId, enterpriseId)
                )

                if (response.isSuccessful && response.body() != null) {
                    val res = response.body()?.string()?.split("=")


                    if (res != null) {
                        val divisionIdsResponse: DivisionIdsResponse? = parseToJsonObj(res[1])
                        //save to preferences
                        preferenceRepository.saveDivisionIds(divisionIdsResponse)
                        Log.e(
                            TAG,
                            "getDivisionIds: response is=> ${divisionIdsResponse!!.statusCode}"
                        )
                        requestState.postValue(RequestState.DONE)
                    }
                }

            } catch (ex: Exception) {
                requestState.postValue(RequestState.ERROR)
                Log.e(TAG, "getDivisionIds: ", ex)
            }

        }//scope
    }//end get


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

    private fun parseToJsonObj(json: String): DivisionIdsResponse? {
        var res: DivisionIdsResponse? = null
        val gson = Gson()
        try {
            res = gson.fromJson(json, DivisionIdsResponse::class.java)
        } catch (e: Exception) {
            Log.e(TAG, "parseToJsonObj: ", e)
        }
        return res
    }

    fun saveSelectedPOSId(posId: String) {
        preferenceRepository.saveSelectedPOSId(posId)
    }


}//end class