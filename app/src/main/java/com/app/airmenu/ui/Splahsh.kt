package com.app.airmenu.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.ViewGroup
import android.webkit.*
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.app.airmenu.databinding.ActivitySplahshBinding
import com.app.airmenu.network.response.TokenResponse
import com.app.airmenu.session.SessionManager
import com.app.airmenu.utils.FireManager
import com.app.airmenu.utils.UBER_AUTH_URL
import com.app.airmenu.utils.UBER_CLIENT_ID
import com.app.airmenu.utils.UBER_CLIENT_SECRET
import com.elvishew.xlog.XLog
import com.google.firebase.firestore.FieldValue
import com.imprint.app.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception


class Splahsh : AppCompatActivity() {

    private val TAG = "Splash"
    private lateinit var binding: ActivitySplahshBinding
    private var mDelayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 500 //3 seconds
    var sessionManager: SessionManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplahshBinding.inflate(layoutInflater)
        setContentView(binding.root)


        sessionManager = SessionManager(this)

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            if (!checkIfAlreadyhavePermission()) {
                requestForSpecificPermission()
            } else {

                mDelayHandler = Handler(Looper.getMainLooper())

                mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)
            }
        } else {

            mDelayHandler = Handler(Looper.getMainLooper())

            mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)
        }


        val settings = binding.webview.settings

        settings.javaScriptEnabled = true
        //binding.webview.loadUrl("https://login.uber.com/oauth/v2/authorize?response_type=code&client_id=ISOkRlMQwg38CufEUItAKBLGeFk8H8Mi&redirect_uri=https://codytest.site/test")
//      binding.webview.loadUrl("https://login.uber.com/oauth/v2/authorize?response_type=code&client_id=ISOkRlMQwg38CufEUItAKBLGeFk8H8Mi&redirect_uri=https://codytest.site/test")

        val client = object : WebViewClient() {

            override fun shouldInterceptRequest(
                view: WebView?,
                request: WebResourceRequest?
            ): WebResourceResponse? {
                runOnUiThread {
                    if (view?.url?.contains("https://info.airmenu.com/en?") == true) {
                        Log.e(TAG, "code found")
                        val res = view.url?.split("=")
                        if (res != null) {
                            Log.e(TAG, "code is=> ${res[1]}")
                            getToken(res[1])
                        }
                    }
                }
                return super.shouldInterceptRequest(view, request)
            }

            override fun onLoadResource(view: WebView?, url: String?) {
                //super.onLoadResource(view, url)

                Log.e(TAG, "onLoadResource: $url")

            }


            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                Log.e(TAG, "shouldOverrideUrlLoading: ${view?.url}")
                return false
            }
        }

        binding.webview.webViewClient = client
    }


    private fun getToken(s: String) {
        ApiClient.retrofitService.getAccessToken(
            UBER_AUTH_URL,
            UBER_CLIENT_ID,
            UBER_CLIENT_SECRET,
            "authorization_code",
            s,
            "https://info.airmenu.com/en"
        ).enqueue(object : Callback<TokenResponse> {
            override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
                Log.e(TAG, "onResponse: ${response.body()}")
            }

            override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }


        })
    }

    private val mRunnable: Runnable = Runnable {

        var intentToScreen: Intent

        if (!isFinishing) {

            if (sessionManager == null) {
                sessionManager = SessionManager(this)
            }
            //sessionManager!!.isLoggedIn
            if (sessionManager?.getNotificationResponse() != null) {
                intentToScreen = Intent(applicationContext, HomeActivity::class.java)
                intentToScreen.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                intentToScreen.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intentToScreen)
                overridePendingTransition(0, 0)
                finish()
            } else {
                intentToScreen = Intent(applicationContext, MainActivity::class.java)
                intentToScreen.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                intentToScreen.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intentToScreen)
                overridePendingTransition(0, 0)
                finish()
            }
        }
    }


    override fun onDestroy() {

        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }

        super.onDestroy()
    }

    private fun checkIfAlreadyhavePermission(): Boolean {
        val result =
            ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        return result == PackageManager.PERMISSION_GRANTED
    }

    private fun requestForSpecificPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ),
            101
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        try {
            when (requestCode) {
                101 -> {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                        mDelayHandler = Handler(Looper.getMainLooper())

                        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)
                    } else {
                        //not granted
                    }
                }
                else -> {
                    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "onRequestPermissionsResult: exception ${e.message}")
        }

    }
}