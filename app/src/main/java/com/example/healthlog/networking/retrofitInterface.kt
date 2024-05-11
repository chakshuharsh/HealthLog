package com.example.healthlog.networking


import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

 const val BASE_URL = "https://newsapi.org"
const val API_KEY =ApiKeys.API_KEY

interface ApiService {
    @GET("/v2/everything?apiKey=${API_KEY}&Size=10")
    suspend fun getNews(


        @Query("category") query: String,
        @Query("apiKey") apiKey: String,
        @Query("pageSize") pageSize: Int

    ): Response<NewsResponse>

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


object RetrofitInstance{
    val newsInstance:ApiService by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)


    }
}
