package io.github.jonzarate.bloomwild.model.repo

import androidx.lifecycle.MutableLiveData
import io.github.jonzarate.bloomwild.model.data.ProductAttributes

class AppRepository {

    val selectedItem = MutableLiveData<ProductAttributes?>()

}