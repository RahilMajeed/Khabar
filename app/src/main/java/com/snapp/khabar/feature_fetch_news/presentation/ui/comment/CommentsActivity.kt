package com.snapp.khabar.feature_fetch_news.presentation.ui.comment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.snapp.khabar.R
import com.snapp.khabar.feature_fetch_news.domain.model.getDummyComments
import com.snapp.khabar.feature_fetch_news.presentation.ui.comment.adapters.CommentsAdapter

class CommentsActivity : AppCompatActivity() {

    private lateinit var commentsAdapter: CommentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments_layout)
        commentsAdapter = CommentsAdapter()

        setUpCommentsRecyclerView()
    }

    private fun setUpCommentsRecyclerView() {
        val commentsRecyclerView = findViewById<RecyclerView>(R.id.commentsRv).apply {
            layoutManager = LinearLayoutManager(this@CommentsActivity)
            adapter = commentsAdapter
        }

        commentsAdapter.submitData(getDummyComments())
    }

}