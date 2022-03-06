package com.wiryadev.tokopediahomepage.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wiryadev.tokopediahomepage.R
import com.wiryadev.tokopediahomepage.data.Service

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

    private fun getPromos(): List<Int> = listOf(
        R.drawable.promo_1,
        R.drawable.promo_2,
        R.drawable.promo_3,
    )
}