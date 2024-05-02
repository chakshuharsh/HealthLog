package com.example.healthlog.core

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


import com.example.healthlog.mainscreens.homeScreen.HomeScreen
import com.example.healthlog.mainscreens.interestsScreen.InterestsScreen
import com.example.healthlog.mainscreens.features.FeatureListScreen
import com.example.healthlog.mainscreens.features.featuresScreen.allergy.AllergyScreen
import com.example.healthlog.mainscreens.features.featuresScreen.bloodPressure.BloodPressureScreen
import com.example.healthlog.mainscreens.features.featuresScreen.oxygen.OxygenScreen
import com.example.healthlog.mainscreens.features.featuresScreen.vaccine.NewVaccineScreen

import com.example.healthlog.ui_authentication.screens.forgotpassword.emailVerification.EmailInput
import com.example.healthlog.ui_authentication.screens.login.LoginScreen
import com.example.healthlog.ui_authentication.screens.signup.SignupScreen

sealed class Screen(val route: String) {
    data object Login : Screen("login")
    data object Signup : Screen("signup")

    data object EmailInput:Screen("emailInput")
    data object ProfileUpload:Screen("profileUpload")
    data object HomeScreen:Screen("homescreen")
    data object InterestsScreen:Screen("interestscreen")
    data object FeatureScreen:Screen("featurescreen")

    data object NewVaccineScreen:Screen("newvaccinescreen")

    data object AllergyScreen:Screen("allergyscreen")

    data object  OxygenScreen:Screen("oxygenscreen")

    data object  BloodPressureScreen:Screen("bloodpressurescreen")

}


@Composable
fun HealthLogApp(navController: NavHostController,navigationManager: NavigationManager,appState:HealthLogAppState){

    val startDestination = if(appState.isUserLoggedIn) Screen.HomeScreen.route else Screen.Login.route

        NavHost(navController, startDestination = startDestination) {
            composable(Screen.Login.route) {
                LoginScreen(navigationManager)
            }
            composable(Screen.Signup.route) {
                SignupScreen(navigationManager)
            }

            composable(Screen.EmailInput.route){
                EmailInput(navigationManager)
            }
//            composable(Screen.ProfileUpload.route){
//                PhotoUploadScreen(HealthLogAppState,navigationManager)
//            }
            composable(Screen.HomeScreen.route){
                HomeScreen(navigationManager)
            }
            composable(Screen.FeatureScreen.route){
                FeatureListScreen(navigationManager)
            }
            composable(Screen.InterestsScreen.route){
                InterestsScreen(navigationManager)
            }
            composable(Screen.NewVaccineScreen.route){
                NewVaccineScreen(navigationManager)
            }
            composable(Screen.AllergyScreen.route){
                AllergyScreen(navigationManager)
            }
            composable(Screen.OxygenScreen.route){
                OxygenScreen(navigationManager)
            }
            composable(Screen.BloodPressureScreen.route){
                BloodPressureScreen(navigationManager)
            }



        }
    }









