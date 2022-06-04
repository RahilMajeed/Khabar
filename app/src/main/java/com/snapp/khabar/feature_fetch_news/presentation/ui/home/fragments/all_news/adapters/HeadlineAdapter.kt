package com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.all_news.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.snapp.khabar.R

class HeadlineAdapter(
    private val headlinesList: List<NewsModel>
): RecyclerView.Adapter<HeadlineAdapter.HeadlineViewHolder>() {

    class HeadlineViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        // Binding Widgets
        private val tvHeadline: TextView = itemView.findViewById(R.id.tvNewsTitle)
        private val tvTime: TextView = itemView.findViewById(R.id.tvTimeStamp)
        private val ivNewsImage: ImageView = itemView.findViewById(R.id.ivNewsImage)

        fun bind(newsModel: NewsModel){

            tvHeadline.text = newsModel.heading
            tvTime.text = newsModel.time

            Glide.with(itemView.context)
                .load(newsModel.imageUrl)
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
}