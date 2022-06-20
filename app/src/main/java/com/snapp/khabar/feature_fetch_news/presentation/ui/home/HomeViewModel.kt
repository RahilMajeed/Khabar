package com.snapp.khabar.feature_fetch_news.presentation.ui.home

import androidx.lifecycle.*
import com.snapp.khabar.feature_fetch_news.core.Constants.API_KEY
import com.snapp.khabar.feature_fetch_news.domain.model.ArticleModel
import com.snapp.khabar.feature_fetch_news.domain.use_cases.FetchAllNewsUseCase
import com.snapp.khabar.feature_fetch_news.domain.use_cases.FetchHeadlinesUseCase
import com.snapp.khabar.feature_fetch_news.domain.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchAllNewsUseCase: FetchAllNewsUseCase,
    private val fetchHeadlinesUseCase: FetchHeadlinesUseCase
): ViewModel() {

    // Headlines
    private var _headlines : MutableLiveData<Result<List<ArticleModel>>> = MutableLiveData()

    val headlines get() = _headlines as LiveData<Result<List<ArticleModel>>>
    // All News Observables
    private var allNewsList: MutableLiveData<Result<List<ArticleModel>>> = MutableLiveData()

    val allNewsLiveData get() = allNewsList as LiveData<Result<List<ArticleModel>>>

    init {
        fetchHeadlines()
        fetchAllNews()
    }


    private fun fetchHeadlines() {
        viewModelScope.launch {
            val options = hashMapOf<String,String>()
            options["country"] = "in"
            options["apiKey"] = API_KEY
            _headlines = fetchHeadlinesUseCase.invoke(options).asLiveData() as MutableLiveData<Result<List<ArticleModel>>>
        }
    }

    private fun fetchAllNews(){
        viewModelScope.launch {
            val options = hashMapOf<String,String>()
            options["domains"] = "bbc.co.uk,techcrunch.com"
            options["apiKey"] = API_KEY
            allNewsList = fetchAllNewsUseCase.invoke(options).asLiveData() as MutableLiveData<Result<List<ArticleModel>>>
        }
    }
}