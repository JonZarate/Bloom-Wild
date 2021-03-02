package io.github.jonzarate.bloomwild

import io.github.jonzarate.bloomwild.controller.ImageUrlProvider
import io.github.jonzarate.bloomwild.controller.PriceFormatter
import io.github.jonzarate.bloomwild.model.net.BloomWildApi
import io.github.jonzarate.bloomwild.model.net.Retrofit
import io.github.jonzarate.bloomwild.model.repo.ProductRepository
import io.github.jonzarate.bloomwild.view.MainViewModelFactory

object Injector {

    val imageUrlProvider: ImageUrlProvider = ImageUrlProvider()
    val priceFormatter: PriceFormatter = PriceFormatter()

    val api: BloomWildApi = Retrofit.createClient(BuildConfig.API_BASE_URL)
    val repo: ProductRepository = ProductRepository(api, imageUrlProvider, priceFormatter)
    val mainViewModelFactory: MainViewModelFactory = MainViewModelFactory(repo)

}