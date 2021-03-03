package io.github.jonzarate.bloomwild.viewmodel.detail

import androidx.lifecycle.ViewModel
import io.github.jonzarate.bloomwild.model.repo.AppRepository

class DetailViewModel(
    private val app: AppRepository
) : ViewModel() {

    val product get () = app.selectedItem

}