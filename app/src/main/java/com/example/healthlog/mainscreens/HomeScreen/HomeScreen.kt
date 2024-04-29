package com.example.healthlog.mainscreens.HomeScreen



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable

import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

import com.example.healthlog.core.HealthogAppState


import com.example.healthlog.core.NavigationManager
import com.example.healthlog.mainscreens.commonui.BottomBar
import com.example.healthlog.mainscreens.commonui.MainScreenTopBar
import com.example.healthlog.mainscreens.commonui.topBarForFeatures


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navigationManager: NavigationManager){
    val topBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
val uid = HealthogAppState.uid
val viewModel:HomeScreenViewModel = remember{HomeScreenViewModel()}






// after signup we have to verify the user using email verification and then login or may be home.svg screen and in home.svg screen give a button to logout
    // design a bottom bar for the app and in the second icons place the features which stores the data
    // home.svg  screen would display the recent data -> medication, docs, everythin else and the third section will be about sharing that data I guesss but we cann shif that to second one only
Scaffold(
    topBar = {
//        MainScreenTopBar(title ="userName", scrollBehavior = topBarScrollBehavior,navigationManager)
    topBarForFeatures(navigationManager)
             },

    bottomBar = {
        BottomBar(navigationManager)
    }
) {innerPadding->
    Column(modifier = Modifier.padding(innerPadding)) {
        Text(text = "hello this is home screen")
    }
    }


    }
