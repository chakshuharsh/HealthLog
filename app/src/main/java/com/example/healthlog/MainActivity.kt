package com.example.healthlog


import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent


import androidx.navigation.compose.rememberNavController
import com.example.healthlog.core.HealthLogApp


import com.example.healthlog.core.NavigationManager
import com.example.healthlog.core.HealthLogAppState


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val navController = rememberNavController()
            val navigationManager = NavigationManager(navController)
            HealthLogApp(navController, navigationManager, HealthLogAppState)

        }
    }
}



