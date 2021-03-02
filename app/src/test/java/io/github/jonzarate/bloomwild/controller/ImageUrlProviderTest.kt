package io.github.jonzarate.bloomwild.controller

import org.junit.Test

import org.junit.Assert.*

class ImageUrlProviderTest {

    @Test
    fun generatedUrlHasCorrectValues() {
        val width = 1234
        val height = 5678
        val format = "abcd"
        val url = "xyz"

        val expected = "https://media.bloomdev.org/v1/trim:15/${width}x${height}/smart/filters:format(${format})/${url}"

        val outcome = ImageUrlProvider().generateProcessedImageUrl(width, height, format, url)

        assertEquals(expected, outcome)
    }
}