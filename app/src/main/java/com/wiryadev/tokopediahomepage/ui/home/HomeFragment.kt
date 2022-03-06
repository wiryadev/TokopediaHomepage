package com.wiryadev.tokopediahomepage.ui.home

import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.wiryadev.tokopediahomepage.R
import com.wiryadev.tokopediahomepage.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding<FragmentHomeBinding>()

    private val viewModel by viewModels<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sendToString = getString(R.string.send_to)
        val spannable = SpannableString("$sendToString Alamat Rumah Abrar Wiryawan").apply {
            setSpan(
                StyleSpan(Typeface.BOLD),
                sendToString.length,
                this.length,
                Spannable.SPAN_INCLUSIVE_EXCLUSIVE,
            )
        }
        binding.tvSendTo.text = spannable

        viewModel.firstLineServices.observe(viewLifecycleOwner) {
            val adapter = ServiceAdapter(it)
            binding.rvFirstServices.adapter = adapter
        }

        viewModel.promos.observe(viewLifecycleOwner) {
            val adapter = PromoAdapter(it)
            binding.vpPromos.adapter = adapter
        }
    }
}