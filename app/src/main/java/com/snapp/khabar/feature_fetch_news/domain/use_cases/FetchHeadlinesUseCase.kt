package com.snapp.khabar.feature_fetch_news.domain.use_cases

import android.util.Log
import com.snapp.khabar.feature_fetch_news.domain.mappers.toArticleModel
import com.snapp.khabar.feature_fetch_news.domain.model.ArticleModel
import com.snapp.khabar.feature_fetch_news.domain.repository.NewsRepository
import com.snapp.khabar.feature_fetch_news.domain.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchHeadlinesUseCase @Inject constructor(
    private val repository: NewsRepository
) {

    operator fun invoke(options: Map<String,String>): Flow<Result<List<ArticleModel>>> {
        return flow {
            emit(Result.Loading())
            try {
                val responseFromApi = repository.fetchLatestNews(options)
                if (responseFromApi.isSuccessful && responseFromApi.body() != null){
                    emit(Result.Success(responseFromApi.body()!!.articleDtos.map { it.toArticleModel() }))
                } else {
                    emit(Result.Error(responseFromApi.message()))
                }
            } catch (e: Exception){
                Log.d(TAG, "invoke: ${e.message.toString()}")
                emit(Result.Error(e.message.toString()))
            }
        }
    }
}

private const val TAG = "FetchHeadlinesUseCase"