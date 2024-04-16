package com.example.healthlog

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.runtime.Composable


import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.healthlog.core.HealthLogApp
import com.example.healthlog.core.HealthogAppState
import com.example.healthlog.core.NavigationManager


import com.example.healthlog.ui.theme.SimpleLoginScreenTheme
import com.example.healthlog.ui_authentication.screens.forgotpassword.emailVerification.EmailInput
import com.example.healthlog.ui_authentication.screens.login.LoginScreen
import com.example.healthlog.ui_authentication.screens.signup.PhotoUploadScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val appState:HealthogAppState
            val navController = rememberNavController()
            val navigationManager = NavigationManager(navController)
//            HealthLogApp(navController, navigationManager)

PhotoUploadScreen(navigationManager)

        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SimpleLoginScreenTheme {

    }
}