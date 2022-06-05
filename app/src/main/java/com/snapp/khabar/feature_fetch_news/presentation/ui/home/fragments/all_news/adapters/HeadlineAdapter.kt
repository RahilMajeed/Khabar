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

class HeadlineAdapter: RecyclerView.Adapter<HeadlineAdapter.HeadlineViewHolder>() {

    private var headlinesList = emptyList<ArticleModel>()

    class HeadlineViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        // Binding Widgets
        private val tvHeadline: TextView = itemView.findViewById(R.id.tvNewsTitle)
        private val tvTime: TextView = itemView.findViewById(R.id.tvTimeStamp)
        private val ivNewsImage: ImageView = itemView.findViewById(R.id.ivNewsImage)

        fun bind(article: ArticleModel){

            tvHeadline.text = article.heading
            tvTime.text = article.time

            Glide.with(itemView.context)
                .load(article.image)
                .placeholder(R.drawable.error)
                .into(ivNewsImage)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadlineViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_headline_layout,parent,false)
        return HeadlineViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeadlineViewHolder, position: Int) {
        val headLineItem = headlinesList[position]
        holder.bind(headLineItem)
    }

    override fun getItemCount(): Int {
        return headlinesList.size
    }

    fun submitList(headlines: List<ArticleModel>){
        headlinesList = headlines
        notifyItemRangeChanged(0,headlines.size-1)
    }
}