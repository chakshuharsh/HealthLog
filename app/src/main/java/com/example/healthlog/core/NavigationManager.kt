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

    fun navigateToPreviousVaccineScreen() {
        navController.popBackStack(Screen.PreviousVaccineScreen.route, inclusive = false)
        navController.navigate(Screen.PreviousVaccineScreen.route)
    }

    fun navigateToEmailInput() {
        navController.popBackStack(Screen.EmailInput.route, inclusive = false)
        navController.navigate(Screen.EmailInput.route)
    }

    fun navigateToFeatureScreen(){
        navController.popBackStack(Screen.FeatureScreen.route, inclusive = false)
        navController.navigate(Screen.FeatureScreen.route)
    }

    fun navigateToHomeScreen(){
        navController.popBackStack(Screen.HomeScreen.route, inclusive = false)
        navController.navigate(Screen.HomeScreen.route)
    }

    fun navigateToInterestsScreen(){
        navController.popBackStack(Screen.InterestsScreen.route, inclusive = false)
        navController.navigate(Screen.InterestsScreen.route)
    }

    fun navigateToBackStack(){
        navController.popBackStack()
    }

    fun navigateToNewVaccineScreen(){
        navController.popBackStack(Screen.NewVaccineScreen.route, inclusive = false)
        navController.navigate(Screen.NewVaccineScreen.route)
    }

    fun navigateToAllergyScreen(){
        navController.popBackStack(Screen.AllergyScreen.route, inclusive = false)
        navController.navigate(Screen.AllergyScreen.route)

    }

    fun navigateToOxygenScreen(){
        navController.popBackStack(Screen.OxygenScreen.route, inclusive = false)
        navController.navigate(Screen.OxygenScreen.route)

    }

    fun navigateToBloodPressureScreen(){
        navController.popBackStack(Screen.BloodPressureScreen.route, inclusive = false)
        navController.navigate(Screen.BloodPressureScreen.route)

    }

    fun navigateToPreviousOxygenScreen() {
        navController.popBackStack(Screen.PreviousOxygenScreen.route, inclusive = false)
        navController.navigate(Screen.PreviousOxygenScreen.route)


    }


    fun navigateToPreviousAllergyScreen() {
        navController.popBackStack(Screen.PreviousAllergyScreen.route, inclusive = false)
        navController.navigate(Screen.PreviousAllergyScreen.route)
    }

    fun navigateToPreviousBloodPressureScreen(){
        navController.popBackStack(Screen.PreviousBloodPressureScreen.route, inclusive = false)
        navController.navigate(Screen.PreviousBloodPressureScreen.route)

    }

}