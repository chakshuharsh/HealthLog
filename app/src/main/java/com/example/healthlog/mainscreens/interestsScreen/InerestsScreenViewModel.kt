package com.example.healthlog.mainscreens.interestsScreen

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.healthlog.networking.Article
import com.example.healthlog.networking.NewsResponse
import com.example.healthlog.networking.RetrofitInstance
import com.example.healthlog.networking.RetrofitInstance.newsInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class InterestsScreenViewModel(): ViewModel() {




    private val apiService= RetrofitInstance.newsInstance

    val news = MutableLiveData<NewsResponse?>()



    companion object {
        private const val API_KEY = "8b0c0bf0d3954af3a5a55bfa98867006"
    }

    @SuppressLint("SuspiciousIndentation")
    fun fetchNews( ) {
        Log.d("function called? ","Yes")
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val fetchedNews = apiService.getNews( "health", API_KEY,10)


                if(fetchedNews.isSuccessful){
                  val newsResponse=fetchedNews.body()

                    if (newsResponse != null) {
                        // Update the MutableLiveData with the fetched news
                        news.postValue(newsResponse)
                        Log.d("News fetched?", "Yes")
                    }


                }

                else{
                   Log.d("News fetched failed?","${fetchedNews.code()}")
                }




            }
            catch (e: IOException) {
                Log.d("IO exception?","YES")
            }
            catch (e:HttpException){
                Log.d("HTTP exception?","YES")
            }

        }

    }
}