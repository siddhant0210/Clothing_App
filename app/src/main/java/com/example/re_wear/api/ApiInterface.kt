package com.example.re_wear.api

import com.example.re_wear.data.SpecialProductsItems
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("/products")
    fun getData() : Call<List<SpecialProductsItems>>
}