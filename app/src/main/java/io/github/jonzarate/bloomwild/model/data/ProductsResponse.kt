package io.github.jonzarate.bloomwild.model.data

import com.google.gson.annotations.SerializedName

class ProductsResponse (
    @SerializedName("data")
    private val data: Array<ProductInfo>
){
    val products: List<ProductAttributes>
        get() = data.map { info -> info.attributes }
}