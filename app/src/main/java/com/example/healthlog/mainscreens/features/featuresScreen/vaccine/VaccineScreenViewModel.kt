package com.example.healthlog.mainscreens.features.featuresScreen.vaccine

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthlog.core.HealthLogAppState
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.SetOptions.merge
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.sql.Timestamp

class VaccineScreenViewModel():ViewModel() {
    private val usersCollection = HealthLogAppState.usersCollection
    private val userEmail=HealthLogAppState.useremail // this has changed

    private val _vaccineData = MutableStateFlow<List<DocumentSnapshot>>(emptyList())
    private val vaccineData: StateFlow<List<DocumentSnapshot>> = _vaccineData


    fun saveVaccineData( selectedDate:Long, vaccineName:String) {

    val userDocRef = usersCollection.document(userEmail)



    val timeStamp = Timestamp(selectedDate)

    Log.d("TimeStamp?", "Yes")

    val vaccine = hashMapOf(
        "Name" to vaccineName,
        "Date" to timeStamp,
        "Name" to "User"
    )
    Log.d("vaccinehashmap?", "Yes")
    Log.d("email?", userEmail)

    viewModelScope.launch(Dispatchers.IO) {

        try {

            userDocRef.collection("Vaccines").document().set(vaccine,merge()).await()
            Log.d("DocSuccess", "DocumentSnapshot successfully written!")

        } catch (e: Exception) {
            Log.w("DocFailure", "Error writing document")
        }

    }
}

fun getVaccineData(): StateFlow<List<DocumentSnapshot>> {

viewModelScope.launch {
        try {
            val result = usersCollection.document(userEmail).collection("Vaccines")
                .orderBy("Date", Query.Direction.DESCENDING).get().await()

            if (result.documents.size != _vaccineData.value.size) {
                _vaccineData.value = result.documents
            }
//            _vaccineData.value = result.documents
        } catch (exception: Exception) {
            Log.d("Data fetching error?", "Error getting documents: ", exception)
        }
    }
    return vaccineData
}

    fun deleteVaccineData(documentId: String) {
        viewModelScope.launch {

            try {
                usersCollection.document(userEmail).collection("Vaccines").document(documentId)
                    .delete()
                _vaccineData.value = _vaccineData.value.filterNot { it.id == documentId }
// creates a new list with the deleted item removed by using the filterNot function and the document ID to filter out the item with the matching ID.

            }
            catch (exception: Exception) {
                Log.d("Vaccine Delete?", "Error deleting documents: ", exception)

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