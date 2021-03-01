package io.github.jonzarate.bloomwild.model.repo

import io.github.jonzarate.bloomwild.model.data.ProductAttributes
import io.github.jonzarate.bloomwild.model.net.BloomWildApi

class ProductRepository (
    private val api: BloomWildApi
) {

    suspend fun getProducts() : List<ProductAttributes> {
        return api.getProducts().products
    }

}