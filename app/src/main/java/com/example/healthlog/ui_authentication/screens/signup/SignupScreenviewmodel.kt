package com.example.healthlog.ui_authentication.screens.signup


import android.annotation.SuppressLint
import android.util.Log

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.healthlog.core.HealthogAppState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class SignupScreenViewModel() :ViewModel() {





     // Lazy initialization

    val auth = HealthogAppState.auth
     val usersCollection = HealthogAppState.usersCollection

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

                Log.d("collectino","IsSone")

                val uid = authResult.user?.uid


                    uid?.let { uid ->
                        val user = hashMapOf(
                            "name" to name,
                            "email" to email,
                        )
                        usersCollection.document(email).set(user).await()
                        Log.d("Database", "Database reference: ${usersCollection.document(email).path}")

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



