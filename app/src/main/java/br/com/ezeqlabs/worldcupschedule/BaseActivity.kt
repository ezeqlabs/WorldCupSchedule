package br.com.ezeqlabs.worldcupschedule

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.ads.MobileAds

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        MobileAds.initialize(this, getString(R.string.admob_app_id))
        super.onCreate(savedInstanceState, persistentState)
    }
}