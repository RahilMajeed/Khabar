package com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.home_fragment.fragments.tech

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.snapp.khabar.R
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.BaseFragment
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.home_fragment.fragments.all_news.adapters.getDummyNewsList

class TechFragment: BaseFragment(1) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tech_layout,container,false)
        setupNewsRecyclerView(view)

        setDataFromCloudIntoRecyclerView()

        return view
    }

    private fun setDataFromCloudIntoRecyclerView() {
        val data = getDummyNewsList()
        newsAdapter.submitData(data)
    }

    private fun setupNewsRecyclerView(view: View?) {
        val newsRecyclerView = view?.findViewById<RecyclerView>(R.id.rvNews)
        newsRecyclerView?.adapter = newsAdapter
        newsRecyclerView?.layoutManager = LinearLayoutManager(context)
    }
}