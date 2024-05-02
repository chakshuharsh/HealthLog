package com.example.healthlog.mainscreens.features.featuresScreen.vaccine

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthlog.core.HealthLogAppState
import com.google.firebase.firestore.SetOptions.merge
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.sql.Timestamp

class VaccineScreenViewModel():ViewModel() {

fun saveUserData( selectedDate:Long, vaccineName:String) {
    val usersCollection = HealthLogAppState.usersCollection




    Log.d("Functioncalled?", "Yes")
    viewModelScope.launch(Dispatchers.IO) {

val userEmail=HealthLogAppState.useremail


Log.d("email?", userEmail)
        try {

            Log.d("Firestore?", "Yes")

            val userDocRef = usersCollection.document(userEmail)

            Log.d("DocRef?", "Yes")

            val timeStamp = Timestamp(selectedDate)

            Log.d("TimeStamp?", "Yes")

            val vaccine = hashMapOf(
                "Name" to vaccineName,
                "Date" to timeStamp
            )
            Log.d("vaccinehashmap?", "Yes")


            userDocRef.collection("Vaccines").document().set(vaccine,merge()).await()
            Log.d("DocSuccess", "DocumentSnapshot successfully written!")

        } catch (e: Exception) {
            Log.w("DocFailure", "Error writing document")
        }

    }
}


//         fun getUserName(email: String,callback: (String) -> Unit ){
//             var userName = "Use"
//             viewModelScope.launch(Dispatchers.IO) {
//                 Log.d("view model  on","yes")
//                  val db= HealthLogAppState.firestoredb
//                 Log.d("db on","yes")
//                     try {
//                         val documentSnapshot = db.collection("Users").document(email).get().await()
//                         Log.d("doc on","yes")
//                         userName  = documentSnapshot.getString("name") ?: "hello"
//                         callback(userName)
//                         Log.d("userName", "$userName is received")
//                     }
//                     catch (e: Exception) {
//                         // Handle error
//                         callback("hello")
//                     }
//                 }
//
//
//
//
//
//         }










}