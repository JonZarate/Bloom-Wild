package io.github.jonzarate.bloomwild.view.detail

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.github.jonzarate.bloomwild.R
import io.github.jonzarate.bloomwild.databinding.ViewholderDetailBinding
import io.github.jonzarate.bloomwild.model.data.ProductAttributes

class DetailViewHolder(
    private val binding: ViewholderDetailBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun setProduct(imageUrl: String){
        Glide.with(itemView.context)
            .load(imageUrl)
            .placeholder(R.drawable.ic_bloom_wild)
            .into(binding.viewholderDetailImage)
    }

}