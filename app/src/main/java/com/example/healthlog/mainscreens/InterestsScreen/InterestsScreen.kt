package com.example.healthlog.mainscreens.InterestsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.healthlog.core.NavigationManager
import com.example.healthlog.mainscreens.commonui.BottomBar
import com.example.healthlog.mainscreens.commonui.MainScreenTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InterestsScreen(navigationManager: NavigationManager){
    val topBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        topBar = {
            MainScreenTopBar("Username", scrollBehavior = topBarScrollBehavior,navigationManager)
        },
        bottomBar = {
            BottomBar(navigationManager)
        }
    ) {innerPadding->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = "hello this is Interests screen")
        }
    }
}