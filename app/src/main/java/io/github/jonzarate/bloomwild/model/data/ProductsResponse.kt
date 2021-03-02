package io.github.jonzarate.bloomwild.model.data

import com.google.gson.annotations.SerializedName

class ProductsResponse (
    @SerializedName("data")
    val data: Array<ProductInfo>
)