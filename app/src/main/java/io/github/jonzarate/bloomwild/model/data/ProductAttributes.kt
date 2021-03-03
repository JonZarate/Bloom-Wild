package io.github.jonzarate.bloomwild.model.data

import com.google.gson.annotations.SerializedName

data class ProductAttributes (
    @SerializedName("name") val name: String,
    @SerializedName("collection_name") val collectionName: String,
    @SerializedName("currency") val currency: String,
    @SerializedName("price_data") val prices: List<ProductPrice>,
    @SerializedName("media") val media: List<ProductMedia>,
    var sanitisedPrice: String? = null,
    var sanitisedMedia: List<String>? = null
) {
    var isHighlighted = false
}