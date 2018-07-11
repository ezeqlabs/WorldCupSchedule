package br.com.ezeqlabs.worldcupschedule

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import br.com.ezeqlabs.worldcupschedule.Models.WorldCupInfo
import br.com.ezeqlabs.worldcupschedule.Utils.IntentParameters
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.reward.RewardItem
import com.google.android.gms.ads.reward.RewardedVideoAd
import com.google.android.gms.ads.reward.RewardedVideoAdListener
import kotlinx.android.synthetic.main.activity_fan_area.*
import kotlinx.android.synthetic.main.dialog_vote.*
import kotlinx.android.synthetic.main.menu_bottom.*

class FanAreaActivity : BaseActivity(), RewardedVideoAdListener {
    private var worldCupInfo: WorldCupInfo? = null
    private lateinit var mRewardedVideoAd: RewardedVideoAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fan_area)

        val extras = intent.extras
        setSupportActionBar(toolbar)

        extras?.let {
            worldCupInfo = extras.getSerializable(IntentParameters.worldCupInfo) as WorldCupInfo
        }

        prepareBottomMenu()

        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this)
        mRewardedVideoAd.rewardedVideoAdListener = this
    }

    fun clickVideo(v: View) {
        if (mRewardedVideoAd.isLoaded) {
            mRewardedVideoAd.show()
        }
    }

    private fun loadRewardedVideoAd() {
        hideProgressDialog()
        mRewardedVideoAd.loadAd(resources.getString(R.string.reward_video),
                AdRequest.Builder().build())

        showProgressDialog()
    }

    fun prepareBottomMenu() {
        bt_fan_area.setBackgroundColor(resources.getColor(R.color.colorAccent))

        bt_today.setOnClickListener {
            showProgressDialog()
            val intent = Intent(this, TodayActivity::class.java)
            intent.putExtra(IntentParameters.worldCupInfo, worldCupInfo)
            startActivity(intent)
            finish()
        }

        bt_groups_phase.setOnClickListener {
            showProgressDialog()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(IntentParameters.worldCupInfo, worldCupInfo)
            startActivity(intent)
            finish()
        }

        bt_finals_phase.setOnClickListener {
            showProgressDialog()
            val intent = Intent(this, FinalsActivity::class.java)
            intent.putExtra(IntentParameters.worldCupInfo, worldCupInfo)
            startActivity(intent)
            finish()
        }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(R.layout.dialog_vote)

        dialog.btVoted.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    override fun onPause() {
        super.onPause()
        mRewardedVideoAd.pause(this)
    }

    override fun onResume() {
        loadRewardedVideoAd()
        super.onResume()
        mRewardedVideoAd.resume(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mRewardedVideoAd.destroy(this)
    }

    override fun onRewardedVideoAdClosed() {
        loadRewardedVideoAd()
    }

    override fun onRewardedVideoAdLeftApplication() {
    }

    override fun onRewardedVideoAdLoaded() {
        hideProgressDialog()
    }

    override fun onRewardedVideoAdOpened() {
    }

    override fun onRewardedVideoCompleted() {
    }

    override fun onRewarded(p0: RewardItem?) {
        showDialog()
    }

    override fun onRewardedVideoStarted() {
    }

    override fun onRewardedVideoAdFailedToLoad(p0: Int) {
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            when (item.itemId) {
                R.id.action_refresh -> {
                    val intent = Intent(this, SplashActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
        return true
    }
}
