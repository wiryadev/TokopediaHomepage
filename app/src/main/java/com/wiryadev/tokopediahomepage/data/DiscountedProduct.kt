package com.wiryadev.tokopediahomepage.data

data class DiscountedProduct(
    val imageUrl: String,
    val discount: Int,
    val price: Int,
    val originalPrice: Int,
    val location: String,
    val isOfficialStore: Boolean,
)