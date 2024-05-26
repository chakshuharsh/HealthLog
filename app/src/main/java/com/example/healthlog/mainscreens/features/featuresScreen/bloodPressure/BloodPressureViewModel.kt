package com.example.healthlog.mainscreens.features.featuresScreen.bloodPressure

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

class BloodPressureViewModel(): ViewModel() {
    private val usersCollection = HealthLogAppState.usersCollection
    private val userEmail= HealthLogAppState.useremail
    private val _bloodPressureData = MutableStateFlow<List<DocumentSnapshot>>(emptyList())
    private val bloodPressureData: StateFlow<List<DocumentSnapshot>> = _bloodPressureData

    fun saveBloodPressureData( Systolic:Int,Diastolic:Int,Pulse:Int,SelectedDate:Long){

        val userDocRef = usersCollection.document(userEmail)

        val timeStamp = Timestamp(SelectedDate)

        val bloodPressure = hashMapOf(
           "Systolic" to Systolic,
            "Diastolic" to Diastolic,
            "Pulse" to Pulse,
            "Date" to timeStamp
        )



        viewModelScope.launch(Dispatchers.IO) {
            try{
                userDocRef.collection("Blood Pressure").document().set(bloodPressure,merge()).await()
                Log.d("DocSuccess", "DocumentSnapshot successfully written!")
Log.d("emailid", userEmail)
            }
            catch (e:Exception){
                Log.w("DocFailure", "Error writing document")

            }

        }

    }

    fun getBloodPressureData(): StateFlow<List<DocumentSnapshot>> {


        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = usersCollection.document(userEmail).collection("Blood Pressure")
                    .orderBy("Date", Query.Direction.DESCENDING).get().await()
                _bloodPressureData.value = result.documents
            } catch (exception: Exception) {
                Log.d("Data?", "Error getting documents: ", exception)
            }
        }
        return bloodPressureData


    }
}