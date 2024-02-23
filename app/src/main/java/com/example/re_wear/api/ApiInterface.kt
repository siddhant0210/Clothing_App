package com.example.re_wear.api

import com.example.re_wear.data.SpecialProductsItems
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/products")
    fun getData(@Query("offset") offset:Int, @Query("limit") limit:Int) : Call<List<SpecialProductsItems>>
    @GET("/products")
    fun getDeal(@Query("offset") offset:Int, @Query("limit") limit: Int) : Call<List<SpecialProductsItems>>
    @GET("/products")
    fun getProduct(@Query("offset") offset:Int, @Query("limit") limit: Int) : Call<List<SpecialProductsItems>>
}