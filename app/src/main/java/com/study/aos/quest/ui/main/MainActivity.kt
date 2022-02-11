package com.study.aos.quest.ui.main

import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.study.aos.quest.R
import com.study.aos.quest.databinding.ActivityMainBinding
import com.study.aos.quest.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this

        setMainViewpagerAdapter()
        setOnBottomNavigationClick()
    }


    private fun setMainViewpagerAdapter() {
        binding.vpMain.apply {
            adapter = MainViewPagerAdapter(this@MainActivity)
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.bnvMain.selectedItemId =
                        when (position) {
                            0 -> R.id.menu_rank
                            1 -> R.id.menu_home
                            // 2 -> R.id.menu_star
                            else -> throw IndexOutOfBoundsException()
                        }
                }
            })
        }
    }

    private fun setOnBottomNavigationClick() {
        binding.bnvMain.setOnItemSelectedListener { item ->
          when (item.itemId) {
                R.id.menu_rank -> binding.vpMain.currentItem = 0
                R.id.menu_home -> binding.vpMain.currentItem = 1
                // R.id.menu_star -> binding.vpMain.currentItem = 2
                else -> throw IndexOutOfBoundsException()
            }
            true
        }
    }


}