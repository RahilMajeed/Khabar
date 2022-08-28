package com.snapp.khabar.feature_fetch_news.presentation.ui.news_detail


import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.navArgs
import androidx.transition.TransitionInflater
import com.bumptech.glide.Glide
import com.snapp.khabar.R
import com.snapp.khabar.databinding.ActivityNewsDetailBinding
import com.snapp.khabar.feature_fetch_news.core.InternetAwareActivityImpl
import com.snapp.khabar.feature_fetch_news.domain.checkers.InternetAwareActivity
import com.snapp.khabar.feature_fetch_news.presentation.ui.base.InternetAwareViewModel
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.home_fragment.fragments.all_news.adapters.NewsModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailActivity : AppCompatActivity(), InternetAwareActivity by InternetAwareActivityImpl() {

    /**
     * DataBinding Variables
     * */
    private var _binding: ActivityNewsDetailBinding? = null
    private val binding get() = _binding!!

    /**
     * For Observing Internet connectivity status
     * */
    private val internetAwareViewModel: InternetAwareViewModel by viewModels()


    // Args
    private val newsArgs: NewsDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        val sharedElementEnterTransition = TransitionInflater.from(this).inflateTransition(android.R.transition.move)

        _binding = DataBindingUtil.setContentView(this@NewsDetailActivity,R.layout.activity_news_detail)


        val newsItem = newsArgs.newsItem

        // Setting onClick Listeners
        setupOnClickListeners()


        // Setting data on widgets
        setDataOnUi(newsItem)

        consumeFlows()


    }

    private fun consumeFlows(){
        lifecycleScope.launchWhenCreated {
            handleInternetAvailability(
                binding.tvConnectionStatus,
                internetAwareViewModel,
                this
            )
        }
    }



    private fun setupOnClickListeners() {
        // Adding back button funtionality
        binding.backKey.setOnClickListener {
            finish()
        }
    }


    private fun setDataOnUi(item: NewsModel?){
        binding.apply {
            if (item == null){
                return
            }
            tvNewsTitle.text = item.heading
            // newsDescTv.text = item.description
            tvTimeStamp.text = item.time

            // Load data in webview
            wvNewsDescrption.loadUrl(item.url)

            // Setting image through glide
            Glide.with(this@NewsDetailActivity)
                .load(item.imageUrl)
                .into(ivNewsImage)
        }

    }


}