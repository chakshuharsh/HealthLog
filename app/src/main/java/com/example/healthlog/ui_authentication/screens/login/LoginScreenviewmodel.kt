package com.example.healthlog.ui_authentication.screens.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.healthlog.core.HealthogAppState
import com.example.healthlog.core.NavigationManager

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class LoginScreenViewModel(navigationManager: NavigationManager): ViewModel(){

    private val auth = HealthogAppState.auth



    fun login(email: String, password: String,navigationManager: NavigationManager){
viewModelScope.launch(Dispatchers.IO) {
    try {

        val authResult = auth.signInWithEmailAndPassword(email, password).await()

        if(authResult.user!=null) {
val user =auth.currentUser
            HealthogAppState.uid=user?.uid?:""
           HealthogAppState.isUserLoggedIn = true

            Log.d("Login", "User logged in with UID: ${HealthogAppState.uid}")

            Log.d("Navigation", "Navigation is success")

       }
    else{
        HealthogAppState.isUserLoggedIn=false

       }
    }
    catch (e:Exception){
        HealthogAppState.isUserLoggedIn=false
    }
    }
        navigationManager.navigateToNewVaccineScreen()
    }



}