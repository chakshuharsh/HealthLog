package com.example.healthlog.networking

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    suspend fun getNews(
        @Query("country") country: String,
        @Query("8b0c0bf0d3954af3a5a55bfa98867006") apiKey: String
    ): NewsResponse
}