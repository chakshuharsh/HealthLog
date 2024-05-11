package com.example.healthlog.mainscreens.features.featuresScreen.allergy

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthlog.core.HealthLogAppState
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.SetOptions.merge
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.sql.Timestamp

class AllergyViewModel():ViewModel() {
    private val usersCollection = HealthLogAppState.usersCollection
    private val userEmail= HealthLogAppState.useremail // this has changed

fun saveAllergyData( allergyName:String,selectedDate:Long){

    val userDocRef = usersCollection.document(userEmail)

    val timeStamp = Timestamp(selectedDate)

    val allergy = hashMapOf(
        "Name" to allergyName,
        "Date" to timeStamp
    )

    viewModelScope.launch(Dispatchers.IO) {
        try{
            userDocRef.collection("Allergies").document().set(allergy,merge()).await()
            Log.d("DocSuccess", "DocumentSnapshot successfully written!")

        }
        catch (e:Exception){
            Log.w("DocFailure", "Error writing document")

        }

    }

}

    fun getAllergyData(): MutableState<List<DocumentSnapshot>> {

        val fetchedData = mutableStateOf(emptyList<DocumentSnapshot>())

        usersCollection.document(userEmail).collection("Allergies").get()
            .addOnSuccessListener { result ->

                fetchedData.value=result.documents
                for (document in result) {
                    Log.d("Data?", "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("Data?", "Error getting documents: ", exception)
            }


        return fetchedData

    }
}