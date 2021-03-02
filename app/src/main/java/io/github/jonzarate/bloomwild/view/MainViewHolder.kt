package io.github.jonzarate.bloomwild.view

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.github.jonzarate.bloomwild.R
import io.github.jonzarate.bloomwild.databinding.ViewholderProductBinding
import io.github.jonzarate.bloomwild.model.data.ProductAttributes

class MainViewHolder(
    private val binding: ViewholderProductBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun setProduct(productAttributes: ProductAttributes){

        with(binding){
            viewholderProductCollectionName.text = productAttributes.collectionName
            viewholderProductName.text = productAttributes.name
            viewholderProductPrice.text = productAttributes.sanitisedPrice

            productAttributes.sanitisedMedia[0]?.url?.also { sanitisedUrl ->
                Glide.with(itemView.context)
                    .load(sanitisedUrl)
                    .placeholder(R.drawable.ic_bloom_wild)
                    .into(binding.viewholderProductImage)
            }
        }
    }

}