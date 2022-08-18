package com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import com.snapp.khabar.feature_fetch_news.domain.mappers.toNewsEntity
import com.snapp.khabar.feature_fetch_news.domain.mappers.toNewsModel
import com.snapp.khabar.feature_fetch_news.domain.model.ArticleModel
import com.snapp.khabar.feature_fetch_news.domain.util.Result
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.HomeViewModel
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.home_fragment.fragments.all_news.adapters.NewsAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

private const val TAG = "BaseFragment"
@AndroidEntryPoint
open class BaseFragment(
    private val adapterType: Int
): Fragment() {



    val homeViewModel: HomeViewModel by viewModels()

    /**
     * Making News Adapter a Global variable so that data can be submitted to it
     * from any function
     * */
    var newsAdapter: NewsAdapter = NewsAdapter(adapterType){
        homeViewModel.insertNewsEntity(it.toNewsEntity())
    }

    fun observeNews(observable: LiveData<Result<List<ArticleModel>>>) {
        observable.observe(viewLifecycleOwner) { result ->
            when (result) {

                is Result.Loading -> {
                    Log.d(TAG, "Loading: ")

                }
                is Result.Error -> {
                    Log.d(TAG, "Error ${result.message}")

                }
                is Result.Success -> {
                    Log.d(TAG, "Data ${result.data}")
                    val data = result.data?.map {
                        it.toNewsModel()
                    }
                    if (data != null) {
                        newsAdapter.submitData(data)
                    }
                }
            }

        }
    }




}