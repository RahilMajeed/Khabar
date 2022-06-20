package com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.snapp.khabar.R
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.BaseFragment

class BookmarkFragment: BaseFragment(3) {

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
        return view
    }

    private fun setupNewsRecyclerView(view: View){
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvNews)
        recyclerView.adapter = newsAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

    }
}