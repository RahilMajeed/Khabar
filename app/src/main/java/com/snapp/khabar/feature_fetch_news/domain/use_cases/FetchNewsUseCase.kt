package com.snapp.khabar.feature_fetch_news.domain.use_cases

import com.snapp.khabar.feature_fetch_news.core.Constants.API_KEY
import com.snapp.khabar.feature_fetch_news.data.remote.dto.NewsDto
import com.snapp.khabar.feature_fetch_news.domain.mappers.toArticleModel
import com.snapp.khabar.feature_fetch_news.domain.model.ArticleModel
import com.snapp.khabar.feature_fetch_news.domain.repository.NewsRepository
import com.snapp.khabar.feature_fetch_news.domain.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {

    suspend operator fun invoke(): Flow<Result<List<ArticleModel>>>{
        return flow {
            emit(Result.Loading())
            try {
                val responseFromApi = repository.fetchLatestNews("in",API_KEY)
                if (responseFromApi.isSuccessful && responseFromApi.body() != null){
                    emit(Result.Success(responseFromApi.body()!!.articleDtos.map { it.toArticleModel() }))
                } else {
                    emit(Result.Error(responseFromApi.message()))
                }
            } catch (e: Exception){
                emit(Result.Error(e.message.toString()))
            }
        }
    }
}