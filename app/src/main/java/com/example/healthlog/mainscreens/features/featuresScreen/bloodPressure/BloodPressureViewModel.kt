package com.example.healthlog.mainscreens.features.featuresScreen.bloodPressure

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

class BloodPressureViewModel(): ViewModel() {
    private val usersCollection = HealthLogAppState.usersCollection
    private val userEmail= HealthLogAppState.useremail // this has changed

    fun saveBloodPressureData( systolic:Int,diastolic:Int,pulse:Int,selectedDate:Long){

        val userDocRef = usersCollection.document(userEmail)

        val timeStamp = Timestamp(selectedDate)

        val bloodPressureData = hashMapOf(
           "Systolic" to systolic,
            "Diastolic" to diastolic,
            "Pulse" to pulse,
            "Date" to timeStamp
        )

        viewModelScope.launch(Dispatchers.IO) {
            try{
                userDocRef.collection("Blood Pressure").document().set(bloodPressureData,merge()).await()
                Log.d("DocSuccess", "DocumentSnapshot successfully written!")

            }
            catch (e:Exception){
                Log.w("DocFailure", "Error writing document")

            }

        }

    }

    fun getBloodPressureData(): MutableState<List<DocumentSnapshot>> {

        val fetchedData = mutableStateOf(emptyList<DocumentSnapshot>())

        usersCollection.document(userEmail).collection("/Users/chakshuharsh97@gmail.com/Blood Pressure ").get()

            .addOnSuccessListener { result ->

                fetchedData.value=result.documents
                for (document in result) {
                    Log.d("DataBSuccess?", "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("DataBFail?", "Error getting documents: ", exception)
            }


        return fetchedData

    }
}