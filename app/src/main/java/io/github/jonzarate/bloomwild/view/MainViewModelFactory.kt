package io.github.jonzarate.bloomwild.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.jonzarate.bloomwild.model.repo.ProductRepository
import io.github.jonzarate.bloomwild.viewmodel.MainViewModel

class MainViewModelFactory(
    val repo: ProductRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repo) as T
    }


}