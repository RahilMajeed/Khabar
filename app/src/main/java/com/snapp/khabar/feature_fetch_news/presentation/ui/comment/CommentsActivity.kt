package com.snapp.khabar.feature_fetch_news.presentation.ui.comment

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.snapp.khabar.R
import com.snapp.khabar.databinding.ActivityCommentsLayoutBinding
import com.snapp.khabar.feature_fetch_news.domain.checkers.InternetAwareActivity
import com.snapp.khabar.feature_fetch_news.core.InternetAwareActivityImpl
import com.snapp.khabar.feature_fetch_news.domain.model.getDummyComments
import com.snapp.khabar.feature_fetch_news.presentation.ui.base.InternetAwareViewModel
import com.snapp.khabar.feature_fetch_news.presentation.ui.comment.adapters.CommentsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CommentsActivity : AppCompatActivity(), InternetAwareActivity by InternetAwareActivityImpl() {

    /**
     * Data Binding
     * */
    private var _binding: ActivityCommentsLayoutBinding? = null
    private val binding get() = _binding!!

    /**
     * For Observing Internet Connectivity
     * */
    private val internetAwareViewModel: InternetAwareViewModel by viewModels()

    private lateinit var commentsAdapter: CommentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this@CommentsActivity,R.layout.activity_comments_layout)
        commentsAdapter = CommentsAdapter()

        setUpCommentsRecyclerView()

        consumeFlows()
    }

    private fun consumeFlows(){
        lifecycleScope.launchWhenCreated {
            // Handling Internet connectivity here
            handleInternetAvailability(
                binding.tvConnectionStatus,
                internetAwareViewModel,
                this
            )
        }
    }

    private fun setUpCommentsRecyclerView() {
        findViewById<RecyclerView>(R.id.commentsRv).apply {
            layoutManager = LinearLayoutManager(this@CommentsActivity)
            adapter = commentsAdapter
        }

        commentsAdapter.submitData(getDummyComments())
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}