package com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.home_fragment.fragments.politics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.snapp.khabar.R
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.BaseFragment

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
        return view
    }



    private fun setupNewsRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvNews)
        recyclerView.adapter = newsAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

    }
    override fun onResume() {
        super.onResume()
        observeNews(homeViewModel.politicsNewsLiveData)
    }
}