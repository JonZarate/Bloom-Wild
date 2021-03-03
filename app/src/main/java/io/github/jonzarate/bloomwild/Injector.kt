package io.github.jonzarate.bloomwild

import io.github.jonzarate.bloomwild.controller.ImageUrlProvider
import io.github.jonzarate.bloomwild.controller.PriceFormatter
import io.github.jonzarate.bloomwild.model.net.BloomWildApi
import io.github.jonzarate.bloomwild.model.net.Retrofit
import io.github.jonzarate.bloomwild.model.repo.AppRepository
import io.github.jonzarate.bloomwild.model.repo.ProductRepository
import io.github.jonzarate.bloomwild.viewmodel.detail.DetailViewModelFactory
import io.github.jonzarate.bloomwild.viewmodel.main.MainViewModelFactory

object Injector {

    var isTablet = false

    val imageUrlProvider: ImageUrlProvider = ImageUrlProvider()
    val priceFormatter: PriceFormatter = PriceFormatter()

    val api: BloomWildApi = Retrofit.createClient(BuildConfig.API_BASE_URL)

    val repo by lazy { ProductRepository(isTablet, api, imageUrlProvider, priceFormatter) }
    val app by lazy { AppRepository(isTablet) }

    val mainViewModelFactory by lazy { MainViewModelFactory(repo, app) }
    val detailViewModelFactory by lazy { DetailViewModelFactory(app) }

}