package com.snapp.khabar.feature_fetch_news.core

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {

    fun observeNetwork(): Flow<ConnectionStatus>
}

enum class ConnectionStatus {
   Connected,
   Unavailable
}
