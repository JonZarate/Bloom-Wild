package io.github.jonzarate.bloomwild.viewmodel.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.jonzarate.bloomwild.model.repo.AppRepository

class DetailViewModelFactory(
    val app: AppRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailViewModel(app) as T
    }

}