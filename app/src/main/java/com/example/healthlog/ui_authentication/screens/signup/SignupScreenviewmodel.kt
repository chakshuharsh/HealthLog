package com.example.healthlog.ui_authentication.screens.signup


import android.annotation.SuppressLint
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.healthlog.core.HealthogAppState
import com.example.healthlog.core.Screen
import com.google.firebase.auth.FirebaseAuthException
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class SignupScreenViewModel() :ViewModel() {


    private val auth = HealthogAppState.auth


    private val usersCollection = HealthogAppState.usersCollection

    var isUserExists: Boolean = false



    @SuppressLint("SuspiciousIndentation")
    fun signUp(
        email: String,
        password: String,
        name: String
    ) { // check whether user already exists or not
        viewModelScope.launch(Dispatchers.IO) {
            try {


                val authResult = auth.createUserWithEmailAndPassword(email, password).await()


                val uid = authResult.user?.uid


                    uid?.let { uid ->
                        val user = hashMapOf(
                            "name" to name,
                            "email" to email,
                        )
                        usersCollection.document(email).set(user).await()

                    }

                    HealthogAppState.isUserLoggedIn = authResult.user != null






            } catch (e: Exception) {


            }
        }
    }



    fun doesUserExist(email: String,password: String,name: String){

        viewModelScope.launch {

            val userDocument =  usersCollection.document(email).get().await()

            if(userDocument.exists()){
                isUserExists = true
            }
            else{
                isUserExists = false
                signUp(email,password,name)
            }



        }


    }





}



