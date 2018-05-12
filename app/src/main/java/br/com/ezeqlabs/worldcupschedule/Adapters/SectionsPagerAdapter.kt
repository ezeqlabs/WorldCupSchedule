package br.com.ezeqlabs.worldcupschedule.Adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import br.com.ezeqlabs.worldcupschedule.Models.Group
import br.com.ezeqlabs.worldcupschedule.Utils.PlaceholderFragment

class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    lateinit var groups: List<Group>

    override fun getItem(position: Int): Fragment {
        groups?.let {
            return PlaceholderFragment.newInstance(groups[position])
        }
    }

    override fun getCount(): Int {
        return groups.size
    }
}