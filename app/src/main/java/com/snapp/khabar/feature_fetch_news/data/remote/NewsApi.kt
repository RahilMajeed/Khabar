package com.snapp.khabar.feature_fetch_news.data.remote

import com.snapp.khabar.feature_fetch_news.core.Constants.API_KEY
import com.snapp.khabar.feature_fetch_news.data.remote.dto.NewsDto
import com.snapp.khabar.feature_fetch_news.data.util.Constants.TOP_HEADLINES_END_POINT
import retrofit2.Response
import retrofit2.http.GET

interface NewsApi {

    @GET("$TOP_HEADLINES_END_POINT?country=in&apiKey=$API_KEY")
    suspend fun fetchTopHeadlines(
         country: String,
        apiKey: String,
    ): Response<NewsDto>

}