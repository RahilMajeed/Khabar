package com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.home_fragment.fragments.politics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.snapp.khabar.R
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.BaseFragment
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.home_fragment.fragments.all_news.adapters.NewsAdapter
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.home_fragment.fragments.all_news.adapters.NewsModel
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.home_fragment.fragments.all_news.adapters.getDummyNewsList

class PoliticsFragment: BaseFragment(1) {

    /**
     * Making News Adapter a Global variable so that data can be submitted to it
     * from any function
     * */

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view = inflater.inflate(R.layout.politics_fragment_layout,container,false)
        setupNewsRecyclerView(view)

        /**
         * Submitting data to the news adapter
         * We will get hold of dummy data from data class NewsModel
         * */
       // newsAdapter.submitData(getDummyNewsList())
        getDataFromCloud()


        return view
    }

    private fun getDataFromCloud(){
        val data = getDummyNewsList()
        newsAdapter.submitData(data)
    }

    private fun setupNewsRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvNews)
        recyclerView.adapter = newsAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

    }
}