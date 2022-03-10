package com.wiryadev.tokopediahomepage.ui.home

import android.app.Activity
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.View
import android.view.WindowManager
import android.viewbinding.library.fragment.viewBinding
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.wiryadev.tokopediahomepage.R
import com.wiryadev.tokopediahomepage.databinding.FragmentHomeBinding
import com.wiryadev.tokopediahomepage.dpToPx

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

        val actionBarHeight = binding.root.context.dpToPx(24f)

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            binding.scrollview.setOnScrollChangeListener { _, _, scrollY, _, _ ->
                val appBarColor = ContextCompat.getColor(
                    requireContext(),
                    when {
                        scrollY in 1 until actionBarHeight -> {
                            R.color.white
                        }
                        scrollY > actionBarHeight -> R.color.white
                        else -> R.color.green_200
                    }
                )
                val iconColor = ContextCompat.getColor(
                    requireContext(),
                    if (scrollY > actionBarHeight
                        || scrollY in 1 until actionBarHeight
                    ) R.color.grey_500 else R.color.white
                )

                val alpha = if (scrollY in 1 until actionBarHeight) {
                    216
                } else 255

                binding.appBarHome.run {
                    appBarBackground.setBackgroundColor(appBarColor)
                    appBarBackground.background.alpha = alpha
                    btnCart.setColorFilter(iconColor)
                    btnInbox.setColorFilter(iconColor)
                    btnMenu.setColorFilter(iconColor)
                    btnNotification.setColorFilter(iconColor)
                }

                val statusBarColor = ContextCompat.getColor(
                    requireContext(),
                    if (scrollY > 1) R.color.white else R.color.green_200
                )
                val isLight = scrollY > 1

                activity?.changeStatusBarColor(
                    statusBarColor,
                    isLight
                )
            }
        }

        viewModel.primaryServices.observe(viewLifecycleOwner) {
            val adapter = ServiceAdapter(it)
            binding.rvPrimaryServices.adapter = adapter
        }

        viewModel.secondaryServices.observe(viewLifecycleOwner) {
            val adapter = ServiceAdapter(it)
            binding.rvSecondaryServices.adapter = adapter
        }

        val compositePageTransformer = CompositePageTransformer()
        val marginPage = requireContext().dpToPx(8f)
        compositePageTransformer.addTransformer(MarginPageTransformer(marginPage))

        viewModel.promos.observe(viewLifecycleOwner) {
            val vpAdapter = PromoAdapter(it)
            binding.vpPromos.run {
                adapter = vpAdapter
                clipToPadding = false
                clipChildren = false
                offscreenPageLimit = 3
                getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
                setPageTransformer(compositePageTransformer)
            }
        }

        viewModel.videos.observe(viewLifecycleOwner) {
            val adapter = VideoAdapter(it)
            binding.rvVideos.adapter = adapter
        }

        viewModel.discountedProducts.observe(viewLifecycleOwner) {
            val adapter = DiscountedProductAdapter(it)
            binding.rvDiscount.adapter = adapter
        }
    }

    private fun Activity.changeStatusBarColor(color: Int, isLight: Boolean) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = color

        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = isLight
    }
}