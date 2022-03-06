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

    private fun getFirstLineServices(): List<Service> = listOf(
        Service("Official Store", R.drawable.ic_os_icon_header),
        Service("Lihat Semua", R.drawable.ic_round_dashboard_24),
        Service("Kebutuhan Harian", R.drawable.ic_round_shopping_basket_24),
        Service("Handphone & Tablet", R.drawable.ic_round_tablet_android_24),
        Service("Top-Up & Tagihan", R.drawable.ic_baseline_receipt_long_24),
        Service("Keuangan", R.drawable.ic_round_monetization_on_24),
    )
}