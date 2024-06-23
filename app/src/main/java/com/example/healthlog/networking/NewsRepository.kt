package com.example.healthlog.networking

import androidx.lifecycle.MutableLiveData
import retrofit2.Response

class NewsRepository(private val apiService: ApiService) {
    val API_KEY = ApiKeys.API_KEY
    suspend fun getHealthNews(apiKey: String): MutableLiveData<List<NewsResponse>> {

        val response = apiService.getNews("Health", "Fitness", "Disease",API_KEY,10)
return response



    }
}
