package com.app.airmenu.ui.login.work

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.app.airmenu.AirMenuApp
import com.app.airmenu.local.PreferenceRepository
import com.app.airmenu.models.LoginResponse
import com.app.airmenu.network.response.StoreDetails
import com.app.airmenu.remote.RemoteRepository
import com.app.airmenu.session.SessionManager
import com.app.airmenu.utils.*
import com.elvishew.xlog.XLog
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.imprint.app.network.ApiClient
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

private const val TAG = "SessionUpdateWorker"

class SessionUpdateWorker(
    context: Context, workerParams: WorkerParameters
) : Worker(
    context,
    workerParams
) {

    private var mContext: Context = context
    private lateinit var sessionManager: SessionManager

    override fun doWork(): Result {
        val result = userLoginWithCredentials()
        return result!!
    }

    private fun userLoginWithCredentials(): Result? {
        sessionManager = SessionManager(applicationContext)
        val token = sessionManager.getStoreToken()
        ApiClient.token = "Bearer $token"

        var result: Result? = Result.failure()

        if (token != "" ) {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                     ApiClient.retrofitService.getStoreDetails(sessionManager.getSelectedStore()?.storeId.toString())
                        .enqueue(object :Callback<StoreDetails>{
                            override fun onResponse(
                                call: Call<StoreDetails>,
                                response: Response<StoreDetails>
                            ) {
                                if (response.isSuccessful && response.body() != null){
                                    sessionManager.saveStoreDetails(response.body()!!)
                                    XLog.e("Store details saved successfuly.")
                                }
                            }

                            override fun onFailure(call: Call<StoreDetails>, t: Throwable) {
                                XLog.e("Got error while getting store details... ${t.message}")
                            }
                        })

                } catch (exception: Exception) {
                    result = Result.failure()
                    Log.e(TAG, "loginWithCredentials: ", exception)
                }

            }//scope
        } else {
            XLog.e("Token null geting store detail failure")
            result = Result.failure()
        }

        return result
    }//end fun

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

    private fun saveLoginResponse(response: LoginResponse) {
        val gson = Gson()
        val userString = gson.toJson(response)
        prefs.edit().putString(PREF_KEY_LOGIN_RESPONSE, userString).apply()
    }

    private val prefs = mContext.getSharedPreferences(
        "com.app.airmenu", Context.MODE_PRIVATE
    )


}//end worker