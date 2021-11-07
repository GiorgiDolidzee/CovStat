package com.example.midexam.network

import com.example.midexam.model.GeorgiaModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("cases")
    suspend fun getCovidInfo(@Query("country") country: String): Response<GeorgiaModel>
}