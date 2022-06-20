package com.snapp.khabar.feature_fetch_news.presentation.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.snapp.khabar.R
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.home_fragment.adapters.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_layout)
        val fragmentManager = supportFragmentManager



        val navController = findNavController(R.id.myNavHost)
        val bottomNavView = findViewById<BottomNavigationView>(R.id.menuView)

        bottomNavView.setupWithNavController(navController)

    }
}

/**
 * TODO:
 * Step 1: Change name of activity home to fragment home.
 * Step 2: Create a new Fragment with name home fragment
 * Step 3: Copy code from HomeActivity onCreate method to newly created HomeFragments onCreateView method.
 * Step 4: Rename activity_main layout to activity_home layout
 * Step 5: Link newly created activity_home layout to the HomeActivity
 * Step 6: Link bottomNavBar with the navhost and navController in the HomeActivities onCreate method
 * */