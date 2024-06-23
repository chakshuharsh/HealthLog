package com.example.healthlog.core

import PrescriptionScreen
import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.healthlog.data.UserLoginSession
import com.example.healthlog.mainscreens.ProfileScreen


import com.example.healthlog.mainscreens.homeScreen.HomeScreen
import com.example.healthlog.mainscreens.interestsScreen.InterestsScreen
import com.example.healthlog.mainscreens.features.FeatureListScreen
import com.example.healthlog.mainscreens.features.featuresScreen.allergy.AllergyScreen
import com.example.healthlog.mainscreens.features.featuresScreen.allergy.PreviousAllergyScreen
import com.example.healthlog.mainscreens.features.featuresScreen.bloodPressure.BloodPressureScreen
import com.example.healthlog.mainscreens.features.featuresScreen.bloodPressure.PreviousBloodPressureScreen
import com.example.healthlog.mainscreens.features.featuresScreen.labreport.LabReportScreen
import com.example.healthlog.mainscreens.features.featuresScreen.oxygen.OxygenScreen
import com.example.healthlog.mainscreens.features.featuresScreen.oxygen.PreviousOxygenScreen
import com.example.healthlog.mainscreens.features.featuresScreen.vaccine.NewVaccineScreen
import com.example.healthlog.mainscreens.features.featuresScreen.vaccine.PreviousVaccineScreen

import com.example.healthlog.ui_authentication.screens.forgotpassword.emailVerification.EmailInput
import com.example.healthlog.ui_authentication.screens.login.LoginScreen
import com.example.healthlog.ui_authentication.screens.signup.SignupScreen
import com.google.firebase.logger.Logger
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

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

    data object  PreviousVaccineScreen:Screen("previousvaccinescreen")

    data object  PreviousOxygenScreen:Screen("previousoxygencreen")

    data object  PreviousAllergyScreen:Screen("previousallergyscreen")

    data object  PreviousBloodPressureScreen:Screen("previousbloodpressurescreen")

    data object PrescriptionScreen:Screen("prescriptionScreen")

    data object LabReportScreen:Screen("labReportScreen")

    data object ProfileScreen:Screen("ProfileScreen")



}


@SuppressLint("SuspiciousIndentation")
@Composable
fun HealthLogApp(navController: NavHostController,navigationManager: NavigationManager,appState:HealthLogAppState){
    Log.d("working fine 0", "Yes")
     val healthLogReleaseApplication = HealthLogAppState.healthReleaseApplication
    Log.d("working fine 1", "Yes")
     val userLoginSession=healthLogReleaseApplication.userLoginSession
    Log.d("working fine 2", "Yes")
        val coroutineScope = rememberCoroutineScope()
    val startDestination = remember { mutableStateOf(Screen.Login.route) }
    LaunchedEffect(Unit) {
        coroutineScope.launch {
            userLoginSession.isUserLoggedIn.collect { isUserLoggedIn ->
                startDestination.value = if (isUserLoggedIn) {
                    Screen.HomeScreen.route
                } else {
                    Screen.Login.route
                }

            }
        }
    }


        NavHost(navController, startDestination = startDestination.value){
            composable(Screen.Login.route) {
                LoginScreen(navigationManager)
            }
            composable(Screen.Signup.route) {
                SignupScreen(navigationManager)
            }

            composable(Screen.EmailInput.route){
                EmailInput(navigationManager)
            }
            composable(Screen.PreviousVaccineScreen.route){
                PreviousVaccineScreen(navigationManager)
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
            composable(Screen.PreviousBloodPressureScreen.route){
                PreviousBloodPressureScreen(navigationManager)
            }
            composable(Screen.PreviousOxygenScreen.route){
                PreviousOxygenScreen(navigationManager)
            }
            composable(Screen.PreviousAllergyScreen.route){
                PreviousAllergyScreen(navigationManager)
            }
            composable(Screen.PrescriptionScreen.route){
                PrescriptionScreen(navigationManager)
            }
            composable(Screen.LabReportScreen.route) {
                LabReportScreen(navigationManager)
            }
            composable(Screen.ProfileScreen.route){
                ProfileScreen(navigationManager)
            }
        }
    }









