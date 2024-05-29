package com.example.healthlog.networking

import retrofit2.Response

class NewsRepository(private val apiService: ApiService) {
    suspend fun getHealthNews(apiKey: String): Result<NewsResponse> {
        return try {
            val response = apiService.getNews(apiKey = apiKey)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }




    }
}
