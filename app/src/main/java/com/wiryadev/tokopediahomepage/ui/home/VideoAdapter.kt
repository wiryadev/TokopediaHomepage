package com.wiryadev.tokopediahomepage.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.wiryadev.tokopediahomepage.data.Video
import com.wiryadev.tokopediahomepage.databinding.ItemLivePreviewBinding
import com.wiryadev.tokopediahomepage.dpToPx

class VideoAdapter(
    private val videos: List<Video>
) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    inner class VideoViewHolder(
        private val binding: ItemLivePreviewBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Video, isLastItem: Boolean) {
            with(binding) {
                ivThumbnail.load(data.thumbnail) {
                    size(500)
                }
                tvTitleLive.text = data.title
                tvStoreLive.text = data.store
                tvLiveViews.text = StringBuilder(data.views.toString()).append(" rb")
                tvDiscount.text = data.discount

                if (isLastItem) {
                    val param = binding.root.layoutParams as ViewGroup.MarginLayoutParams
                    param.marginEnd = root.context.dpToPx(16f)
                    binding.root.layoutParams = param
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = ItemLivePreviewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(videos[position], position == videos.lastIndex)
    }

    override fun getItemCount(): Int = videos.size

}