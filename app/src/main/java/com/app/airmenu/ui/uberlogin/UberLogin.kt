package com.app.airmenu.ui.uberlogin

import android.content.Context
import android.content.Intent
import android.net.http.SslError
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.work.*
import com.app.airmenu.R
import com.app.airmenu.databinding.FragmentPosIdsBinding
import com.app.airmenu.databinding.FragmentUberLoginBinding
import com.app.airmenu.local.PreferenceRepository
import com.app.airmenu.network.response.TokenResponse
import com.app.airmenu.network.response.UberStores
import com.app.airmenu.session.FCMSession
import com.app.airmenu.session.SessionManager
import com.app.airmenu.ui.HomeActivity
import com.app.airmenu.ui.MainActivity
import com.app.airmenu.ui.login.work.SessionUpdateWorker
import com.app.airmenu.utils.*
import com.elvishew.xlog.XLog
import com.google.firebase.firestore.FieldValue
import com.google.gson.Gson
import com.google.protobuf.Api
import com.imprint.app.network.ApiClient
import com.squareup.okhttp.ResponseBody
import dagger.hilt.android.AndroidEntryPoint
import io.grpc.okhttp.internal.Util
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit
import javax.inject.Inject

private const val TAG = "UberLogin"

@AndroidEntryPoint
class UberLogin : Fragment(R.layout.fragment_uber_login) {

    private lateinit var binding: FragmentUberLoginBinding
    private lateinit var sessionManager: SessionManager
    private lateinit var fcmSession: FCMSession
    private lateinit var dialog: TransparentProgressDialog
    private lateinit var storesAdapter: StoresAdapter
    private var activityStarted = false
    private var shouldCallForCode = true

