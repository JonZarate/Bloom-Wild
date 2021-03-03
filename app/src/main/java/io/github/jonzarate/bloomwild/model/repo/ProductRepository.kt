package io.github.jonzarate.bloomwild.model.repo

import io.github.jonzarate.bloomwild.controller.ImageUrlProvider
import io.github.jonzarate.bloomwild.controller.PriceFormatter
import io.github.jonzarate.bloomwild.model.data.ProductAttributes
import io.github.jonzarate.bloomwild.model.data.ProductMedia
import io.github.jonzarate.bloomwild.model.net.BloomWildApi

// Small phone pictures
const val PICTURE_SMALL_WIDTH = 360
const val PICTURE_SMALL_HEIGHT = 360

// Big tablet pictures
const val PICTURE_LARGE_WIDTH = 720
const val PICTURE_LARGE_HEIGHT = 720

const val PICTURE_FORMAT = "jpeg"

class ProductRepository (
    private val api: BloomWildApi,
    private val provider: ImageUrlProvider,
    private val formatter: PriceFormatter
) {

    suspend fun getProducts() : List<ProductAttributes> {
        return api.getProducts().data.map { productInfo ->
            productInfo.attributes.also { attrs ->
                attrs.sanitisedMedia = sanitiseMedia(attrs)
                attrs.sanitisedPrice = sanitisePrice(attrs)
            }
        }
    }

    private fun sanitiseMedia(attrs: ProductAttributes) : Array<ProductMedia> {
        return attrs.media.map { media ->
            ProductMedia(provider.generateProcessedImageUrl(
                PICTURE_SMALL_HEIGHT,
                PICTURE_SMALL_WIDTH,
                PICTURE_FORMAT,
                media.url))
        }.toTypedArray()
    }

    private fun sanitisePrice(attrs: ProductAttributes) : String {
        return attrs.prices.find { price -> price.quantity == 1 }?.let{ price ->
            formatter.formatPrice(price.pricePennies, attrs.currency)
        } ?: "SUBSCRIPTION"
    }
}