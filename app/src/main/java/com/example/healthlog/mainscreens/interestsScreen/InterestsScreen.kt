package com.example.healthlog.mainscreens.interestsScreen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import com.example.healthlog.core.HealthLogAppState
import com.example.healthlog.core.NavigationManager
import com.example.healthlog.mainscreens.commonui.BottomBar
import com.example.healthlog.mainscreens.commonui.topBarForFeatures
import com.example.healthlog.networking.Article

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InterestsScreen( navigationManager: NavigationManager){
   val viewModel = remember { InterestsScreenViewModel() }


    val newsList = remember { mutableStateOf<List<Article>>(emptyList()) } // Store the fetched news articles

    viewModel.news.observeForever { response ->
Log.d("data success?","$response")
        newsList.value = response?.articles?: emptyList()


    }

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
            onClick = {viewModel.fetchNews()}
        ){
            Text(
                text = "Fetch"
            )
        }


            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {newsList.value.forEach { article ->
                NewsItem(article = article)
            }
            }


        }
    }
}



@Composable
fun NewsItem(article: Article) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = article.title.toString(), fontWeight = FontWeight.Bold)
        if (!article.description.isNullOrBlank()) {
            Text(text = article.title.toString(), fontWeight = FontWeight.Normal)
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}