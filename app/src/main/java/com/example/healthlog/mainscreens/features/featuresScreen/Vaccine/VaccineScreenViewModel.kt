package com.example.healthlog.mainscreens.features.featuresScreen.Vaccine

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthlog.core.HealthogAppState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class VaccineScreenViewModel():ViewModel() {



         fun getUserName(email: String,callback: (String) -> Unit ){
             var userName = "Use"
             viewModelScope.launch(Dispatchers.IO) {
                 Log.d("view model  on","yes")
                  val db= HealthogAppState.firestoredb
                 Log.d("db on","yes")
                     try {
                         val documentSnapshot = db.collection("Users").document(email).get().await()
                         Log.d("doc on","yes")
                         userName  = documentSnapshot.getString("name") ?: "hello"
                         callback(userName)
                         Log.d("userName", "$userName is received")
                     }
                     catch (e: Exception) {
                         // Handle error
                         callback("hello")
                     }
                 }





         }
}