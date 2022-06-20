package com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.home_fragment.fragments.science

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.snapp.khabar.R
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.BaseFragment

class ScienceFragment: BaseFragment(1) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_science_layout,container,false)
        setUpNewsRecyclerView(view)
     //   newsAdapter.submitData(getDummyNewsList())

        return view
    }
    private fun setUpNewsRecyclerView(view: View){
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvNews)
        recyclerView.adapter = newsAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }
}