    @Inject
    lateinit var prefRepository: PreferenceRepository


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUberLoginBinding.bind(view)
        initViews()
    }

    var codeFound = false

    private fun initViews() {

        sessionManager = SessionManager(requireContext())
        fcmSession = FCMSession(requireContext())
        dialog = TransparentProgressDialog(requireContext())

        binding.btnConnect.setOnClickListener {

            if (binding.inputClientId.text.isNullOrEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Please provide a valid Client Id first.",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            if (binding.inputPassword.text.isNullOrEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Please provide a valid Client Secret first.",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            getAndSaveUberTokens()
        }

        val settings = binding.webview.settings
        settings.javaScriptEnabled = true

        // Clear all the Application Cache, Web SQL Database and the HTML5 Web Storage
        // WebStorage.getInstance().deleteAllData();

        // Clear all the cookies
        if (AppState.shouldClearCache) {
            CookieManager.getInstance().removeAllCookies(null)
            CookieManager.getInstance().flush()

            binding.webview.clearCache(true)
            binding.webview.clearFormData()
            binding.webview.clearHistory()
            binding.webview.clearSslPreferences()
            AppState.shouldClearCache = false
        }

        binding.webview.loadUrl(OAUTH_URL)


        val client = object : WebViewClient() {

            override fun shouldInterceptRequest(
                view: WebView?,
                request: WebResourceRequest?
            ): WebResourceResponse? {
                Log.e(TAG, "shouldInterceptRequest: inside $codeFound::$shouldCallForCode")

                try {
                    requireActivity().runOnUiThread {

                        if (view?.url?.contains("https://info.airmenu.com/en?") == true && !activityStarted) {
                            val res = view.url?.split("=")
                            if (res != null) {

                                if (!codeFound && shouldCallForCode) {
                                    shouldCallForCode = false
                                    Log.e(TAG, "shouldInterceptRequest: codeFound stoping loading")
                                    // view.stopLoading()
                                    Log.e(TAG, "code is=> ${res[1]}")

                                    getToken(res[1])
                                }

                            }
                        } else {
                            // showError("")
                        }
                    }

                } catch (e: Exception) {
                    Log.e(TAG, "shouldInterceptRequest: exception ${e.message}")
                }
                return super.shouldInterceptRequest(view, request)
            }

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                Log.e(TAG, "shouldOverrideUrlLoading: ${view?.url}")
                return false
            }

            override fun onReceivedSslError(
                view: WebView?,
                handler: SslErrorHandler?,
                error: SslError?
            ) {
//                super.onReceivedSslError(view, handler, error)
                handler!!.proceed()
            }
        }

        val chromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, progress: Int) {
                if (progress < 100 && binding.pbar.visibility == ProgressBar.GONE) {
                    binding.pbar.visibility = ProgressBar.VISIBLE
                }

                binding.pbar.progress = progress
                if (progress == 100) {
                    binding.pbar.visibility = ProgressBar.GONE
                }
            }
        }
        binding.webview.webViewClient = client
        binding.webview.webChromeClient = chromeClient
    }

    private fun showError(s: String) {
        if (s.isNullOrEmpty())
            Toast.makeText(requireContext(), "Something went worng.", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(requireContext(), s, Toast.LENGTH_SHORT).show()

    }

    private fun getToken(s: String) {
        Log.e(TAG, "getToken: getting token")
        dialog.show()
        ApiClient.retrofitService.getAccessToken(
            UBER_AUTH_URL,
            UBER_CLIENT_ID,
            UBER_CLIENT_SECRET,
            "authorization_code",
            s,
            REDIRECT_URI
        ).enqueue(object : Callback<TokenResponse> {
            override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
                //  binding.webview.onPause()
                //  binding.webview.stopLoading()
                if (response.isSuccessful && response.body() != null) {
                    shouldCallForCode = false

                    binding.mainlayout.visibility = View.GONE
                    savePOSToken(response.body()!!)
                    Log.e(TAG, "onResponse: posToken=> ${response.body()!!.accessToken}")
                    getStoreToken()
                } else if (response.code() == 400 && response.errorBody() != null) {
                    Log.e(TAG, "onResponse: reloading webview")
                    shouldCallForCode = true
                    codeFound = false
                    /// binding.webview.onResume()
                    //Do something after 100ms
                    Log.e(TAG, "onResponse: loading url again")
                    // binding.webview.loadUrl(OAUTH_URL)

                    dialog.dismiss()
                    refreshCurrentFragment()

                }
                Log.e(TAG, "onResponse: ${response.body()}")


            }

            override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                shouldCallForCode = true
                codeFound = true

                dialog.dismiss()
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }

    private fun refreshCurrentFragment() {
//        lifecycleScope.launchWhenResumed {
//
//        }
        try {
            val id = findNavController().currentDestination?.id
            findNavController().popBackStack(id!!, true)
            findNavController().navigate(id)
        } catch (e: Exception) {
            Log.e(TAG, "refreshCurrentFragment: ${e.message}")
        }


    }

    private fun getStores() {
        codeFound = true
        dialog.dismiss()

        Log.e(TAG, "getStores: getting stores.")
        ApiClient.token = "Bearer " + sessionManager.getPOSTokenResponse()?.accessToken
        val request = ApiClient.retrofitService.getMerchantStores()

        request.enqueue(object : Callback<UberStores> {
            override fun onResponse(call: Call<UberStores>, response: Response<UberStores>) {
                dialog.dismiss()
                if (response.isSuccessful && response.body() != null) {
                    showStores(response.body()!!)
                }
            }

            override fun onFailure(call: Call<UberStores>, t: Throwable) {
                dialog.dismiss()
                Log.e(TAG, "onFailure: exception", t)
                showError("Error while getting merchant store. ${t.message}")
            }
        })
    }

    private fun showStores(body: UberStores) {
        storesAdapter = StoresAdapter(requireContext(), body.stores)
        binding.storelist.layoutManager = LinearLayoutManager(requireContext())
        binding.storelist.adapter = storesAdapter
        storesAdapter.onStoreClick = {
            saveStoreData(it)
            provisionSelectedStore(it)
        }
    }

    private fun provisionSelectedStore(it: UberStores.Store) {
        XLog.e("provisioning the selected store.")
        dialog.show()

        ApiClient.token = "Bearer ${sessionManager.getPOSTokenResponse()?.accessToken}"

        val call = ApiClient.retrofitService.setupPOS(
            it.storeId,
            getRAWJson("pos_integration_enabled", true)
        )
        call.enqueue(object : Callback<okhttp3.ResponseBody> {
            override fun onResponse(
                call: Call<okhttp3.ResponseBody>,
                response: Response<okhttp3.ResponseBody>
            ) {
                dialog.dismiss()

                if (response.isSuccessful) {
                    XLog.e("Store provisioned successfully")
                    XLog.e("updating token=> ${fcmSession.fcmToken}")
                    if (!fcmSession.fcmToken.isNullOrEmpty()) {
                        sendRegistrationToServer(fcmSession.fcmToken!!)
                    }
                    getAndSaveUberTokens()
                } else {
                    XLog.e("Unexpected error while Provisioning the merchant store.")
                    showError("Unexpected error while Provisioning the merchant store.")
                }
            }

            override fun onFailure(call: Call<okhttp3.ResponseBody>, t: Throwable) {
                XLog.e("onFailure: provisioning the store ", t)
                dialog.dismiss()
            }
        })
    }

    private fun sendRegistrationToServer(token: String) {
        XLog.e("Sending token to firebase... $token")
        val ref = FireManager.tokenReference.document(sessionManager.getSelectedStore()?.storeId!!)
        ref.update("fcmTokens", FieldValue.arrayUnion(token)).addOnSuccessListener {
            Log.e(TAG, "token updated successfully")
        }.addOnFailureListener {
            Log.e(TAG, "should create token first.")
            val fcmTokens = arrayListOf(token)
            val map = HashMap<String, Any>()
            map.put("fcmTokens", fcmTokens)
            ref.set(map).addOnSuccessListener {
                Log.e(TAG, "Token created successfully.")
            }.addOnFailureListener {
                Log.e(TAG, "failure while creating token at firebase ${it.message}")
            }
        }
    }

    private fun getRAWJson(s: String, b: Boolean): JSONObject {
        val obj = JSONObject()
        obj.put(s, b)
        return obj
    }

    private fun saveStoreData(store: UberStores.Store) {
        Log.e(TAG, "saveStoreData: selected store called ${store.storeId}")
        sessionManager.saveSelectedStore(store)
    }

    private fun savePOSToken(body: TokenResponse) {
        sessionManager.savePOSTokenResponse(body)
    }


    private fun getAndSaveUberTokens() {
        XLog.e("getting uber Tokens")
        dialog.show()
        val request = ApiClient.retrofitService.getOrderToken(
            UBER_AUTH_URL,
            UBER_CLIENT_ID,
            UBER_CLIENT_SECRET,
            GRANT_TYPE,
            SCOPE_EATS_ORDER
        )

        request.enqueue(object : Callback<TokenResponse> {
            override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
                if (response.isSuccessful) {
                    val response = response.body()

                    val responseString = Gson().toJson(response).toString()
                    Log.e("uTAG", "onResponse: $responseString")

                    Log.e(
                        TAG,
                        "DetailsToken => ${response?.tokenType + " " + response?.accessToken}"
                    )
                    sessionManager.uberOrderDetailToken =
                        response?.tokenType + " " + response?.accessToken

                    val requestForAuthToken = ApiClient.retrofitService.getOrderToken(
                        UBER_AUTH_URL,
                        binding.inputClientId.text.toString().trim(),
                        binding.inputPassword.text.toString().trim(),
                        GRANT_TYPE,
                        SCOPE_EATS_STORE_ORDER_READ
                    )

                    requestForAuthToken.enqueue(object : Callback<TokenResponse> {
                        override fun onResponse(
                            call: Call<TokenResponse>,
                            response: Response<TokenResponse>
                        ) {
                            dialog.dismiss()
                            if (response.isSuccessful) {
                                sessionManager.uberOrderReadToken =
                                    response.body()?.tokenType + " " + response.body()?.accessToken
                                activityStarted = true
                                binding.webview.onPause()
                                binding.webview.stopLoading()
                                getStoreStatusWriteToken()


                            }
                        }

                        override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                            dialog.dismiss()
                            Log.e(TAG, "onFailure: error while getting second token ${t.message}")
                            Toast.makeText(
                                requireContext(),
                                "Login error ${t.message}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    })
                } else {
                    dialog.dismiss()
                    showError("")
                }
            }

            override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                dialog.dismiss()
                Log.e(TAG, "onFailure: error while getting token ${t.message}")
                Toast.makeText(requireContext(), "Login error ${t.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    private fun getStoreToken() {
        Log.e(TAG, "getStoreToken: called")
        val request = ApiClient.retrofitService.getOrderToken(
            UBER_AUTH_URL,
            UBER_CLIENT_ID, UBER_CLIENT_SECRET, GRANT_TYPE, SCOPE_EATS_STORE
        )

        request.enqueue(object : Callback<TokenResponse> {
            override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
                Log.e(TAG, "onResponse: storeTokenResponse => ${response.body().toString()} ")
                if (response.isSuccessful && response.body() != null) {

                    sessionManager.saveStoreToken(response.body()!!.accessToken)

                    getStores()

                }
            }

            override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: gettting storeToken ", t)
            }
        })
    }

    private fun getStoreStatusWriteToken() {
        val request = ApiClient.retrofitService.getOrderToken(
            UBER_AUTH_URL,
            UBER_CLIENT_ID, UBER_CLIENT_SECRET, GRANT_TYPE, SCOPE_EATS_STORE_STATUS_WRITE
        ).enqueue(object : Callback<TokenResponse> {
            override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    scheduleAvgTimeUpdateTask(requireContext())
                    sessionManager.saveStoreStatusWriteToken(response.body()!!.accessToken)
                    val intentToScreen =
                        Intent(requireContext(), HomeActivity::class.java)
                    intentToScreen.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                    intentToScreen.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    intentToScreen.putExtra("is", "is")
                    startActivity(intentToScreen)
                    requireActivity().overridePendingTransition(0, 0)
                    requireActivity().finish()
                }
            }

            override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: getting restaurant status write token", t)
            }
        })
    }

    fun scheduleAvgTimeUpdateTask(context: Context): LiveData<WorkInfo> {

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val myWork = PeriodicWorkRequestBuilder<SessionUpdateWorker>(
            1, TimeUnit.HOURS
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