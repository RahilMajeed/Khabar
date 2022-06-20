package com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.home_fragment.fragments.all_news.adapters

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsModel(
    val heading: String?,
    val description: String?,
    val time: String?,
    val imageUrl: String?,
    val url: String

): Parcelable


