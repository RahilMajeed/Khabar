package com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.home_fragment.fragments.all_news.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.snapp.khabar.R
import com.snapp.khabar.feature_fetch_news.presentation.util.HelperFunctions

class HeadlineAdapter(): RecyclerView.Adapter<HeadlineAdapter.HeadlineViewHolder>() {

    private var headlinesList = emptyList<NewsModel>()

    class HeadlineViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        // Binding Widgets
        private val tvHeadline: TextView = itemView.findViewById(R.id.tvNewsTitle)
        private val tvTime: TextView = itemView.findViewById(R.id.tvTimeStamp)
        private val ivNewsImage: ImageView = itemView.findViewById(R.id.ivNewsImage)

        fun bind(newsModel: NewsModel){

            tvHeadline.text = newsModel.heading
            tvTime.text = HelperFunctions.getFormattedTimeStamp(newsModel.time.toString())

            Glide.with(itemView.context)
                .load(newsModel.imageUrl)
                .into(ivNewsImage)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadlineViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_headline_layout,parent,false)

        getDummyHeadLineList()

        return HeadlineViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeadlineViewHolder, position: Int) {
        val headLineItem = headlinesList[position]
        holder.bind(headLineItem)
    }

    override fun getItemCount(): Int {
        return headlinesList.size
    }

    fun submitData(dummyHeadLineList: List<NewsModel>) {
        headlinesList = dummyHeadLineList
        notifyDataSetChanged()

    }

}