package io.github.jonzarate.bloomwild

import io.github.jonzarate.bloomwild.model.net.BloomWildApi
import io.github.jonzarate.bloomwild.model.net.Retrofit
import io.github.jonzarate.bloomwild.model.repo.ProductRepository
import io.github.jonzarate.bloomwild.view.MainViewModelFactory

object Injector {

    val api: BloomWildApi = Retrofit.createClient(BuildConfig.API_BASE_URL)
    val repo: ProductRepository = ProductRepository(api)
    val mainViewModelFactory: MainViewModelFactory = MainViewModelFactory(repo)

}