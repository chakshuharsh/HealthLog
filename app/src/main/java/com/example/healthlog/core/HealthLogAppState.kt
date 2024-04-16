package com.example.healthlog.core

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore



object HealthogAppState{
    val auth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

    val firestoredb: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() } // Lazy initialization
     val usersCollection = firestoredb.collection("Users")
    var isInternetConnected: Boolean = false
    var isUserLoggedIn: Boolean = auth.currentUser != null

    // what about mutableStateof()n for above variable is UserLoggedIn



}