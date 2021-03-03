package io.github.jonzarate.bloomwild.viewmodel.main

import io.github.jonzarate.bloomwild.model.data.ProductAttributes
import io.github.jonzarate.bloomwild.model.data.ProductMedia
import io.github.jonzarate.bloomwild.model.data.ProductPrice

class MainViewModelTestHelper {

    data class TestData (
        val rawApiResponse: ProductAttributes,
        val sanitisedForPhone: ProductAttributes,
        val sanitisedForTablet: ProductAttributes
    )

    val testData0 = TestData(
        ProductAttributes(
            "",
            "",
            "EUR",
            listOf(ProductPrice(56789, 1)),
            listOf(ProductMedia("url"))
        ),
        ProductAttributes(
            "",
            "",
            "EUR",
            listOf(ProductPrice(56789, 1)),
            listOf(ProductMedia("url")),
            "567.89€",
            listOf("https://media.bloomdev.org/v1/trim:15/360x360/smart/filters:format(jpeg)/url")
        ),
        ProductAttributes(
            "",
            "",
            "EUR",
            listOf(ProductPrice(56789, 1)),
            listOf(ProductMedia("url")),
            "567.89€",
            listOf("https://media.bloomdev.org/v1/trim:15/720x720/smart/filters:format(jpeg)/url")
        )
    )

    val testData1 = TestData(
            ProductAttributes(
                "",
                "",
                "GBP",
                listOf(ProductPrice(56700, 2)),
                listOf(ProductMedia("second"))
            ),
            ProductAttributes(
                "",
                "",
                "GBP",
                listOf(ProductPrice(56700, 2)),
                listOf(ProductMedia("second")),
                "SUBSCRIPTION",
                listOf("https://media.bloomdev.org/v1/trim:15/360x360/smart/filters:format(jpeg)/second")
            ),
            ProductAttributes(
                "",
                "",
                "GBP",
                listOf(ProductPrice(56700, 2)),
                listOf(ProductMedia("second")),
                "SUBSCRIPTION",
                listOf("https://media.bloomdev.org/v1/trim:15/720x720/smart/filters:format(jpeg)/second")
            )
    )

    val testData2 = TestData (
        ProductAttributes(
            "",
            "",
            "GBP",
            listOf(ProductPrice(7654300, 1)),
            listOf(ProductMedia("third url"))
        ),
        ProductAttributes(
            "",
            "",
            "GBP",
            listOf(ProductPrice(7654300, 1)),
            listOf(ProductMedia("third url")),
            "£76543",
            listOf("https://media.bloomdev.org/v1/trim:15/360x360/smart/filters:format(jpeg)/third url")
        ),
        ProductAttributes(
            "",
            "",
            "GBP",
            listOf(ProductPrice(7654300, 1)),
            listOf(ProductMedia("third url")),
            "£76543",
            listOf("https://media.bloomdev.org/v1/trim:15/720x720/smart/filters:format(jpeg)/third url")
        )
    )

}