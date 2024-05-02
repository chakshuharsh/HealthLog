package com.example.healthlog.networking

class NewsRepository (private val apiService: ApiService) {

    suspend fun getNews(country: String): List<Article> {
        return apiService.getNews(country, API_KEY).articles
    }

    companion object {
        private const val API_KEY = "8b0c0bf0d3954af3a5a55bfa98867006"
    }
}