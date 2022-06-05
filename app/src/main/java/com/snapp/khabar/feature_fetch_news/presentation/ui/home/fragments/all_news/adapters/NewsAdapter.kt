package com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.all_news.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.snapp.khabar.R
import com.snapp.khabar.feature_fetch_news.domain.model.ArticleModel

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.NewsModelViewHolder>(){

    private var newsList = emptyList<ArticleModel>()

    class NewsModelViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val heading: TextView = itemView.findViewById(R.id.tvNewsTitle)
        private val time: TextView  = itemView.findViewById(R.id.tvTimeStamp)
        private val desc: TextView  = itemView.findViewById(R.id.tvNewsDesc)
        private val image: ImageView  = itemView.findViewById(R.id.ivNewsImage)

        fun bind(article: ArticleModel){
            heading.text = article.heading
            time.text = article.time
            desc.text = article.desc
            Glide.with(itemView.context)
                .load(article.image)
                .into(image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsModelViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.news_item_layout, parent, false)
        return NewsModelViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsModelViewHolder, position: Int) {
        val currentNewsModel = newsList[position]
        holder.bind(currentNewsModel)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    fun submitList(articleList: List<ArticleModel>){
        newsList = articleList
    }
}