package com.snapp.khabar.feature_fetch_news.presentation.ui.home

import androidx.lifecycle.*
import com.snapp.khabar.feature_fetch_news.core.Constants.API_KEY
import com.snapp.khabar.feature_fetch_news.data.local.entities.NewsEntity
import com.snapp.khabar.feature_fetch_news.data.util.Constants.BUSINESS
import com.snapp.khabar.feature_fetch_news.data.util.Constants.POLITICS
import com.snapp.khabar.feature_fetch_news.data.util.Constants.SCIENCE
import com.snapp.khabar.feature_fetch_news.data.util.Constants.SPORTS
import com.snapp.khabar.feature_fetch_news.data.util.Constants.TECH
import com.snapp.khabar.feature_fetch_news.domain.model.ArticleModel
import com.snapp.khabar.feature_fetch_news.domain.use_cases.*
import com.snapp.khabar.feature_fetch_news.domain.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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

    // Business
    private var businessNews: MutableLiveData<Result<List<ArticleModel>>> = MutableLiveData()

    val businessNewsLiveData get() = businessNews as LiveData<Result<List<ArticleModel>>>

    // Politics

    private var politicsNews: MutableLiveData<Result<List<ArticleModel>>> = MutableLiveData()

    val politicsNewsLiveData get() = politicsNews as LiveData<Result<List<ArticleModel>>>

    // Tech
    private var techNews: MutableLiveData<Result<List<ArticleModel>>> = MutableLiveData()

    val techNewsLiveData get() = techNews as LiveData<Result<List<ArticleModel>>>

    // Science
    private var scienceNews: MutableLiveData<Result<List<ArticleModel>>> = MutableLiveData()

    val scienceNewsLiveData get() = scienceNews as LiveData<Result<List<ArticleModel>>>

    // Sports

    private var sportsNews: MutableLiveData<Result<List<ArticleModel>>> = MutableLiveData()

    val sportsNewsLiveData get() = sportsNews as LiveData<Result<List<ArticleModel>>>

    /**
     * Saved Articles Observable
     * */
    val savedNews = getAllNewsUseCase.invoke().asLiveData()


    init {
        fetchHeadlines()
        fetchAllNews()
        fetchNewsByCategory(BUSINESS)
        fetchNewsByCategory(TECH)
        fetchNewsByCategory(POLITICS)
        fetchNewsByCategory(SCIENCE)
        fetchNewsByCategory(SPORTS)
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



    private fun fetchNewsByCategory(category: String){
        viewModelScope.launch {
            val options = hashMapOf<String,String>()
            options["q"] = category
            options["apiKey"] = API_KEY

            when(category){
                BUSINESS -> businessNews = fetchAllNewsUseCase.invoke(options).asLiveData() as MutableLiveData<Result<List<ArticleModel>>>
                TECH -> techNews = fetchAllNewsUseCase.invoke(options).asLiveData() as MutableLiveData<Result<List<ArticleModel>>>
                POLITICS -> politicsNews = fetchAllNewsUseCase.invoke(options).asLiveData() as MutableLiveData<Result<List<ArticleModel>>>
                SCIENCE -> scienceNews = fetchAllNewsUseCase.invoke(options).asLiveData() as MutableLiveData<Result<List<ArticleModel>>>
                SPORTS -> sportsNews = fetchAllNewsUseCase.invoke(options).asLiveData() as MutableLiveData<Result<List<ArticleModel>>>
            }

        }
    }
}