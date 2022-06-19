package com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.home_fragment.fragments.all_news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.snapp.khabar.R
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.BaseFragment
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.home_fragment.fragments.all_news.adapters.*

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

       headlineAdapter.submitData(getDummyHeadLineList())

        return view

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
        newsAdapter.submitData(getDummyNewsList())


    }


}
