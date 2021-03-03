package io.github.jonzarate.bloomwild.model.data

import com.google.gson.annotations.SerializedName

data class ProductPrice(
    @SerializedName("price_pennies") val pricePennies: Int,
    @SerializedName("quantity") val quantity: Int
)