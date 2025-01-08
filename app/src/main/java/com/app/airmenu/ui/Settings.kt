package com.app.airmenu.ui

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.app.airmenu.R
import com.app.airmenu.databinding.ActivitySettingsBinding
import com.app.airmenu.local.PreferenceRepository
import com.app.airmenu.session.SessionManager
import com.app.airmenu.utils.TransparentProgressDialog
import com.elvishew.xlog.XLog
import com.imprint.app.network.ApiClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Settings : AppCompatActivity() {

    private val TAG: String = Settings::class.java.simpleName

    private lateinit var binding: ActivitySettingsBinding
    private lateinit var sessionManager: SessionManager
    private lateinit var mDialog: TransparentProgressDialog
//    @Inject
//    lateinit var prefRepository: PreferenceRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mDialog = TransparentProgressDialog(this)
        sessionManager = SessionManager(this)
        binding.status.setOnClickListener {
            showConfirmationDialoag()
        }
    }

    private fun showConfirmationDialoag() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.deprovision_dialog)
        dialog.getWindow()?.setBackgroundDrawableResource(android.R.color.transparent);
        val deprovision = dialog.findViewById(R.id.de_provision) as AppCompatButton
        val close = dialog.findViewById(R.id.close) as ImageButton
        deprovision.setOnClickListener {
            deProvisionStore()

        }
        close.setOnClickListener { dialog.dismiss() }
        dialog.show()

    }

    private fun deProvisionStore() {
        mDialog.show()
        ApiClient.token = "Bearer " + sessionManager.getPOSTokenResponse()?.accessToken

        ApiClient.retrofitService.deProisionStore(sessionManager.getSelectedStore()?.storeId.toString())
            .enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    mDialog.dismiss()
                    XLog.e( "De provisioning the store ${response.body()}")
                    if (response.isSuccessful) {
                        sessionManager.clearSession()
                        val intentToScreen = Intent(applicationContext, MainActivity::class.java)
                        //intentToScreen.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                        intentToScreen.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                      ///  intentToScreen.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intentToScreen)
                        overridePendingTransition(0, 0)
                        Toast.makeText(
                            this@Settings,
                            "SDe provisioned store successfully.",
                            Toast.LENGTH_SHORT
                        ).show()
                        finish()
                    } else {
                        Toast.makeText(
                            this@Settings,
                            "Something went wrong while deprovisioning store.",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                }

                override fun onFailure(call: Call<okhttp3.ResponseBody>, t: Throwable) {
                    mDialog.dismiss()
                    Toast.makeText(
                        this@Settings,
                        "Something went wrong while deprovisioning store.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
    }
}