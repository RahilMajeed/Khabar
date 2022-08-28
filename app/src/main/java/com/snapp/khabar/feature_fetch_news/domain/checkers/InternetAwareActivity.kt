package com.snapp.khabar.feature_fetch_news.domain.checkers

import android.view.View
import com.snapp.khabar.feature_fetch_news.presentation.ui.base.InternetAwareViewModel
import kotlinx.coroutines.CoroutineScope

interface InternetAwareActivity {

    fun handleInternetAvailability(
        view: View,
        viewModel: InternetAwareViewModel,
        scope: CoroutineScope
        )
}