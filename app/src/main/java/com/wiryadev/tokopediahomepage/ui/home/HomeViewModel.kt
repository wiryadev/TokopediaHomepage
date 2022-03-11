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
        Service("Official Store", R.drawable.ic_os_service),
        Service("Lihat Semua", R.drawable.ic_see_all),
        Service("Kebutuhan Harian", R.drawable.ic_daily_needs),
        Service("Elektronik", R.drawable.ic_electronic),
        Service("Top-Up & Tagihan", R.drawable.ic_top_up),
        Service("Office & Stationery", R.drawable.ic_stationery),
        Service("Keuangan", R.drawable.ic_money),
        Service("Travel & Entertainment", R.drawable.ic_plane),
        Service("Handphone & Tablet", R.drawable.ic_phone_tab),
    )

    private fun getSecondaryServices(): List<Service> = listOf(
        Service("Peduli Lindungi", R.drawable.ic_transport_24_pedulilindungi),
        Service("Bazar Hari Ini", R.drawable.ic_bazaar),
        Service("Live Shopping", R.drawable.ic_live_shopping),
        Service("Tokopedia Seru", R.drawable.ic_seru),
        Service("Bangga Lokal", R.drawable.ic_local_pride),
        Service("Bayar di Tempat", R.drawable.ic_cod),
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
        R.drawable.promo_4,
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
        DiscountedProduct(
            imageUrl = "https://images.tokopedia.net/img/cache/900/VqbcmM/2020/9/16/d1a3c190-13d4-4692-98f5-2f04202cd371.jpg",
            discount = 43,
            price = 17000,
            originalPrice = 29950,
            location = "Jakarta Barat",
            isOfficialStore = false,
        ),
    )
}