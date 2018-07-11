package br.com.ezeqlabs.worldcupschedule

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import br.com.ezeqlabs.worldcupschedule.Models.WorldCupInfo
import br.com.ezeqlabs.worldcupschedule.Utils.IntentParameters
import br.com.ezeqlabs.worldcupschedule.Utils.TextConverter
import kotlinx.android.synthetic.main.activity_today.*
import kotlinx.android.synthetic.main.item_match.view.*
import kotlinx.android.synthetic.main.menu_bottom.*

class TodayActivity : BaseActivity() {
    private var worldCupInfo: WorldCupInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_today)

        val extras = intent.extras

        extras?.let {
            worldCupInfo = extras.getSerializable(IntentParameters.worldCupInfo) as WorldCupInfo
            prepareInformation()
        }

        prepareBottomMenu()
    }

    private fun prepareInformation() {
        val group = worldCupInfo!!.gamesToday.get(0)
        if (group.games.isNotEmpty()) {
            container_games.visibility = View.VISIBLE
            container_no_games.visibility = View.GONE

            val textConverter = TextConverter(this)
            section_label.text = textConverter.convertLetter(group.letter)


            for (game in group.games) {
                val matchView = LayoutInflater.from(this).inflate(R.layout.item_match, null)
                val date = textConverter.convertDate(game.date)
                val day = textConverter.convertDay(game.day)
                val matchDate = "$date - $day"
                matchView.tv_match_date.text = matchDate

                matchView.tv_home_team.text = textConverter.convertCountry(game.team_home)
                matchView.tv_home_score.text = game.team_score
                matchView.tv_away_score.text = game.away_score
                matchView.tv_away_team.text = textConverter.convertCountry(game.away_team)

                val hour = textConverter.convertTime(game.time)
                val localTime = resources.getString(R.string.local_time)
                val time = "$hour - $localTime"
                matchView.tv_time.text = time

                val city = textConverter.convertCity(game.city)
                val stadium = textConverter.convertStadium(game.stadium)
                val place = "$stadium - $city"
                matchView.tv_place.text = place

                matchView.adViewMatch.visibility = View.GONE

                content_games_today.addView(matchView)
            }

        } else {
            container_games.visibility = View.GONE
            container_no_games.visibility = View.VISIBLE
        }
    }

    private fun prepareBottomMenu() {
        bt_today.setBackgroundColor(resources.getColor(R.color.colorAccent))

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

        bt_fan_area.setOnClickListener {
            showProgressDialog()
            val intent = Intent(this, FanAreaActivity::class.java)
            intent.putExtra(IntentParameters.worldCupInfo, worldCupInfo)
            startActivity(intent)
            finish()
        }
    }
}
