package io.github.jonzarate.bloomwild.model.net

import io.github.jonzarate.bloomwild.model.data.ProductsResponse

class FakeBloomWildApi(
    val response: ProductsResponse
) : BloomWildApi {
    override suspend fun getProducts(): ProductsResponse {
        return response
    }
}