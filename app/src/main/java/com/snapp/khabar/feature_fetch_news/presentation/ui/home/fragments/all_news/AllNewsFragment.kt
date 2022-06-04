package com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.all_news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.snapp.khabar.R
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.all_news.adapters.HeadlineAdapter
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.all_news.adapters.NewsModel
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.all_news.adapters.RecyclerViewAdapter

class AllNewsFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_all_news,container,false)


        val newsList = listOf(
            NewsModel(
                "School Holidays",
                "12 hours ago",
                "https://th.bing.com/th/id/R.636537dc613b2dd438993cf656177647?rik=otkgp5UuQIJFBQ&riu=http%3a%2f%2fcdn.thinglink.me%2fapi%2fimage%2f347151190540156928%2f1024%2f10%2fscaletowidth%2f0%2f0%2f1%2f1%2ffalse%2ftrue%3fwait%3dtrue&ehk=dbBWB%2bILC7Qwl%2bxh4T39Q6qi8T1gl8%2b2zV1SCkY8f%2fk%3d&risl=&pid=ImgRaw&r=0"
            ),

            NewsModel(
                "Breaking News",
                "1 hour ago",
                "https://th.bing.com/th/id/R.636537dc613b2dd438993cf656177647?rik=otkgp5UuQIJFBQ&riu=http%3a%2f%2fcdn.thinglink.me%2fapi%2fimage%2f347151190540156928%2f1024%2f10%2fscaletowidth%2f0%2f0%2f1%2f1%2ffalse%2ftrue%3fwait%3dtrue&ehk=dbBWB%2bILC7Qwl%2bxh4T39Q6qi8T1gl8%2b2zV1SCkY8f%2fk%3d&risl=&pid=ImgRaw&r=0"
            ),
            NewsModel(
                "Bank Robbery",
                "10 hours ago",
                "https://www.bing.com/th?id=OIP.an2f2KjkPngipwIS15Z19gHaHj&w=106&h=108&c=8&rs=1&qlt=90&o=6&dpr=1.25&pid=3.1&rm=2"
            ), NewsModel(
                "New Upcoming Super Cars",
                "6 hours ago",
                "https://www.bing.com/th?id=OIP.G8EvxQnKZ_LMVJ6OVIOxdQHaEo&w=316&h=197&c=8&rs=1&qlt=90&o=6&dpr=1.25&pid=3.1&rm=2"
            ),
            NewsModel(
                "School Holidays",
                "12 hours ago",
                "https://th.bing.com/th/id/R.636537dc613b2dd438993cf656177647?rik=otkgp5UuQIJFBQ&riu=http%3a%2f%2fcdn.thinglink.me%2fapi%2fimage%2f347151190540156928%2f1024%2f10%2fscaletowidth%2f0%2f0%2f1%2f1%2ffalse%2ftrue%3fwait%3dtrue&ehk=dbBWB%2bILC7Qwl%2bxh4T39Q6qi8T1gl8%2b2zV1SCkY8f%2fk%3d&risl=&pid=ImgRaw&r=0"
            ),
            NewsModel(
                "School Holidays",
                "12 hours ago",
                "https://th.bing.com/th/id/R.636537dc613b2dd438993cf656177647?rik=otkgp5UuQIJFBQ&riu=http%3a%2f%2fcdn.thinglink.me%2fapi%2fimage%2f347151190540156928%2f1024%2f10%2fscaletowidth%2f0%2f0%2f1%2f1%2ffalse%2ftrue%3fwait%3dtrue&ehk=dbBWB%2bILC7Qwl%2bxh4T39Q6qi8T1gl8%2b2zV1SCkY8f%2fk%3d&risl=&pid=ImgRaw&r=0"
            ),
            NewsModel(
                "School Holidays",
                "12 hours ago",
                "https://th.bing.com/th/id/R.636537dc613b2dd438993cf656177647?rik=otkgp5UuQIJFBQ&riu=http%3a%2f%2fcdn.thinglink.me%2fapi%2fimage%2f347151190540156928%2f1024%2f10%2fscaletowidth%2f0%2f0%2f1%2f1%2ffalse%2ftrue%3fwait%3dtrue&ehk=dbBWB%2bILC7Qwl%2bxh4T39Q6qi8T1gl8%2b2zV1SCkY8f%2fk%3d&risl=&pid=ImgRaw&r=0"
            ),
            NewsModel(
                "School Holidays",
                "12 hours ago",
                "https://th.bing.com/th/id/R.636537dc613b2dd438993cf656177647?rik=otkgp5UuQIJFBQ&riu=http%3a%2f%2fcdn.thinglink.me%2fapi%2fimage%2f347151190540156928%2f1024%2f10%2fscaletowidth%2f0%2f0%2f1%2f1%2ffalse%2ftrue%3fwait%3dtrue&ehk=dbBWB%2bILC7Qwl%2bxh4T39Q6qi8T1gl8%2b2zV1SCkY8f%2fk%3d&risl=&pid=ImgRaw&r=0"
            ),
        )
        val headLineList = listOf(
            NewsModel(
                "Summers are going to be awesome in Sahara desert",
                "12 hours ago",
                "https://images.pexels.com/photos/3244513/pexels-photo-3244513.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
            ),

            NewsModel(
                "Book you trekking tour starting from Kashmir to Meghalaya.",
                "1 hour ago",
                "https://images.pexels.com/photos/1761279/pexels-photo-1761279.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
            ),
            NewsModel(
                "Huge power cuts prevailing throughout the country.",
                "10 hours ago",
                "https://images.pexels.com/photos/1402850/pexels-photo-1402850.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
            )
        )

        setupHeadlinesRecyclerView(view, headLineList)

        setupNewsRecyclerView(view, newsList)

        return view

    }

    private fun setupHeadlinesRecyclerView(
        view: View,
        newsList: List<NewsModel>
    ) {
        val headlineRv = view.findViewById<RecyclerView>(R.id.rvHeadLines)
        val headlineAdapter = HeadlineAdapter(newsList)
        headlineRv.adapter = headlineAdapter
        headlineRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setupNewsRecyclerView(
        view: View,
        newsList: List<NewsModel>
    ) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvNews)
        val newsAdapter = RecyclerViewAdapter(newsList)
        recyclerView.adapter = newsAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

}
