package com.snapp.khabar.feature_fetch_news.presentation.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.snapp.khabar.R
import com.snapp.khabar.databinding.ActivityHomeLayoutBinding
import com.snapp.khabar.feature_fetch_news.domain.checkers.InternetAwareActivity
import com.snapp.khabar.feature_fetch_news.core.InternetAwareActivityImpl
import com.snapp.khabar.feature_fetch_news.presentation.ui.base.InternetAwareViewModel
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.home_fragment.adapters.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(), InternetAwareActivity by InternetAwareActivityImpl() {

    private var _binding: ActivityHomeLayoutBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private val homeViewModel: HomeViewModel by viewModels()
    private val internetAwareViewModel: InternetAwareViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this@HomeActivity,R.layout.activity_home_layout)
        supportFragmentManager

        val navController = findNavController(R.id.myNavHost)
        val bottomNavView = findViewById<BottomNavigationView>(R.id.menuView)

        bottomNavView.setupWithNavController(navController)

        consumeFlows()

    }


    private fun consumeFlows(){
        lifecycleScope.launchWhenCreated {
            // Handling Internet connectivity here
            handleInternetAvailability(
                binding.tvConnectionStatus,
                internetAwareViewModel,
                this
            )
        }
    }
}

private const val TAG = "HomeActivity"
