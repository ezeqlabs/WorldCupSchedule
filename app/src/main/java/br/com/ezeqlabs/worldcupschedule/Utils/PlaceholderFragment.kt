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

class PlaceholderFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)
        val group = arguments.getSerializable(GROUP) as Group

        group?.let {
            rootView.section_label.text = getString(R.string.section_format, group.letter)

            for(game in group.games) {
                val matchView = inflater.inflate(R.layout.item_match, null)

                val date = game.date
                val day = game.day
                val matchDate = "$date - $day"
                matchView.tv_match_date.text = matchDate

                matchView.tv_home_team.text = game.team_home
                matchView.tv_home_score.text = game.team_score
                matchView.tv_away_score.text = game.away_score
                matchView.tv_away_team.text = game.away_team

                val hour = game.time
                val time = "$hour (Russian time)"
                matchView.tv_time.text = time

                val city = game.city
                val stadium = game.stadium
                val place = "$stadium - $city"
                matchView.tv_place.text = place

                rootView.ll_container_matches.addView(matchView)
            }
        }

        return rootView
    }

    companion object {
        private val GROUP = "group"

        fun newInstance(group: Group): PlaceholderFragment {
            val fragment = PlaceholderFragment()
            val args = Bundle()
            args.putSerializable(GROUP, group)
            fragment.arguments = args
            return fragment
        }
    }
}