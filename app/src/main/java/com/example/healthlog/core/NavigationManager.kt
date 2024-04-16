package com.example.healthlog.core

import androidx.navigation.NavHostController



// Class which handles app navigation
class NavigationManager(private val navController: NavHostController) {

    fun navigateToLogin() {
        navController.popBackStack(Screen.Login.route, inclusive = true)
        navController.navigate(Screen.Login.route)
    }

    fun navigateToSignup() {
        navController.popBackStack(Screen.Signup.route, inclusive = false)
        navController.navigate(Screen.Signup.route)
    }

    fun navigateToHome() {
        navController.navigate(Screen.Home.route)
    }

    fun navigateToEmailInput() {
        navController.popBackStack(Screen.EmailInput.route, inclusive = false)
        navController.navigate(Screen.EmailInput.route)
    }
}