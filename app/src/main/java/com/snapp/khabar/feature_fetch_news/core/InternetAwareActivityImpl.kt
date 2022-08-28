package com.snapp.khabar.feature_fetch_news.core

import android.view.View
import com.snapp.khabar.feature_fetch_news.domain.checkers.InternetAwareActivity
import com.snapp.khabar.feature_fetch_news.presentation.ui.base.InternetAwareViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class InternetAwareActivityImpl: InternetAwareActivity {

    /**
     * Toggle visibility of
     * @param view ( No internet connection message) by listening to the updates sent in channel
     * @param viewModel in
     * @param scope
     * */
    override fun handleInternetAvailability(
        view: View,
        viewModel: InternetAwareViewModel,
        scope: CoroutineScope
    ) {
        scope.launch {
            viewModel.isConnectionAvailableChannel.collect { isConnectionAvailable ->
                if (!isConnectionAvailable) {
                    view.visibility = View.VISIBLE
                } else {
                    view.visibility = View.GONE
                }
            }
        }
    }


}