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
    val topBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val viewModel = remember { InerestsScreenViewModel() }

    val country = remember { mutableStateOf("us") } // Default country
    val observer = Observer<List<Article>> { news ->
        // Handle changes in the LiveData
        val firstArticleTitle = news?.firstOrNull()?.description
        if (firstArticleTitle != null) {
            Log.d("Exists?","YES")
            // Update UI or perform other actions with the first article title
        } else {
            // Handle the case where there are no articles
            Log.d("Exists?","NO")
        }
        // For example, update UI or perform other actions
        // Here, you can update the state or perform any necessary operations
    }
//    val news by viewModel.news.observeForever(emptyList<Article>())
//val isNewsEmpty = news.value?.isNotEmpty()
    val news =viewModel.news.observeForever(observer)

    DisposableEffect(key1 = viewModel) {
        viewModel.news.observeForever(observer)

        onDispose {
            viewModel.news.removeObserver(observer)
        }
    }

    Scaffold(
        topBar = {
//            MainScreenTopBar("Username", scrollBehavior = topBarScrollBehavior,navigationManager)
        topBarForFeatures(navigationManager)
                 },
        bottomBar = {
            BottomBar(navigationManager)
        }
    ) {innerPadding->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = "hello this is Interests screen")

        Button(
            onClick = {viewModel.fetchNews(country.value)}
        ){
            Text(
                text = "Fetch"
            )
        }


            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
//                Text(
//                    text = "First Article Title: ${firstArticleTitle ?: "Loading..."}",
//                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier.padding(16.dp)
//                )
            }


        }
    }
}



@Composable
fun NewsItem(article: Article) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = article.title, fontWeight = FontWeight.Bold)
        if (!article.description.isNullOrBlank()) {
            Text(text = article.description, fontWeight = FontWeight.Normal)
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}