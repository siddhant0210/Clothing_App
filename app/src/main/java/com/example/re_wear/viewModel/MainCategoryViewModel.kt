package com.example.re_wear.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.example.re_wear.data.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainCategoryViewModel @Inject constructor(
    private var fireStore: FirebaseFirestore
) : ViewModel() {

    private val _specialProducts =
        MutableStateFlow<com.example.re_wear.util.Resource<List<Product>>>(
            com.example.re_wear.util.Resource.UnSpecified()
        )
    val specialProduct: StateFlow<com.example.re_wear.util.Resource<List<Product>>> =
        _specialProducts

    init {
        fetchSpecialProduct()
    }

    private fun fetchSpecialProduct() {
        viewModelScope.launch {
            _specialProducts.emit((com.example.re_wear.util.Resource.Loading()))
        }

        fireStore.collection("Products").whereEqualTo("category", "Men").get()
            .addOnSuccessListener { result ->
                val specialProductList = result.toObjects(Product::class.java)
                viewModelScope.launch {
                    _specialProducts.emit(
                        com.example.re_wear.util.Resource.Success(
                            specialProductList
                        )
                    )
                }
            }
            .addOnFailureListener {
                viewModelScope.launch {
                    _specialProducts.emit(com.example.re_wear.util.Resource.Error(it.message.toString()))
                }
            }
    }
}
