package com.example.nativelab

import com.example.nativelab.models.Food
import retrofit2.Call
import retrofit2.http.GET

interface MyApi {
    @GET("/foods")
    fun getAllFoods(): Call<List<Food>>
}