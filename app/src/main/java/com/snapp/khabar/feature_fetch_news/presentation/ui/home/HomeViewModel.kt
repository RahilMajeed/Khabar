package com.snapp.khabar.feature_fetch_news.presentation.ui.home

import androidx.lifecycle.*
import com.snapp.khabar.feature_fetch_news.core.Constants.API_KEY
import com.snapp.khabar.feature_fetch_news.domain.model.ArticleModel
import com.snapp.khabar.feature_fetch_news.domain.use_cases.FetchNewsUseCase
import com.snapp.khabar.feature_fetch_news.domain.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchNewsUseCase: FetchNewsUseCase
): ViewModel() {

    // All News Observables
    private var allNewsList: MutableLiveData<Result<List<ArticleModel>>> = MutableLiveData()
    val allNewsLiveData get() = allNewsList as LiveData<Result<List<ArticleModel>>>

    init {
        fetchAllNews()
    }

    private fun fetchAllNews(){
        viewModelScope.launch {
            val options = hashMapOf<String,String>()
            options["country"] = "in"
            options["apiKey"] = API_KEY
            allNewsList = fetchNewsUseCase.invoke(options).asLiveData() as MutableLiveData<Result<List<ArticleModel>>>
        }
    }
}