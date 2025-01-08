package com.app.airmenu.ui.posIds

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.airmenu.local.PreferenceRepository
import com.app.airmenu.models.LoginResponse
import com.app.airmenu.models.PosIdsResponse
import com.app.airmenu.remote.RemoteRepository
import com.app.airmenu.utils.*
import com.google.gson.Gson
import com.google.gson.JsonObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "PosIdsViewModel"

@HiltViewModel
class PosIdsViewModel @Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val prefRepository: PreferenceRepository
) : ViewModel() {

    private val state: LiveData<RequestState>
    val requestState = MutableLiveData<RequestState>()

    init {
        state = requestState
    }

    fun getEnterpriseNames(): List<String>? {
        //get enterprise names from login response
        val loginResponse = prefRepository.getLoginResponse()
        return loginResponse?.enterpriseNames
    }

    fun getEnterpriseId(pos: Int): String {
        val loginResponse = prefRepository.getLoginResponse()
        val idsList = loginResponse?.enterpriseIds
        return if (idsList != null) {
            idsList[pos]
        } else "nil"
    }
    fun getEnterpriseName(pos: Int): String {
        val loginResponse = prefRepository.getLoginResponse()
        val idsList = loginResponse?.enterpriseNames
        return if (idsList != null) {
            idsList[pos]
        } else "nil"
    }

    fun saveEnterpriseId(id: String) {
        prefRepository.saveSelectedEnterpriseId(id)
    }
    fun saveEnterPriseName(id: String) {
        prefRepository.saveSelectedEnterpriseName(id)
    }

    fun getPosIds() {
        val sessionId = prefRepository.getLoginResponse()?.sessionId
        val enterpriseId = prefRepository.getSelectedEnterpriseId()
        if (sessionId == null || enterpriseId == null) {
            return
        }
        viewModelScope.launch(Dispatchers.IO) {
            try {
                requestState.postValue(RequestState.LOADING)
                val response = remoteRepository.getPosIds(
                    ACTION_POS_IDS,
                    "1.0.0",
                    serverKey,
                    formatToJson(sessionId, enterpriseId)
                )

                if (response.isSuccessful && response.body() != null) {
                    val res = response.body()?.string()?.split("=")

                    if (res != null) {
                        val posIdsResponse = parseToJsonObj(res[1])
                        //save to preferences
                        prefRepository.savePosIds(posIdsResponse!!)
                        Log.e(TAG, "getPosIds: response is=> $posIdsResponse")
                        requestState.postValue(RequestState.DONE)
                    }
                }

            } catch (ex: Exception) {
                requestState.postValue(RequestState.ERROR)
                Log.e(TAG, "getPosIds: ", ex)
            }

        }//scope
    }//end get

    fun saveSelectedDivisionNameMenu(divisionId: String) {
        prefRepository.saveSelectedDivisonNameMenu(divisionId)

    }
    fun saveSelectedDivisionIdMenu(divisionId: String) {
        Log.e(TAG, "saveSelectedDivisionId: enterprise for menu is saved => $divisionId", )
        prefRepository.saveSelectedDivisonIdMenu(divisionId)

    }
    private fun formatToJson(sessionId: String, enterpriseId: String): String {
        val obj = JsonObject()
        obj.addProperty(KEY_SESSION_ID, sessionId)
        obj.addProperty(KEY_ENTERPRISE_ID, enterpriseId)
        Log.e(TAG, "formatToJson: $obj")
        return obj.toString()
    }

    private fun parseToJsonObj(json: String): PosIdsResponse? {
        var posIdRes: PosIdsResponse? = null
        val gson = Gson()
        try {
            posIdRes = gson.fromJson(json, PosIdsResponse::class.java)
        } catch (e: Exception) {
            Log.e(TAG, "parseToJsonObj: ", e)
        }
        return posIdRes
    }

}