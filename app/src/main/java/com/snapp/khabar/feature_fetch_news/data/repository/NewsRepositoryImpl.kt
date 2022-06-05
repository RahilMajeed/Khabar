package com.snapp.khabar.feature_fetch_news.data.repository

import com.snapp.khabar.feature_fetch_news.data.remote.NewsApi
import com.snapp.khabar.feature_fetch_news.data.remote.dto.NewsDto
import com.snapp.khabar.feature_fetch_news.domain.repository.NewsRepository
import retrofit2.Response
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val api: NewsApi
): NewsRepository {

    /**
     * Fetching latest news from the api */
    override suspend fun fetchLatestNews(country: String, apiKey: String): Response<NewsDto> {
        return api.fetchTopHeadlines(country, apiKey)
    }
}