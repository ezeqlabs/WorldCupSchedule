package br.com.ezeqlabs.worldcupschedule

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.ezeqlabs.worldcupschedule.Api.RetrofitConfiguration
import br.com.ezeqlabs.worldcupschedule.Models.WorldCupInfo
import br.com.ezeqlabs.worldcupschedule.Utils.IntentParameters
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashActivity : AppCompatActivity() {
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        context = this
    }

    override fun onResume() {
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
                                val intent = Intent(context, MainActivity::class.java)
                                intent.putExtra(IntentParameters.worldCupInfo, worldCupInfo)
                                startActivity(intent)
                                finish()
                            }
                        }
                    }
                }
            }

        })
        super.onResume()
    }
}
