package com.snapp.khabar.feature_fetch_news.domain.repository

import com.snapp.khabar.feature_fetch_news.data.remote.dto.NewsDto
import retrofit2.Response


interface NewsRepository {

    suspend fun fetchLatestNews(country: String, apiKey: String): Response<NewsDto>

}