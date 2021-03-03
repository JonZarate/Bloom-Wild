package io.github.jonzarate.bloomwild.viewmodel.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.jonzarate.bloomwild.SingleLiveEvent
import io.github.jonzarate.bloomwild.model.data.ProductAttributes
import io.github.jonzarate.bloomwild.model.repo.AppRepository
import io.github.jonzarate.bloomwild.model.repo.ProductRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val repo: ProductRepository,
    private val app: AppRepository
) : ViewModel() {

    val products = MutableLiveData<List<ProductAttributes>>()
    val onHighlightedProductChanged = SingleLiveEvent<Int>()

    var lastHighlatedItem: ProductAttributes? = null

    init {
        viewModelScope.launch {
            products.postValue(repo.getProducts())
        }
    }

    fun onProductSelected(position: Int) {
        lastHighlatedItem?.isHighlighted = false
        lastHighlatedItem = null

        products.value?.get(position)?.also {
            it.isHighlighted = true
            lastHighlatedItem = it
            app.selectedItem.postValue(it)
        }

        onHighlightedProductChanged.postValue(position)
    }
}