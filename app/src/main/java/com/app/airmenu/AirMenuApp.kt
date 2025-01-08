package com.app.airmenu

import android.app.Application
import android.content.ContextWrapper
import android.os.Environment
import android.util.Log
import com.app.airmenu.utils.NetworkWatcher
import com.app.airmenu.utils.PLACES_API_KEY
import com.bugfender.sdk.Bugfender
import com.elvishew.xlog.LogConfiguration
import com.elvishew.xlog.LogLevel
import com.elvishew.xlog.XLog
import com.elvishew.xlog.flattener.DefaultFlattener
import com.elvishew.xlog.printer.AndroidPrinter
import com.elvishew.xlog.printer.Printer
import com.elvishew.xlog.printer.file.FilePrinter
import com.elvishew.xlog.printer.file.backup.NeverBackupStrategy
import com.elvishew.xlog.printer.file.clean.NeverCleanStrategy
import com.elvishew.xlog.printer.file.naming.DateFileNameGenerator
import com.google.android.libraries.places.api.Places
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class AirMenuApp : Application() {

    companion object {
        var instancee: AirMenuApp? = null
        var isInForeGround = true

        @Synchronized
        fun getInstance(): AirMenuApp? {
            if (null == instancee) {
                instancee = AirMenuApp()
            }
            return instancee
        }
    }


    override fun onCreate() {
        super.onCreate()

        Places.initialize(applicationContext, PLACES_API_KEY)

        instancee = this

//        Bugfender.init(this, "9Vr6xSklUDo58BFkUq9Hsop1nlXmkmro", BuildConfig.DEBUG)
//        Bugfender.enableCrashReporting()
//        Bugfender.enableUIEventLogging(this)
//        Bugfender.enableLogcatLogging() // optional, if you want logs automatically collected from logcat


        val cw = ContextWrapper(applicationContext)
        val fullPath = cw.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS).toString()
        Log.e("TAG", "onCreate: path is => $fullPath")
        var filePrinter =
            FilePrinter                      // Printer that print(save) the log to file
                .Builder(fullPath)                         // Specify the directory path of log file(s)
                .fileNameGenerator(DateFileNameGenerator())        // Default: ChangelessFileNameGenerator("log")
                .backupStrategy(NeverBackupStrategy())             // Default: FileSizeBackupStrategy(1024 * 1024)
                .cleanStrategy(NeverCleanStrategy())     // Default: NeverCleanStrategy()
                .flattener(DefaultFlattener())                          // Default: DefaultFlattener
                .build()

        val androidPrinter: Printer =
            AndroidPrinter(true) // Printer that print the log using android.util.Log

        //val consolePrinter: Printer = ConsolePrinter()
        XLog.init(config, androidPrinter, filePrinter)

    }

    var config = LogConfiguration.Builder()
        .logLevel(LogLevel.ALL)
        .tag("NotificationService") // Specify TAG, default: "X-LOG"
        //.enableThreadInfo() // Enable thread info, disabled by default
        // .enableStackTrace(2) // Enable stack trace info with depth 2, disabled by default
//        .enableBorder() // Enable border, disabled by default
//        .addInterceptor(
//            BlacklistTagsFilterInterceptor( // Add blacklist tags filter
//                "blacklist1", "blacklist2", "blacklist3"
//            )
//        )
        .build()


    fun setConnectivityListener(listener: NetworkWatcher.ConnectivityReceiverListener) {
        NetworkWatcher.connectivityReceiverListener = listener
    }


}