package com.example.healthlog.core

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


import com.example.healthlog.mainscreens.HomeScreen.HomeScreen
import com.example.healthlog.mainscreens.InterestsScreen.InterestsScreen
import com.example.healthlog.mainscreens.features.FeatureListScreen
import com.example.healthlog.mainscreens.features.featuresScreen.Allergy.AllergyScreen
import com.example.healthlog.mainscreens.features.featuresScreen.BloodPressure.BloodPressureScreen
import com.example.healthlog.mainscreens.features.featuresScreen.Oxygen.OxygenScreen
import com.example.healthlog.mainscreens.features.featuresScreen.Vaccine.NewVaccineScreen

import com.example.healthlog.ui_authentication.screens.forgotpassword.emailVerification.EmailInput
import com.example.healthlog.ui_authentication.screens.login.LoginScreen
import com.example.healthlog.ui_authentication.screens.signup.PhotoUploadScreen
import com.example.healthlog.ui_authentication.screens.signup.SignupScreen

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Signup : Screen("signup")

    object EmailInput:Screen("emailInput")
    object ProfileUpload:Screen("profileUpload")
    object HomeScreen:Screen("homescreen")
    object InterestsScreen:Screen("interestscreen")
    object FeatureScreen:Screen("featurescreen")

    object NewVaccineScreen:Screen("newvaccinescreen")

    object AllergyScreen:Screen("allergyscreen")

    object  OxygenScreen:Screen("oxygenscreen")

    object  BloodPressureScreen:Screen("bloodpressurescreen")

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

            composable(Screen.EmailInput.route){
                EmailInput(navigationManager)
            }
            composable(Screen.ProfileUpload.route){
                PhotoUploadScreen(navigationManager)
            }
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









