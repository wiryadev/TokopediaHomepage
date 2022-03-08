package com.wiryadev.tokopediahomepage.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.wiryadev.tokopediahomepage.data.Service
import com.wiryadev.tokopediahomepage.databinding.ItemMainServiceBinding
import com.wiryadev.tokopediahomepage.dpToPx

class ServiceAdapter(
    private val services: List<Service>
) : RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>() {

    inner class ServiceViewHolder(
        private val binding: ItemMainServiceBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Service, isLastItem: Boolean) {
            with(binding) {
                ivService.load(data.icon)
                tvService.text = data.name

                if (isLastItem) {
                    val param = binding.root.layoutParams as ViewGroup.MarginLayoutParams
                    param.marginEnd = root.context.dpToPx(16f)
                    binding.root.layoutParams = param
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val view = ItemMainServiceBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ServiceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        holder.bind(services[position], position == (services.lastIndex))
    }

    override fun getItemCount(): Int = services.size

}