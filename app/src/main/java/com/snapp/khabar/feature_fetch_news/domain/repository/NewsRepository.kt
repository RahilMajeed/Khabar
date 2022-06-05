package com.snapp.khabar.feature_fetch_news.domain.repository

import com.snapp.khabar.feature_fetch_news.data.remote.dto.NewsDto
import retrofit2.Response


interface NewsRepository {

    // Fetching Headlines
    suspend fun fetchLatestNews(options: Map<String,String>): Response<NewsDto>

    // Fetch News Related to everything
    suspend fun fetchEverythingNews(options: Map<String,String>): Response<NewsDto>

}