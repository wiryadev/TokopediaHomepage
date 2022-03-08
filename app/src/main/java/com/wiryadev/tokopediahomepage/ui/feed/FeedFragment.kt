package com.wiryadev.tokopediahomepage.ui.feed

import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import com.wiryadev.tokopediahomepage.R
import com.wiryadev.tokopediahomepage.databinding.FragmentFeedBinding

class FeedFragment : Fragment(R.layout.fragment_feed) {

    private val binding by viewBinding<FragmentFeedBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}