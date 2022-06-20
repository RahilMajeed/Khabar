package com.snapp.khabar.feature_fetch_news.domain.model

data class ArticleModel(
    private val id: String,
    val heading: String,
    val time: String,
    val desc: String,
    val image: String,
    val url: String
)
