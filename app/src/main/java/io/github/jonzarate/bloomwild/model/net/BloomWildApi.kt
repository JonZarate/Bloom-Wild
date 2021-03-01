package io.github.jonzarate.bloomwild.model.net

import io.github.jonzarate.bloomwild.model.data.ProductsResponse
import retrofit2.http.GET

interface BloomWildApi {

    @GET("availability/products?locale=en&shipping_country_id=1&first_item_in_purchase=true")
    suspend fun getProducts() : ProductsResponse
}