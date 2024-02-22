package com.example.re_wear.data

data class SpecialProductsItems(
    val category: Category,
    val description: String,
    val id: Int,
    val images: List<String>,
    val price: Double,
    val title: String
)