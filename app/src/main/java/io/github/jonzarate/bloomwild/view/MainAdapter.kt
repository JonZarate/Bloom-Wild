package io.github.jonzarate.bloomwild.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.jonzarate.bloomwild.databinding.ViewholderProductBinding
import io.github.jonzarate.bloomwild.model.data.ProductAttributes

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    private val products = mutableListOf<ProductAttributes>()

    fun submitProducts(newProducts: List<ProductAttributes>?) {
        products.clear()

        newProducts?.also {
            products.addAll(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewholderProductBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.setProduct(products[position])
    }

    override fun getItemCount(): Int {
        return products.size
    }
}