package br.com.ezeqlabs.worldcupschedule

import android.content.Intent
import android.os.Bundle
import br.com.ezeqlabs.worldcupschedule.Adapters.SectionsPagerAdapter
import br.com.ezeqlabs.worldcupschedule.Models.WorldCupInfo
import br.com.ezeqlabs.worldcupschedule.Utils.IntentParameters
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.menu_bottom.*

class FinalsActivity : BaseActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    private var worldCupInfo: WorldCupInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        val extras = intent.extras

        extras?.let {
            worldCupInfo = extras.getSerializable(IntentParameters.worldCupInfo) as WorldCupInfo
            mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
            mSectionsPagerAdapter!!.phase = worldCupInfo!!.phase
            mSectionsPagerAdapter!!.groups = worldCupInfo!!.knockoutPhase
            container.adapter = mSectionsPagerAdapter
        }

        prepareBottomMenu()
    }

    fun prepareBottomMenu() {
        bt_finals_phase.setBackgroundColor(resources.getColor(R.color.colorAccent))

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

        bt_fan_area.setOnClickListener {
            showProgressDialog()
            val intent = Intent(this, FanAreaActivity::class.java)
            intent.putExtra(IntentParameters.worldCupInfo, worldCupInfo)
            startActivity(intent)
            finish()
        }
    }

}