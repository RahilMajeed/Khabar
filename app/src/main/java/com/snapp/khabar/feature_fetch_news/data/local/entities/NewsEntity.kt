package com.snapp.khabar.feature_fetch_news.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "EntityTable"
)

data class NewsEntity(
    val title : String,
    val time : String,
    val description : String,
    val imageUrl: String,
    val url: String,
    val isBookmarked: Boolean,
    @PrimaryKey
    val id: Int? = null,

)
