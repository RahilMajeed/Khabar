package com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.snapp.khabar.R
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.HomeViewModel
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookmarkFragment: BaseFragment(3) {

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bookmark,container,false)

        val btnBack = view.findViewById<ImageButton>(R.id.btnBack)
        btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        setupNewsRecyclerView(view)

        setupObservers()

        return view
    }

    private fun setupObservers() {
        homeViewModel.savedNews.observe(viewLifecycleOwner) { newsList ->
            newsAdapter.submitData(newsList)
        }
    }

    private fun setupNewsRecyclerView(view: View){
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvNews)
        recyclerView.adapter = newsAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

    }
}