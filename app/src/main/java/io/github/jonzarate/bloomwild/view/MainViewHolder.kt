package io.github.jonzarate.bloomwild.view

import androidx.recyclerview.widget.RecyclerView
import io.github.jonzarate.bloomwild.databinding.ViewholderProductBinding
import io.github.jonzarate.bloomwild.model.data.ProductAttributes

class MainViewHolder(
    private val binding: ViewholderProductBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun setProduct(productAttributes: ProductAttributes){
        val singleUnitPrice = productAttributes.prices.find { price -> price.quantity == 1 }
        val priceConversion = (singleUnitPrice?.pricePennies ?: 0) / 100F

        with(binding){
            viewholderProductName.text = productAttributes.name
            viewholderProductPrice.text = "$priceConversion ${productAttributes.currency}"
        }
    }

}