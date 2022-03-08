package com.wiryadev.tokopediahomepage.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wiryadev.tokopediahomepage.R
import com.wiryadev.tokopediahomepage.data.DiscountedProduct
import com.wiryadev.tokopediahomepage.data.Service
import com.wiryadev.tokopediahomepage.data.Video

class HomeViewModel : ViewModel() {

    private val _primaryServices = MutableLiveData<List<Service>>().apply {
        value = getPrimaryServices()
    }
    val primaryServices: LiveData<List<Service>> = _primaryServices

    private val _secondaryServices = MutableLiveData<List<Service>>().apply {
        value = getSecondaryServices()
    }
    val secondaryServices: LiveData<List<Service>> = _secondaryServices

    private val _promos = MutableLiveData<List<Int>>().apply {
        value = getPromos()
    }
    val promos: LiveData<List<Int>> = _promos

    private val _videos = MutableLiveData<List<Video>>().apply {
        value = getVideos()
    }
    val videos: LiveData<List<Video>> = _videos

    private val _discountedProducts = MutableLiveData<List<DiscountedProduct>>().apply {
        value = getDiscountedProducts()
    }
    val discountedProducts: LiveData<List<DiscountedProduct>> = _discountedProducts

    private fun getPrimaryServices(): List<Service> = listOf(
        Service("Official Store", R.drawable.ic_os_icon_header),
        Service("Lihat Semua", R.drawable.ic_round_dashboard_24),
        Service("Kebutuhan Harian", R.drawable.ic_round_shopping_basket_24),
        Service("Handphone & Tablet", R.drawable.ic_round_tablet_android_24),
        Service("Top-Up & Tagihan", R.drawable.ic_baseline_receipt_long_24),
        Service("Keuangan", R.drawable.ic_round_monetization_on_24),
    )

    private fun getSecondaryServices(): List<Service> = listOf(
        Service("Peduli Lindungi", R.drawable.ic_transport_24_pedulilindungi),
        Service("Bazar Hari Ini", R.drawable.ic_round_curtains_24),
        Service("Live Shopping", R.drawable.ic_round_play_arrow_24),
        Service("Tokopedia Seru", R.drawable.ic_round_videogame_asset_24),
        Service("Bangga Lokal", R.drawable.ic_round_heart_broken_24),
        Service("Bayar di Tempat", R.drawable.ic_round_handshake_24),
    )

    private fun getVideos(): List<Video> = listOf(
        Video(
            thumbnail = R.drawable.video_thumbnail_1,
            title = "Cosplay Kit termurah hanya di sini",
            store = "CosplayPedia",
            views = 2.5,
            discount = "Diskon 70%"
        ),
        Video(
            thumbnail = R.drawable.video_thumbnail_2,
            title = "Fashion kekinian kantong tetep aman",
            store = "FashionINsta",
            views = 2.0,
            discount = "Kupon Spesial"
        ),
        Video(
            thumbnail = R.drawable.video_thumbnail_3,
            title = "Alat recording buat streamer pemula",
            store = "RecOrder",
            views = 1.1,
            discount = "Cashback 50%"
        ),
    )

    private fun getPromos(): List<Int> = listOf(
        R.drawable.promo_1,
        R.drawable.promo_2,
        R.drawable.promo_3,
    )

    private fun getDiscountedProducts(): List<DiscountedProduct> = listOf(
        DiscountedProduct(
            imageUrl = "https://images.tokopedia.net/img/cache/900/VqbcmM/2022/2/24/94a15375-c181-43f7-a584-bff54fbdeb19.jpg",
            discount = 50,
            price = 85000,
            originalPrice = 170000,
            location = "Jakarta Pusat",
            isOfficialStore = true,
        ),
        DiscountedProduct(
            imageUrl = "https://images.tokopedia.net/img/cache/900/product-1/2019/10/17/6434676/6434676_8370ebbe-466e-4799-bba0-0b9ee02cf17b.jpg",
            discount = 57,
            price = 19800,
            originalPrice = 45900,
            location = "Jakarta Barat",
            isOfficialStore = true,
        ),
        DiscountedProduct(
            imageUrl = "https://images.tokopedia.net/img/cache/900/VqbcmM/2022/3/1/88fa7932-0424-4512-8eaf-b1f5545b40e9.jpg",
            discount = 33,
            price = 30000,
            originalPrice = 45000,
            location = "Jakarta Pusat",
            isOfficialStore = false,
        ),
        DiscountedProduct(
            imageUrl = "https://images.tokopedia.net/img/cache/900/VqbcmM/2021/10/8/d25ea626-5921-457f-aa34-4747674a8cf3.png",
            discount = 73,
            price = 19999,
            originalPrice = 75000,
            location = "Jakarta Selatan",
            isOfficialStore = true,
        ),
    )
}