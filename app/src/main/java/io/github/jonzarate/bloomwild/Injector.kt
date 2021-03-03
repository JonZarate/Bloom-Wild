package io.github.jonzarate.bloomwild

import io.github.jonzarate.bloomwild.controller.ImageUrlProvider
import io.github.jonzarate.bloomwild.controller.PriceFormatter
import io.github.jonzarate.bloomwild.model.net.BloomWildApi
import io.github.jonzarate.bloomwild.model.net.Retrofit
import io.github.jonzarate.bloomwild.model.repo.AppRepositoryImpl
import io.github.jonzarate.bloomwild.model.repo.ProductRepositoryImpl
import io.github.jonzarate.bloomwild.viewmodel.detail.DetailViewModelFactory
import io.github.jonzarate.bloomwild.viewmodel.main.MainViewModelFactory

object Injector {

    var isTablet = false

    val imageUrlProvider: ImageUrlProvider = ImageUrlProvider()
    val priceFormatter: PriceFormatter = PriceFormatter()

    val api: BloomWildApi = Retrofit.createClient(BuildConfig.API_BASE_URL)

    val repo by lazy { ProductRepositoryImpl(isTablet, api, imageUrlProvider, priceFormatter) }
    val app by lazy { AppRepositoryImpl(isTablet) }

    val mainViewModelFactory by lazy { MainViewModelFactory(repo, app) }
    val detailViewModelFactory by lazy { DetailViewModelFactory(app) }

}