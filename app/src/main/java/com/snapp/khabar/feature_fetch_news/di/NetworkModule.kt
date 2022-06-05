package com.snapp.khabar.feature_fetch_news.di

import android.app.Application
import com.snapp.khabar.feature_fetch_news.core.Constants.BASE_URL
import com.snapp.khabar.feature_fetch_news.data.remote.NewsApi
import com.snapp.khabar.feature_fetch_news.data.repository.NewsRepositoryImpl
import com.snapp.khabar.feature_fetch_news.domain.repository.NewsRepository
import com.snapp.khabar.feature_fetch_news.domain.use_cases.FetchNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    // Provide Retrofit Instance
    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
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
    fun provideFetchUseCase(repository: NewsRepository): FetchNewsUseCase {
        return FetchNewsUseCase(repository)
    }

}