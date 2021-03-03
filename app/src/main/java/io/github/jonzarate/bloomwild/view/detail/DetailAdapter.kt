package io.github.jonzarate.bloomwild.view.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.jonzarate.bloomwild.databinding.ViewholderDetailBinding
import io.github.jonzarate.bloomwild.model.data.ProductAttributes

class DetailAdapter : RecyclerView.Adapter<DetailViewHolder>() {

    private var product: ProductAttributes? = null

    fun submitProduct(newProduct: ProductAttributes?) {
        product = newProduct
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewholderDetailBinding.inflate(inflater, parent, false)
        return DetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        product?.sanitisedMedia?.also {
            holder.setProduct(it[position].url)
        }
    }

    override fun getItemCount(): Int {
        return product?.sanitisedMedia?.size ?: 0
    }
}