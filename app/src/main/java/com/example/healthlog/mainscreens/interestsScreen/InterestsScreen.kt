package com.example.healthlog.mainscreens.interestsScreen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.healthlog.core.HealthLogAppState
import com.example.healthlog.core.NavigationManager
import com.example.healthlog.mainscreens.commonui.BottomBar
import com.example.healthlog.mainscreens.commonui.topBarForFeatures
import com.example.healthlog.networking.Article
import com.example.healthlog.networking.NewsResponse 

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InterestsScreen( navigationManager: NavigationManager){
   val viewModel = remember { InterestsScreenViewModel() }
    val newsResponse by viewModel.news.observeAsState()


   Log.d("InterestsScreen", "newsResponse: $newsResponse")



    Scaffold(
        topBar = {
             topBarForFeatures(navigationManager)
                 },
        bottomBar = {
            BottomBar(navigationManager)
        }
    ) {innerPadding->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = "hello this is Interests screen")

        Button(
            onClick = {viewModel.fetchHealthNews()}
        ){
            Text(
                text = "Fetch"
            )
        }


            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                items(newsResponse?.size?:0){index->
                    val listOfArticle = newsResponse?.get(index)?.articles
                   val article = listOfArticle?.get(index)
NewsItem(article)

                }
            }






        }
    }
}



@Composable
fun NewsItem(article: Article?) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = article?.title.toString(), fontWeight = FontWeight.Bold)
        if (!article?.description.isNullOrBlank()) {
            Text(text = article?.title.toString(), fontWeight = FontWeight.Normal)
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}