package com.snapp.khabar.feature_fetch_news.di

import com.snapp.khabar.feature_fetch_news.core.Constants.BASE_URL
import com.snapp.khabar.feature_fetch_news.data.remote.NewsApi
import com.snapp.khabar.feature_fetch_news.data.repository.NewsRepositoryImpl
import com.snapp.khabar.feature_fetch_news.domain.repository.NewsRepository
import com.snapp.khabar.feature_fetch_news.domain.use_cases.FetchAllNewsUseCase
import com.snapp.khabar.feature_fetch_news.domain.use_cases.FetchHeadlinesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    // Provide Retrofit Instance
    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    // Provide Api Instance
    @Provides
    @Singleton
    fun provideNewsApiInstance(retrofit: Retrofit): NewsApi {
        return retrofit.create(NewsApi::class.java)
    }

    // Provide News Repository
    @Provides
    @Singleton
    fun provideNewsRepository(api: NewsApi) : NewsRepository {
        return NewsRepositoryImpl(api)
    }

    // Injecting Use cases
    // Provide Fetch News Use Case
    @Provides
    @Singleton
    fun provideFetchUseCase(repository: NewsRepository): FetchAllNewsUseCase {
        return FetchAllNewsUseCase(repository)
    }

    // Provide Fetch Headlines Use Case
    @Provides
    @Singleton
    fun provideHeadlinesUseCase(repository: NewsRepository): FetchHeadlinesUseCase {
        return FetchHeadlinesUseCase(repository)
    }

}