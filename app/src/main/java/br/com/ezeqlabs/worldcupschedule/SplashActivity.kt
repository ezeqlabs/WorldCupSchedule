package br.com.ezeqlabs.worldcupschedule

import android.content.Context
import android.content.Intent
import android.os.Bundle
import br.com.ezeqlabs.worldcupschedule.Api.RetrofitConfiguration
import br.com.ezeqlabs.worldcupschedule.Models.WorldCupInfo
import br.com.ezeqlabs.worldcupschedule.Utils.IntentParameters
import br.com.ezeqlabs.worldcupschedule.Utils.State
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import kotlinx.android.synthetic.main.activity_splash.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashActivity : BaseActivity() {
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        context = this
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
        adView.adListener = object : AdListener() {
            override fun onAdLoaded() {
                loadInfo()
            }

            override fun onAdFailedToLoad(errorCode: Int) {
                loadInfo()
            }
        }
    }

    fun loadInfo() {
        val call = RetrofitConfiguration.getService().getWorldCupInfo()
        call.enqueue(object : Callback<WorldCupInfo?> {
            override fun onFailure(call: Call<WorldCupInfo?>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<WorldCupInfo?>?, response: Response<WorldCupInfo?>?) {
                response?.let {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            val worldCupInfo = response.body()
                            worldCupInfo?.let {
                                if (worldCupInfo.phase == State.GROUPS) {
                                    val intent = Intent(context, MainActivity::class.java)
                                    intent.putExtra(IntentParameters.worldCupInfo, worldCupInfo)
                                    startActivity(intent)
                                    finish()
                                } else {
                                    val intent = Intent(context, FinalsActivity::class.java)
                                    intent.putExtra(IntentParameters.worldCupInfo, worldCupInfo)
                                    startActivity(intent)
                                    finish()
                                }
                            }
                        }
                    }
                }
            }

        })
        super.onResume()
    }
}
