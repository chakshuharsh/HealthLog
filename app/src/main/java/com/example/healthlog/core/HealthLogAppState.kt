package com.example.healthlog.core


import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


object  HealthLogAppState{
     val auth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

     val firestoredb: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() } // Lazy initialization

    val usersCollection = firestoredb.collection("Users")

    var isInternetConnected: Boolean = false

    var isUserLoggedIn: Boolean = false

       val user = auth.currentUser

    var uid = user?.uid ?: "hello"

var useremail=user?.email?:"email"
    // Initialize Firebase services asynchronously
}

