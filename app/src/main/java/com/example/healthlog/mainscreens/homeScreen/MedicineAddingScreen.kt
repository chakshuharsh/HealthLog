package com.example.healthlog.mainscreens.homeScreen


import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.padding

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp






@Composable
fun AddingScreen() {
    Scaffold(
        topBar = { TopBar("Adding") },
        containerColor = Color(0xFFE6F0FA)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
    }


}

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TopBar(title: String) {
        CenterAlignedTopAppBar(

            title = { Text(text = title) },
            navigationIcon = {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack, // Replace with your back icon resource
                    contentDescription = "Back",
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
            },



        )

    }



