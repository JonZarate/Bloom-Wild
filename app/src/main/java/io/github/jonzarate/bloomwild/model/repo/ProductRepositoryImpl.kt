package io.github.jonzarate.bloomwild.model.repo

import io.github.jonzarate.bloomwild.controller.ImageUrlProvider
import io.github.jonzarate.bloomwild.controller.PriceFormatter
import io.github.jonzarate.bloomwild.model.data.ProductAttributes
import io.github.jonzarate.bloomwild.model.net.BloomWildApi

// Small phone pictures
const val PICTURE_SMALL_WIDTH = 360
const val PICTURE_SMALL_HEIGHT = 360

// Big tablet pictures
const val PICTURE_LARGE_WIDTH = 720
const val PICTURE_LARGE_HEIGHT = 720

const val PICTURE_FORMAT = "jpeg"

class ProductRepositoryImpl (
    private val isTablet: Boolean,
    private val api: BloomWildApi,
    private val provider: ImageUrlProvider,
    private val formatter: PriceFormatter
) : ProductRepository {

    override suspend fun getProducts() : List<ProductAttributes> {
        return api.getProducts().data.map { productInfo ->
            productInfo.attributes.also { attrs ->
                attrs.sanitisedPrice = sanitisePrice(attrs)

                val width = if (isTablet) PICTURE_LARGE_WIDTH else PICTURE_SMALL_WIDTH
                val height = if (isTablet) PICTURE_LARGE_HEIGHT else PICTURE_SMALL_HEIGHT
                attrs.sanitisedMedia = sanitiseMedia(attrs, width, height)
            }
        }
    }

    private fun sanitiseMedia(attrs: ProductAttributes, width: Int, height: Int) : List<String> {
        return attrs.media.map { media ->
            provider.generateProcessedImageUrl(
                width,
                height,
                PICTURE_FORMAT,
                media.url)
        }
    }

    private fun sanitisePrice(attrs: ProductAttributes) : String {
        return attrs.prices.find { price -> price.quantity == 1 }?.let{ price ->
            formatter.formatPrice(price.pricePennies, attrs.currency)
        } ?: "SUBSCRIPTION"
    }
}