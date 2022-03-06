package com.wiryadev.tokopediahomepage.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wiryadev.tokopediahomepage.R
import com.wiryadev.tokopediahomepage.data.Service

class HomeViewModel : ViewModel() {

    private val _firstLineServices = MutableLiveData<List<Service>>().apply {
        value = getFirstLineServices()
    }
    val firstLineServices: LiveData<List<Service>> = _firstLineServices

    private val _promos = MutableLiveData<List<Int>>().apply {
        value = getPromos()
    }
    val promos: LiveData<List<Int>> = _promos

    private fun getFirstLineServices(): List<Service> = listOf(
        Service("Official Store", R.drawable.ic_os_icon_header),
        Service("Lihat Semua", R.drawable.ic_round_dashboard_24),
        Service("Kebutuhan Harian", R.drawable.ic_round_shopping_basket_24),
        Service("Handphone & Tablet", R.drawable.ic_round_tablet_android_24),
        Service("Top-Up & Tagihan", R.drawable.ic_baseline_receipt_long_24),
        Service("Keuangan", R.drawable.ic_round_monetization_on_24),
    )

//    private fun getPromos(): List<String> = listOf(
//        "https://images.tokopedia.net/img/cache/1190/wmEwCC/2022/3/5/5be6023b-e90a-4715-9e05-11044efff166.jpg",
//        "https://images.tokopedia.net/img/cache/1190/wmEwCC/2022/3/5/d77ce227-c5b1-4ad3-949d-b30a5bc31641.jpg",
//        "https://images.tokopedia.net/img/cache/1190/wmEwCC/2022/3/1/7835b45b-2303-4fcb-9656-5f2b6c3cd80c.jpg",
//    )

    private fun getPromos(): List<Int> = listOf(
        R.drawable.promo_1,
        R.drawable.promo_2,
        R.drawable.promo_3,
    )
}