package com.example.re_wear.viewModel

import androidx.lifecycle.ViewModel
import com.bumptech.glide.load.engine.Resource
import com.example.re_wear.data.Product
import com.google.common.io.Resources
import com.google.firebase.Firebase
import com.google.firebase.FirebaseCommonRegistrar
import com.google.firebase.FirebaseException
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class MainCategoryViewModel @Inject constructor(
    private var firebase : Firebase
): ViewModel() {

    private val _specialProducts = MutableStateFlow<com.example.re_wear.util.Resource<List<Product>>>(com.example.re_wear.util.Resource.UnSpecified(""))
    val  specialProduct:StateFlow<com.example.re_wear.util.Resource<List<Product>>> = _specialProducts


}
