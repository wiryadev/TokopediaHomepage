package com.wiryadev.tokopediahomepage.data

import androidx.annotation.DrawableRes

data class Video(
    @DrawableRes val thumbnail: Int,
    val title: String,
    val store: String,
    val views: Double,
    val discount: String,
)
