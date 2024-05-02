package com.example.healthlog.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


object RetrofitInstance {
    private const val BASE_URL = "https://newsapi.org/v2/"
    private const val API_KEY = "8b0c0bf0d3954af3a5a55bfa98867006"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()

   private  val apiService: ApiService = retrofit.create(ApiService::class.java)

    val newsRepository: NewsRepository = NewsRepository(apiService)
}
