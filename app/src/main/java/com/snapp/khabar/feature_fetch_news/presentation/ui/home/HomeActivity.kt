package com.snapp.khabar.feature_fetch_news.presentation.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.snapp.khabar.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val fragmentManager = supportFragmentManager

        viewPagerAdapter = ViewPagerAdapter(fragmentManager,lifecycle)
        val viewpager = findViewById<ViewPager2>(R.id.viewPager)
        viewpager.adapter = viewPagerAdapter
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        TabLayoutMediator(tabLayout,viewpager){tab , position ->
            tab.text = when(position){
                0 -> "All news"
                1 -> "Business"
                2 -> "Politics"
                3 -> "Tech"
                4 -> "Science"
                else -> "Sports"
            }

        }.attach()
    }
}