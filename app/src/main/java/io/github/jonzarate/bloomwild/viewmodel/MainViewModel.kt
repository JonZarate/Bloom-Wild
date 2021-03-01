package io.github.jonzarate.bloomwild.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.jonzarate.bloomwild.model.data.ProductAttributes
import io.github.jonzarate.bloomwild.model.repo.ProductRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val repo: ProductRepository
) : ViewModel() {

    val products = MutableLiveData<List<ProductAttributes>>()

    init {
        viewModelScope.launch {
            products.postValue(repo.getProducts())
        }
    }
}