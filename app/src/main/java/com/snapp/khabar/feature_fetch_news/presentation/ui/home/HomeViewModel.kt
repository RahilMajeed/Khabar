package com.snapp.khabar.feature_fetch_news.presentation.ui.home

import androidx.lifecycle.*
import com.snapp.khabar.feature_fetch_news.core.Constants.API_KEY
import com.snapp.khabar.feature_fetch_news.data.local.entities.NewsEntity
import com.snapp.khabar.feature_fetch_news.domain.model.ArticleModel
import com.snapp.khabar.feature_fetch_news.domain.use_cases.*
import com.snapp.khabar.feature_fetch_news.domain.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllNewsUseCase: GetAllNewsFromLocalDatabaseUseCase,
    private val insertNewsEntityUseCase: InsertNewsEntityUseCase,
    private val deleteNewsEntityUseCase: DeleteNewsEntityUseCase,
    private val fetchAllNewsUseCase: FetchAllNewsUseCase,
    private val fetchHeadlinesUseCase: FetchHeadlinesUseCase
): ViewModel() {

    // Headlines
    private var _headlines : MutableLiveData<Result<List<ArticleModel>>> = MutableLiveData()

    val headlines get() = _headlines as LiveData<Result<List<ArticleModel>>>
    // All News Observables
    private var allNewsList: MutableLiveData<Result<List<ArticleModel>>> = MutableLiveData()

    val allNewsLiveData get() = allNewsList as LiveData<Result<List<ArticleModel>>>

    /**
     * Saved Articles Observable
     * */
    val savedNews = getAllNewsUseCase.invoke().asLiveData()


    init {
        fetchHeadlines()
        fetchAllNews()
    }

    /**
     * Inserting news entity in database
     * */
    fun insertNewsEntity(newsEntity: NewsEntity){
        viewModelScope.launch {
            insertNewsEntityUseCase.invoke(newsEntity)
        }
    }

    /**
     * Deleting news entity in database
     * */
    fun deleteNewsEntity(newsEntity: NewsEntity){
        viewModelScope.launch {
            deleteNewsEntityUseCase.invoke(newsEntity)
        }
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