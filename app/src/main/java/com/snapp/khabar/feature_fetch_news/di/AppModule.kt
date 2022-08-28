package com.snapp.khabar.feature_fetch_news.di

import android.app.Application
import com.snapp.khabar.feature_fetch_news.domain.checkers.ConnectivityObserver
import com.snapp.khabar.feature_fetch_news.core.InternetConnectionCheckerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesInternetConnectivityObserver(app: Application): ConnectivityObserver {
        return InternetConnectionCheckerImpl(app.applicationContext)
    }

}