package com.study.aos.quest.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.study.aos.quest.ui.main.home.HomeFragment
import com.study.aos.quest.ui.main.rank.RankFragment
import com.study.aos.quest.ui.main.star.StarFragment

class MainViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> RankFragment()
        1 -> HomeFragment()
        2 -> StarFragment()
        else -> throw IllegalStateException("Unexpected position $position")
    }

    override fun getItemCount(): Int = 3
}