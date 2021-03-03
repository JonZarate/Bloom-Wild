package io.github.jonzarate.bloomwild.model.repo

import androidx.lifecycle.MutableLiveData
import io.github.jonzarate.bloomwild.model.data.ProductAttributes

class AppRepositoryImpl (
    override val isTablet: Boolean
) : AppRepository {
    override val selectedItem = MutableLiveData<ProductAttributes?>()
}