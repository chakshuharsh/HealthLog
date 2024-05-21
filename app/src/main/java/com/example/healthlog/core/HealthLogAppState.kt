package com.example.healthlog.core


import android.content.Context
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


object  HealthLogAppState{
    val auth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

     val firestoredb: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() } // Lazy initialization

    val usersCollection = firestoredb.collection("Users")

    var isInternetConnected = MutableLiveData<Boolean>()
var isInternetAvailable= isInternetConnected.value
    var isUserLoggedIn: Boolean = false

       val user = auth.currentUser

    var uid = user?.uid ?: "hello"

var useremail=user?.email?:"email"
    // Initialize Firebase services asynchronously




}

