package com.playnoob.ui

import io.github.a26197993b77e31a4.o7b471d74a5346efb54aa326b892daf01d914ce99.ObfStr
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import com.appsflyer.AppsFlyerLib
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.onesignal.OneSignal
import com.playnoob.R
import com.playnoob.ui.startwa.StartWA
import io.github.a26197993b77e31a4.o7b471d74a5346efb54aa326b892daf01d914ce99.ObfustringThis


val startWA: StartWA = StartWA()
@ObfustringThis
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!isTaskRoot
            && intent.hasCategory(Intent.CATEGORY_LAUNCHER)
            && intent.action != null && intent.action == Intent.ACTION_MAIN
        ) {
            finish()
            return
        }
        setContentView(R.layout.activity_main)
        onnnn()
        startWA.setMainActivity(this)
    }

    private fun onnnn() {
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ObfStr("comSplaynoob").v("8f1q4581-108p-478p-qma8-c5pq7s4b8cq0"))
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
    }

    fun hh(): String {

        return try {
            AdvertisingIdClient.getAdvertisingIdInfo(this).id.toString()
        } catch (e: Exception) {
            ObfStr("comSplaynoob").v("pixx")
        }
    }

    fun gg(): String {
        return try {
            AppsFlyerLib.getInstance().getAppsFlyerUID(this).toString()
        } catch (e: Exception) {
            ObfStr("comSplaynoob").v("pixx")
        }
    }

    fun kl(): String {
        @Suppress("DEPRECATION") val a = Settings.Secure.getInt(
            contentResolver,
            Settings.Secure.ADB_ENABLED,
            0
        )

        return if (a == 1) {
            ObfStr("comSplaynoob").v("vfgq")
        } else {
            ObfStr("comSplaynoob").v("hoxet")
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
    }

}