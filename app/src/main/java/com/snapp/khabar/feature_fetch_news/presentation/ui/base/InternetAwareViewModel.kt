package com.snapp.khabar.feature_fetch_news.presentation.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.snapp.khabar.feature_fetch_news.domain.checkers.ConnectionStatus
import com.snapp.khabar.feature_fetch_news.domain.checkers.ConnectivityObserver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel will be used to monitor internet connection only
 * Connection observer dependency is injected into this view Model
 * */
@HiltViewModel
class InternetAwareViewModel @Inject constructor(
    private val connectionObserver: ConnectivityObserver
): ViewModel() {

    /**
     * This channel will be used to send connection status like if internet is 
     * available or not
     * in case connection is available true is sent else false is sent
     * */
    private val _isConnectionAvailableChannel: Channel<Boolean> = Channel()
    /**
     * Will be observed by the UI*/
    val isConnectionAvailableChannel = _isConnectionAvailableChannel.receiveAsFlow()

    /**
     * There should be no need of calling this observe network state function
     * */
    init {
        observerNetworkState()
    }

    /*Collecting values from the connectionObserver and sending the values
    * into isConnectionAvailableChannel*/
    private fun observerNetworkState(){
        viewModelScope.launch {
            connectionObserver.observeNetwork().collect { connectionStatus ->
                when(connectionStatus) {

                    ConnectionStatus.Connected -> {
                        _isConnectionAvailableChannel.send(true)
                    }

                    ConnectionStatus.Unavailable -> {
                        _isConnectionAvailableChannel.send(false)
                    }

                }
            }
        }
    }

}