package io.github.jonzarate.bloomwild.viewmodel.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.jonzarate.bloomwild.model.repo.AppRepository
import io.github.jonzarate.bloomwild.model.repo.ProductRepository

class MainViewModelFactory(
    val repo: ProductRepository,
    val app: AppRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repo, app) as T
    }

}