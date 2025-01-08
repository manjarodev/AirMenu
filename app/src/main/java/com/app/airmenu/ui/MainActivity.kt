package com.app.airmenu.ui


import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import com.app.airmenu.R
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
           if(!Settings.canDrawOverlays(this)){
               val intent =
                   Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:$packageName"))
               startActivityForResult(intent, 0)
           }
        }

    }


}