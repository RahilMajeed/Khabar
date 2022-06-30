package com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.home_fragment.fragments.all_news

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.snapp.khabar.R
import com.snapp.khabar.feature_fetch_news.domain.mappers.toNewsModel
import com.snapp.khabar.feature_fetch_news.domain.util.Result
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.HomeViewModel
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.BaseFragment
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.home_fragment.fragments.all_news.adapters.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllNewsFragment: BaseFragment(1) {

    lateinit var headlineAdapter : HeadlineAdapter



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_all_news,container,false)


        setupHeadlinesRecyclerView(view)

        setupNewsRecyclerView(view)


        return view

    }

    override fun onResume() {
        super.onResume()
        observeNews(homeViewModel.allNewsLiveData)
        observeHeadlines()
    }




    private fun observeHeadlines() {
        homeViewModel.headlines.observe(viewLifecycleOwner) { result ->
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
                        headlineAdapter.submitData(data)
                    }
                }
            }

        }
    }


    private fun setupHeadlinesRecyclerView(view: View) {
        val headlineRv = view.findViewById<RecyclerView>(R.id.rvHeadLines)
        headlineAdapter = HeadlineAdapter()
        headlineRv.adapter = headlineAdapter
        headlineRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

    }

    private fun setupNewsRecyclerView(
        view: View,

    ) {

        val recyclerView = view.findViewById<RecyclerView>(R.id.rvNews)
        recyclerView.isNestedScrollingEnabled=false
        recyclerView.adapter = newsAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    //    newsAdapter.submitData(getDummyNewsList())


    }
    

}

private const val TAG = "AllNewsFragment"
