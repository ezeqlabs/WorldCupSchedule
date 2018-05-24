package br.com.ezeqlabs.worldcupschedule

import android.app.ProgressDialog
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.ads.MobileAds

open class BaseActivity : AppCompatActivity() {
    lateinit var progress: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        MobileAds.initialize(this, getString(R.string.admob_app_id))
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onStart() {
        hideProgressDialog()
        super.onStart()
    }

    fun showProgressDialog() {
        progress = ProgressDialog(this)
        progress.setMessage(resources.getString(R.string.wait))
        progress.show()
    }

    fun hideProgressDialog() {
        try {
            progress.dismiss()
        } catch (e: Exception) {}
    }

    override fun onLowMemory() {
        super.onLowMemory()
        System.gc()
    }
}