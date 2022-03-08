package com.wiryadev.tokopediahomepage.ui.home

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.wiryadev.tokopediahomepage.R
import com.wiryadev.tokopediahomepage.data.DiscountedProduct
import com.wiryadev.tokopediahomepage.databinding.ItemDiscountedProductBinding

class DiscountedProductAdapter(
    private val products: List<DiscountedProduct>
) : RecyclerView.Adapter<DiscountedProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(
        private val binding: ItemDiscountedProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: DiscountedProduct, isLastItem: Boolean) {
            with(binding) {
                ivProduct.load(data.imageUrl)
                tvPrice.text = root.context.getString(R.string.price, data.price)
                tvOriginalPrice.text = root.context.getString(R.string.price, data.originalPrice)
                tvOriginalPrice.paintFlags = tvOriginalPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                tvDiscount.text = StringBuilder(data.discount.toString()).append("%")

                tvLocation.text = data.location
                val drawableStoreType = if (data.isOfficialStore) {
                    ContextCompat.getDrawable(root.context, R.drawable.ic_os_16)
                } else {
                    ContextCompat.getDrawable(root.context, R.drawable.ic_power_merchant_16)
                }

                tvLocation.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    drawableStoreType, null, null, null
                )

                if (isLastItem) {
                    val param = binding.root.layoutParams as ViewGroup.MarginLayoutParams
                    param.marginEnd = 48
                    binding.root.layoutParams = param
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = ItemDiscountedProductBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position], position == (products.lastIndex))
    }

    override fun getItemCount(): Int = products.size
}