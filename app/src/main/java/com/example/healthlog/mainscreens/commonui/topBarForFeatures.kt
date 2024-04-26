package com.example.healthlog.mainscreens.commonui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.healthlog.core.NavigationManager


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topBarForFeatures(
    navigationManager: NavigationManager
){
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    val lightBlue = Color(0xFF4169E1)


CenterAlignedTopAppBar(
    colors = TopAppBarDefaults.topAppBarColors(
        containerColor = lightBlue,
        titleContentColor = Color.White,
    ),
    modifier = Modifier.height(50.dp),


        title = {
            Text(
                text = "Username",
                color = Color.White,

            )
        },

        navigationIcon = {
            IconButton(onClick = { navigationManager.navigateToBackStack() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Localized description"
                )
            }
        },

    )


}



