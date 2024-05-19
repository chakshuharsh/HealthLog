package com.example.healthlog

//import HealthogAppState
import android.os.Bundle
import android.util.Log

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.runtime.Composable


import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.healthlog.core.HealthLogApp
import com.example.healthlog.core.HealthogAppState

import com.example.healthlog.core.NavigationManager
import com.example.healthlog.mainscreens.features.FeatureListScreen
import com.example.healthlog.mainscreens.features.featuresScreen.BloodPressure.BloodPressureScreen
import com.example.healthlog.mainscreens.features.featuresScreen.Oxygen.OxygenScreen


import com.example.healthlog.ui.theme.SimpleLoginScreenTheme
import com.example.healthlog.ui_authentication.screens.login.LoginScreen
import com.example.healthlog.ui_authentication.screens.signup.PhotoUploadScreen
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val appState: HealthogAppState = HealthogAppState
            val navController = rememberNavController()
            val navigationManager = NavigationManager(navController)
//            HealthLogApp(navController, navigationManager)
            PhotoUploadScreen(navigationManager)
//            FeatureListScreen(navigationManager)
//BloodPressureScreen(navigationManager)
//OxygenScreen(navigationManager)
//BloodPressureScreen(navigationManager)
//LoginScreen(navigationManager)
        }
    }
}



