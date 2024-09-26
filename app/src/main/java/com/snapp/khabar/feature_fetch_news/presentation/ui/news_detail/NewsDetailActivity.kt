package com.snapp.khabar.feature_fetch_news.presentation.ui.news_detail


import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.navArgs
import androidx.transition.TransitionInflater
import com.bumptech.glide.Glide
import com.snapp.khabar.R
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.home_fragment.fragments.all_news.adapters.NewsModel


class NewsDetailActivity : AppCompatActivity() {

    // Declaring widgets
    private lateinit var newsHeadLineTv: TextView
    private lateinit var newsDescTv: TextView
    private lateinit var timeTv: TextView
    private lateinit var backBtn: ImageButton
    private lateinit var newsIv: ImageView

    // Args
    private val newsArgs: NewsDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        val sharedElementEnterTransition = TransitionInflater.from(this).inflateTransition(android.R.transition.move)


    // getWindow().setStatusBarColor(getResources().getColor(R.color.background_status_bar_filter));
        setContentView(R.layout.activity_news_detail)



        // Receiving data from previous activity
     //   val newsItem = intent.getParcelableExtra<NewsModel>("item")

        // Defining widgets
        newsHeadLineTv = findViewById(R.id.tvNewsTitle)
        newsDescTv = findViewById(R.id.tvNewsDesc)
        timeTv = findViewById(R.id.tvTimeStamp)
        backBtn = findViewById(R.id.backKey)
        newsIv = findViewById(R.id.ivNewsImage)

        val newsItem = newsArgs.newsItem

        // Setting onClick Listeners
        setupOnClickListeners()


        // Setting data on widgets
        setDataOnUi(newsItem)


    }



    private fun setupOnClickListeners() {
        // Adding back button funtionality
        backBtn.setOnClickListener {
            finish()
        }
    }


    private fun setDataOnUi(item: NewsModel?){
        if (item == null){
            return
        }
        newsHeadLineTv.text = item.heading
        newsDescTv.text = item.description
        timeTv.text = item.time

        // Setting image through glide
        Glide.with(this)
            .load(item.imageUrl)
            .into(newsIv)
    }


}