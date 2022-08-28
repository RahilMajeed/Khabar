package com.snapp.khabar.feature_fetch_news.presentation.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.snapp.khabar.R
import com.snapp.khabar.databinding.ActivityHomeLayoutBinding
import com.snapp.khabar.feature_fetch_news.presentation.ui.base.InternetAwareViewModel
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.home_fragment.adapters.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

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
            internetAwareViewModel.isConnectionAvailableChannel.collect { isConnected ->
                if (!isConnected){
                    binding.tvConnectionStatus.visibility = View.VISIBLE
                } else {
                    binding.tvConnectionStatus.visibility = View.GONE
                }
            }
        }
    }
}

private const val TAG = "HomeActivity"
