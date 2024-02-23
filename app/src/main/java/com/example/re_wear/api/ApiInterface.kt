package com.example.re_wear.api

import com.example.re_wear.data.SpecialProductsItems
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("api/v1/products")
    fun getData(@Query("offset") offset:Int, @Query("limit") limit:Int) : Call<List<SpecialProductsItems>>
}