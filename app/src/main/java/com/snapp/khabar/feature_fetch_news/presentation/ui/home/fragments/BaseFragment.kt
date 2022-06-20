package com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.HomeViewModel
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.home_fragment.fragments.all_news.adapters.NewsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseFragment(
    private val adapterType: Int
): Fragment() {



    /**
     * Making News Adapter a Global variable so that data can be submitted to it
     * from any function
     * */
    var newsAdapter: NewsAdapter = NewsAdapter(adapterType)

}