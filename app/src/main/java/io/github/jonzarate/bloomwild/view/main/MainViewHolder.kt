package io.github.jonzarate.bloomwild.view.main

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.github.jonzarate.bloomwild.R
import io.github.jonzarate.bloomwild.databinding.ViewholderProductBinding
import io.github.jonzarate.bloomwild.model.data.ProductAttributes

class MainViewHolder(
    private val binding: ViewholderProductBinding,
    private val listener: OnProductClick
) : RecyclerView.ViewHolder(binding.root) {

    interface OnProductClick {
        fun onProductClick(position: Int)
    }

    init {
        binding.root.setOnClickListener { _ ->
            listener.onProductClick(adapterPosition)
        }
    }

    fun setProduct(productAttributes: ProductAttributes){

        itemView.setBackgroundResource(
            if (productAttributes.isHighlighted)
                R.color.soft_yellow
            else
                 0

        )

        with(binding){
            viewholderProductCollectionName.text = productAttributes.collectionName
            viewholderProductName.text = productAttributes.name
            viewholderProductPrice.text = productAttributes.sanitisedPrice

            productAttributes.sanitisedMedia[0]?.url?.also { sanitisedUrl ->
                Glide.with(itemView.context)
                    .load(sanitisedUrl)
                    .placeholder(R.drawable.ic_bloom_wild)
                    .into(viewholderProductImage)
            }
        }
    }

}