package com.example.healthlog.ui_authentication.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.healthlog.core.HealthogAppState
import com.example.healthlog.core.NavigationManager
import com.example.healthlog.core.Screen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class LoginScreenViewModel(): ViewModel(){

    private val auth = HealthogAppState.auth



    fun login(email: String, password: String,navigationManager: NavigationManager){
viewModelScope.launch(Dispatchers.IO) {
    try {

        val authResult = auth.signInWithEmailAndPassword(email, password).await()
       if(authResult.user!=null) {

           HealthogAppState.isUserLoggedIn = true
navigationManager.navigateToHome()
       }
    else{
        HealthogAppState.isUserLoggedIn=false
       }
    }
    catch (e:Exception){
        HealthogAppState.isUserLoggedIn=false
    }
    }
    }



}