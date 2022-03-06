package com.wiryadev.tokopediahomepage.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.wiryadev.tokopediahomepage.databinding.ItemPromoBinding

class PromoAdapter(
    private val promos: List<Int>
) : RecyclerView.Adapter<PromoAdapter.PromoViewHolder>() {

    inner class PromoViewHolder(
        val binding: ItemPromoBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromoViewHolder {
        val binding = ItemPromoBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return PromoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PromoViewHolder, position: Int) {
        holder.binding.imageView.load(promos[position])
    }

    override fun getItemCount(): Int = promos.size
}