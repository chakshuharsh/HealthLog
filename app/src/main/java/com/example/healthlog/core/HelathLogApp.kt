package com.example.healthlog.core

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.healthlog.mainscreens.HomeScreen.HomeScreen
import com.example.healthlog.ui_authentication.screens.forgotpassword.emailVerification.EmailInput
import com.example.healthlog.ui_authentication.screens.login.LoginScreen
import com.example.healthlog.ui_authentication.screens.signup.PhotoUploadScreen
import com.example.healthlog.ui_authentication.screens.signup.SignupScreen

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Signup : Screen("signup")
    object Home : Screen("home")
    object EmailInput:Screen("emailInput")
    object ProfileUpload:Screen("profileUpload")
}


@Composable
fun HealthLogApp(navController: NavHostController,navigationManager: NavigationManager){

        NavHost(navController, startDestination = Screen.Login.route) {
            composable(Screen.Login.route) {
                LoginScreen(navigationManager)
            }
            composable(Screen.Signup.route) {
                SignupScreen(navigationManager)
            }
            composable(Screen.Home.route) {
                HomeScreen(navigationManager)
            }
            composable(Screen.EmailInput.route){
                EmailInput(navigationManager)
            }
            composable(Screen.ProfileUpload.route){
                PhotoUploadScreen(navigationManager)
            }

        }
    }









