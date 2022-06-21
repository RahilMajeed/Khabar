package com.snapp.khabar.feature_fetch_news.domain.use_cases

import com.snapp.khabar.feature_fetch_news.data.local.entities.NewsEntity
import com.snapp.khabar.feature_fetch_news.domain.mappers.toNewsModel
import com.snapp.khabar.feature_fetch_news.domain.repository.LocalRepository
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.home_fragment.fragments.all_news.adapters.NewsModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAllNewsFromLocalDatabaseUseCase @Inject constructor(
    private val localRepository: LocalRepository
) {

    operator fun invoke(): Flow<List<NewsModel>> {
        return localRepository.getNewsEntities().map {
            it.map { newsEntity -> newsEntity.toNewsModel()  }
        }
    }

}