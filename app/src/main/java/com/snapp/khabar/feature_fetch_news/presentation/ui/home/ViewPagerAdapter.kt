package com.snapp.khabar.feature_fetch_news.presentation.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.*
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.all_news.AllNewsFragment

const val NUMBER_OF_TABS = 6
class ViewPagerAdapter(
    private val fragmentManager: FragmentManager,
    private val lifecycle: Lifecycle
):FragmentStateAdapter(fragmentManager , lifecycle) {
    override fun getItemCount(): Int {
       return NUMBER_OF_TABS
    }

    override fun createFragment(position: Int): Fragment {
       return when(position){
           0 -> { AllNewsFragment() }
           1 -> {
               BusinessFragment()
           }
           2 -> {
               PoliticsFragment()
           }
           3 -> {
               TechFragment()
           }
           4 -> {
               ScienceFragment()
           }
           else -> {
               SportsFragment()
           }

       }
    }
}