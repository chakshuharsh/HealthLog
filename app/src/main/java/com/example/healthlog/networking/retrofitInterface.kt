package com.example.healthlog.networking


import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

 const val BASE_URL = "https://newsapi.org"
const val API_KEY =ApiKeys.API_KEY

interface ApiService {
    @GET("v2/everything")
    suspend fun getNews(
        @Query("q") query: String = "health",
        @Query("apiKey") apiKey: String,
        @Query("pageSize") pageSize: Int = 10
    ): NewsResponse
}



//object RetrofitInstance{
//
//    val newsInstance:ApiService
//
//    init{
//        val retrofit= Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        newsInstance = retrofit.create(ApiService::class.java)
//
//    }
//
//}

object RetrofitClient {
    private const val BASE_URL = "https://newsapi.org/"

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}

