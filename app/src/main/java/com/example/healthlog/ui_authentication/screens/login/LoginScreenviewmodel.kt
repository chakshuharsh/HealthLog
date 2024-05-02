package com.example.healthlog.ui_authentication.screens.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.healthlog.core.HealthLogAppState
import com.example.healthlog.core.NavigationManager

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class LoginScreenViewModel(): ViewModel(){


    private val auth = HealthLogAppState.auth

    fun login(email: String, password: String,navigationManager: NavigationManager){


        viewModelScope.launch(Dispatchers.IO) {
    try {
        val authResult = auth.signInWithEmailAndPassword(email, password).await()

        if(authResult.user!=null) {
val user = auth.currentUser
HealthLogAppState.uid=user?.uid?:"hello"
            HealthLogAppState.isUserLoggedIn=true
               HealthLogAppState.useremail = email

            Log.d("Login", "User logged in with UID: ${HealthLogAppState.uid}")





       }
    else{
        HealthLogAppState.isUserLoggedIn=false

       }
    }
    catch (e:Exception){
        HealthLogAppState.isUserLoggedIn=false
        Log.d("login?","login fail")
    }

        }

        navigationManager.navigateToNewVaccineScreen()


       }

fun returnEmail(email:String):String{
    return email
}

}