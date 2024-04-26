package com.example.healthlog.core


import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Source


object HealthogAppState{
    val auth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }


    val firestoredb: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() } // Lazy initialization
     val usersCollection = firestoredb.collection("Users")
    var isInternetConnected: Boolean = false
    var isUserLoggedIn: Boolean = auth.currentUser != null
    val user = auth.currentUser
    var uid = user?.uid ?: ""
val email = user?.email?:"email"












    // Initialize Firebase services asynchronously


}