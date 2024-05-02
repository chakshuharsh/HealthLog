package com.example.healthlog.mainscreens.interestsScreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.healthlog.networking.Article
import com.example.healthlog.networking.NewsRepository
import com.example.healthlog.networking.RetrofitInstance
import kotlinx.coroutines.launch

class InerestsScreenViewModel(): ViewModel() {
    private val repository: NewsRepository = RetrofitInstance.newsRepository
    private val _news = MutableLiveData<List<Article>>()
    val news: LiveData<List<Article>> get() = _news



    fun fetchNews(country: String) {
        viewModelScope.launch {
            try {
                val fetchedNews = repository.getNews(country)
                Log.d("Good?","Yes")
                _news.value = fetchedNews
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

}