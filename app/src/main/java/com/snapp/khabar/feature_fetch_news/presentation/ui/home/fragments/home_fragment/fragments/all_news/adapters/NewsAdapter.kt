package com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.home_fragment.fragments.all_news.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.snapp.khabar.R
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.bookmark.BookmarkFragmentDirections
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.home_fragment.HomeFragmentDirections
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.search.SearchFragmentDirections
import com.snapp.khabar.feature_fetch_news.presentation.util.HelperFunctions.getFormattedTimeStamp

class NewsAdapter(
    val adapterParent: Int,
    val onBookmarkClick: (newsModel: NewsModel) -> Unit
) : RecyclerView.Adapter<NewsAdapter.NewsModelViewHolder>(){
    private var newsList = emptyList<NewsModel>()

    inner class NewsModelViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val heading: TextView = itemView.findViewById(R.id.tvNewsTitle)
        private val desc: TextView = itemView.findViewById(R.id.tvNewsDesc)
        private val time: TextView  = itemView.findViewById(R.id.tvTimeStamp)
        private val image: ImageView  = itemView.findViewById(R.id.ivNewsImage)
        private val bookmarkBtn: ImageButton = itemView.findViewById(R.id.btnBookMark)

        fun bind(news : NewsModel){
            heading.text = news.heading
            desc.text = news.description
            time.text = news.time
//            time.text = getFormattedTimeStamp(news.time.toString())
            Glide.with(itemView.context)
                .load(news.imageUrl)
                .placeholder(R.drawable.dp)
                .error(R.drawable.dp)
                .into(image)

            itemView.setOnClickListener {

                navigateToDetailsScreen(news)

            }


            bookmarkBtn.setOnClickListener {
                onBookmarkClick.invoke(news)
            }

        }

        private fun navigateToDetailsScreen(news: NewsModel) {

            val extras = FragmentNavigatorExtras(
                image to "imageTransition"
            )

            // Step 2
            val action = when (adapterParent) {
                1 -> {
                    HomeFragmentDirections.actionHomeToNewsDetailActivity(news)

                }
                2 -> {
                    SearchFragmentDirections.actionSearchToNewsDetailActivity(news)

                }
                else -> {
                    BookmarkFragmentDirections.actionBookmarksToNewsDetailActivity(news)

                }
            }
            itemView.findNavController().navigate(action,extras)
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

    fun submitData(newList: List<NewsModel>){
       newsList = newList
       notifyDataSetChanged()

    }
}