package com.snapp.khabar.feature_fetch_news.core

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.os.Build
import androidx.annotation.RequiresApi
import com.snapp.khabar.feature_fetch_news.domain.checkers.ConnectionStatus
import com.snapp.khabar.feature_fetch_news.domain.checkers.ConnectivityObserver
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class InternetConnectionCheckerImpl(
    private val context: Context
): ConnectivityObserver {

    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    @RequiresApi(Build.VERSION_CODES.N)
    override fun observeNetwork(): Flow<ConnectionStatus> {
        return callbackFlow {
            val callback = object : ConnectivityManager.NetworkCallback(){
                override fun onLost(network: Network) {
                    super.onLost(network)
                    launch {
                        delay(500)
                        send(ConnectionStatus.Unavailable)
                    }
                }

                override fun onUnavailable() {
                    super.onUnavailable()
                    launch {
                        delay(500)
                        send(ConnectionStatus.Unavailable)
                    }
                }

                override fun onAvailable(network: Network) {
                    super.onAvailable(network)
                    launch {
                        delay(500)
                        send(ConnectionStatus.Connected)
                    }
                }
            }

            connectivityManager.registerDefaultNetworkCallback(callback)

            awaitClose {
                connectivityManager.unregisterNetworkCallback(callback)
            }
        }.distinctUntilChanged()
    }
}