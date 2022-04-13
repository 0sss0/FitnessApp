package com.example.fitnessapp.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fitnessapp.ui.activity.MyTrackFragment
import com.example.fitnessapp.ui.activity.UsersTrackFragment

class ViewPagerAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                MyTrackFragment()
            }
            1 -> {
                UsersTrackFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}