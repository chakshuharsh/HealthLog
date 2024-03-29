package com.example.healthlog.ui_authentication.screens.signup

//import androidx.compose.ui.tooling.data.EmptyGroup.name
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class SignupScreenviewmodel() :ViewModel(){

    private val auth = FirebaseAuth.getInstance()
    private val firestore= FirebaseFirestore.getInstance()
    private val usersCollection = firestore.collection("users")


    fun signUp(email: String, password: String) {
        viewModelScope.launch {
            try {

              val authResult =  auth.createUserWithEmailAndPassword(email, password).await()



            } catch (e: Exception) {


            }
        }
    }

}