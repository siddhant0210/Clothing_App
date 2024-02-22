package com.example.re_wear.api

import com.example.re_wear.data.SpecialProductsItems
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("/api/v1/products?offset=0&limit=10")
    fun getData() : Call<List<SpecialProductsItems>>
}