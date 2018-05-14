package br.com.ezeqlabs.worldcupschedule.Utils

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.ezeqlabs.worldcupschedule.Models.Group
import br.com.ezeqlabs.worldcupschedule.R
import kotlinx.android.synthetic.main.fragment_main.view.*
import kotlinx.android.synthetic.main.item_match.view.*
import kotlinx.android.synthetic.main.row_team.view.*

class PlaceholderFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)
        val group = arguments.getSerializable(GROUP) as Group
        val phase = arguments.getSerializable(PHASE) as String

        rootView.btChangeInfos.setOnClickListener {
            if (rootView.groupInfoCard.visibility == View.GONE) {
                rootView.groupInfoCard.visibility = View.VISIBLE
                rootView.ll_container_matches.visibility = View.GONE
                rootView.btChangeInfos.text = context.resources.getString(R.string.view_group_matches)
            } else {
                rootView.groupInfoCard.visibility = View.GONE
                rootView.ll_container_matches.visibility = View.VISIBLE
                rootView.btChangeInfos.text = context.resources.getString(R.string.view_group_info)
            }
        }

        group?.let {
            val textConverter = TextConverter(context)

            if(group.letter.length > 1) {
                rootView.groupInfoCard.visibility = View.GONE
                rootView.ll_container_matches.visibility = View.VISIBLE
                rootView.btChangeInfos.visibility = View.GONE
            }

            rootView.section_label.text = textConverter.convertLetter(group.letter)

            for (team in group.teams) {
                val teamView = inflater.inflate(R.layout.row_team, null)

                teamView.teamName.text = textConverter.convertCountry(team.name)
                teamView.teamPoints.text = team.points.toString()
                teamView.teamMatchesPlayed.text = team.matchesPlayed.toString()
                teamView.teamWins.text = team.wins.toString()
                teamView.teamLoses.text = team.loses.toString()

                rootView.groupInfo.addView(teamView)
            }

            for (game in group.games) {
                val matchView = inflater.inflate(R.layout.item_match, null)

                val date = textConverter.convertDate(game.date)
                val day = textConverter.convertDay(game.day)
                val matchDate = "$date - $day"
                matchView.tv_match_date.text = matchDate

                matchView.tv_home_team.text = textConverter.convertCountry(game.team_home)
                matchView.tv_home_score.text = game.team_score
                matchView.tv_away_score.text = game.away_score
                matchView.tv_away_team.text = textConverter.convertCountry(game.away_team)

                val hour = textConverter.convertTime(game.time)
                val localTime = context.resources.getString(R.string.local_time)
                val time = "$hour - $localTime"
                matchView.tv_time.text = time

                val city = textConverter.convertCity(game.city)
                val stadium = textConverter.convertStadium(game.stadium)
                val place = "$stadium - $city"
                matchView.tv_place.text = place

                rootView.ll_container_matches.addView(matchView)
            }
        }

        return rootView
    }

    companion object {
        private val GROUP = "group"
        private val PHASE = "phase"

        fun newInstance(group: Group, phase: String): PlaceholderFragment {
            val fragment = PlaceholderFragment()
            val args = Bundle()
            args.putSerializable(GROUP, group)
            args.putString(PHASE, phase)
            fragment.arguments = args
            return fragment
        }
    }
}