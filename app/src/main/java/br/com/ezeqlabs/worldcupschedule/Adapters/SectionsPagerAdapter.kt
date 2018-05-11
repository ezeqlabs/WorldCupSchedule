package br.com.ezeqlabs.worldcupschedule.Adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import br.com.ezeqlabs.worldcupschedule.Utils.PlaceholderFragment

class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    val groups = arrayOf("A", "B", "C", "D", "E", "F", "G", "H")

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceholderFragment.newInstance(groups[position])
    }

    override fun getCount(): Int {
        return groups.size
    }
}