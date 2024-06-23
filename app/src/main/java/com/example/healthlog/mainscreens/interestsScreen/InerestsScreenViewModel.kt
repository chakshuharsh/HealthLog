package com.example.healthlog.mainscreens.interestsScreen

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.healthlog.networking.Article
import com.example.healthlog.networking.NewsRepository
import com.example.healthlog.networking.NewsResponse
import com.example.healthlog.networking.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class InterestsScreenViewModel(): ViewModel() {



private val repository:NewsRepository = NewsRepository(RetrofitClient.apiService)




    companion object {
        private const val API_KEY = "8b0c0bf0d3954af3a5a55bfa98867006"
    }

    @SuppressLint("SuspiciousIndentation")
    private val _news = MutableLiveData<List<NewsResponse>>(emptyList())
    val news: MutableLiveData<List<NewsResponse>> get() = _news

    fun fetchHealthNews() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getHealthNews(API_KEY)
            _news.value = result.value
        }
    }
}