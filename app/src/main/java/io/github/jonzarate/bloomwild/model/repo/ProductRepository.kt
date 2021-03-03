package io.github.jonzarate.bloomwild.model.repo

import io.github.jonzarate.bloomwild.model.data.ProductAttributes

interface ProductRepository {
    suspend fun getProducts() : List<ProductAttributes>
}