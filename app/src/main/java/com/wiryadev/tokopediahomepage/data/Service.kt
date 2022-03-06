package com.wiryadev.tokopediahomepage.data

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

data class Service(
    val name: String,
    @DrawableRes val icon: Int,
    @ColorRes val tint: Int? = null,
)
