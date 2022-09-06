package com.ssd.tab_layout.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ssd.tab_layout.fragment.MainFragment
import com.ssd.tab_layout.fragment.PostFragment
import com.ssd.tab_layout.fragment.SettingFragment

class PagerAdapter(
    fragmentManager: FragmentManager
) : FragmentPagerAdapter(fragmentManager) {

    /**
     * @return tab 페이지 수
     */
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> MainFragment()
            1 -> PostFragment()
            else -> SettingFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Main"
            1 -> "Post"
            else -> "Settings"
        }
    }

}