package br.com.ezeqlabs.worldcupschedule

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import br.com.ezeqlabs.worldcupschedule.Adapters.SectionsPagerAdapter
import br.com.ezeqlabs.worldcupschedule.Models.WorldCupInfo
import br.com.ezeqlabs.worldcupschedule.Utils.IntentParameters
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

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
            mSectionsPagerAdapter!!.groups = worldCupInfo!!.groups
            container.adapter = mSectionsPagerAdapter
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_finals) {
            val intent = Intent(this, FinalsActivity::class.java)
            intent.putExtra(IntentParameters.worldCupInfo, worldCupInfo)
            startActivity(intent)
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
