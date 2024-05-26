package com.example.healthlog.mainscreens.features.featuresScreen.allergy

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

class AllergyViewModel():ViewModel() {
    private val usersCollection = HealthLogAppState.usersCollection
    private val userEmail= HealthLogAppState.useremail // this has changed
    private val _allergyData = MutableStateFlow<List<DocumentSnapshot>>(emptyList())
    private val allergyData: StateFlow<List<DocumentSnapshot>> = _allergyData

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

    fun getAllergyData(): StateFlow<List<DocumentSnapshot>> {


        viewModelScope.launch {
            try {
                val result = usersCollection.document(userEmail).collection("Allergies")
                    .orderBy("Date", Query.Direction.DESCENDING).get().await()
                _allergyData.value = result.documents
            } catch (exception: Exception) {
                Log.d("Data?", "Error getting documents: ", exception)
            }
        }


        return allergyData

    }
}