package com.example.healthlog.mainscreens.commonui

import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBarScrollBehavior
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.healthlog.core.NavigationManager



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenTopBar(

    title:String, // pass this title as user's name
    scrollBehavior: TopAppBarScrollBehavior,
//    onBackClick:()->Unit,
//    onMenuClick:()-> Unit
    navigationManager: NavigationManager
){
    val lightBlue = Color(0xFF4169E1)
    CenterAlignedTopAppBar(
        title = {
        Text(
          text = title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

    },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = lightBlue,
            titleContentColor = Color.White,
        ),
        navigationIcon = {
            IconButton(onClick = { navigationManager.navigateToBackStack() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Icon for back navigation",

                )
            }
        },

        actions = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu Icons" // can be replaced with the profile photo of user
                )
            }
        },
        scrollBehavior = scrollBehavior,
        modifier = Modifier.height(65.dp)
        )


}