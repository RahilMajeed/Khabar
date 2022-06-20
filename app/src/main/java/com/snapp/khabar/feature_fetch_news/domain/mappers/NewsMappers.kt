package com.snapp.khabar.feature_fetch_news.domain.mappers

import com.snapp.khabar.feature_fetch_news.data.remote.dto.ArticleDto
import com.snapp.khabar.feature_fetch_news.domain.model.ArticleModel
import com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.home_fragment.fragments.all_news.adapters.NewsModel


fun ArticleDto.toArticleModel(): ArticleModel {
    return ArticleModel(
        id = "",
        heading = title ?: "Title Unavailable",
        time = publishedAt?: "Unavailable",
        desc = description ?: "No description to show",
        image = urlToImage ?: ""
    )
}

fun ArticleModel.toNewsModel() : NewsModel {

    return NewsModel(
        heading = heading,
        description = desc,
        time = time,
        imageUrl = image
    )
}