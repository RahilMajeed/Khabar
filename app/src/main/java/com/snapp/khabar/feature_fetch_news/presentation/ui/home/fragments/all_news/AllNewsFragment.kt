package com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.all_news

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.snapp.khabar.R
import com.snapp.khabar.feature_fetch_news.domain.util.Result
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.HomeViewModel
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.all_news.adapters.HeadlineAdapter
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.all_news.adapters.NewsModel
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.all_news.adapters.NewsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllNewsFragment: Fragment() {

    // ViewModels
    private val homeViewModel: HomeViewModel by activityViewModels()

    // Adapters
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var headlineAdapter: HeadlineAdapter

    // Widgets
    private lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_all_news,container,false)
        
        // Instantiate Widgets
        progressBar = view.findViewById(R.id.progressBar)

        // Instantiate Adapter
        newsAdapter = NewsAdapter()
        headlineAdapter = HeadlineAdapter()


        setupHeadlinesRecyclerView(view)

        setupNewsRecyclerView(view)

        return view

    }

    override fun onResume() {
        super.onResume()
        setupObservers()
    }

    private fun setupObservers(){

        // Observing all news here
        homeViewModel.allNewsLiveData.observe(viewLifecycleOwner){ result ->
            when(result){
                is Result.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }
                is Result.Error -> {
                    Log.d(TAG, "setupObservers: ${result.message}")
                    progressBar.visibility = View.GONE
                    Toast.makeText(context,result.message,Toast.LENGTH_LONG).show()
                }
                is Result.Success -> {
                    progressBar.visibility = View.GONE
                    newsAdapter.submitList(result.data!!)
                }
            }
        }

        // Observing Headlines Here
        homeViewModel.headlines.observe(viewLifecycleOwner){ result ->
            when(result){
                is Result.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }
                is Result.Error -> {
                    Log.d(TAG, "setupObservers: ${result.message}")
                    progressBar.visibility = View.GONE
                    Toast.makeText(context,result.message,Toast.LENGTH_LONG).show()
                }
                is Result.Success -> {
                    progressBar.visibility = View.GONE
                    headlineAdapter.submitList(result.data!!)
                }
            }
        }
    }

    private fun setupHeadlinesRecyclerView(
        view: View

    ) {
        val headlineRv = view.findViewById<RecyclerView>(R.id.rvHeadLines)
        val headlineAdapter = HeadlineAdapter()
        headlineRv.adapter = headlineAdapter
        headlineRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setupNewsRecyclerView(
        view: View
    ) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvNews)
        recyclerView.adapter = newsAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

}

private const val TAG = "AllNewsFragment"
