package com.example.healthlog.mainscreens.features.featuresScreen.oxygen



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

class OxygenViewModel():ViewModel() {
    private val usersCollection = HealthLogAppState.usersCollection
    private val userEmail= HealthLogAppState.useremail // this has changed

    fun saveOxygenData( oxygenSelected:Int,pulseSelected:Int,selectedDate:Long){

        val userDocRef = usersCollection.document(userEmail)

        val timeStamp = Timestamp(selectedDate)

        val oxygenData = hashMapOf(
            "SpO2" to oxygenSelected,
            "Pulse" to pulseSelected,
            "Date" to timeStamp
        )

        viewModelScope.launch(Dispatchers.IO) {
            try{
                userDocRef.collection("Oxygen Data").document().set(oxygenData,merge()).await()
                Log.d("DocSuccess", "DocumentSnapshot successfully written!")

            }
            catch (e:Exception){
                Log.w("DocFailure", "Error writing document")

            }

        }

    }

    fun getOxygenData(): MutableState<List<DocumentSnapshot>> {

        val fetchedData = mutableStateOf(emptyList<DocumentSnapshot>())

        usersCollection.document(userEmail).collection("Oxygen Data").get()
            .addOnSuccessListener { result ->

                fetchedData.value=result.documents
                for (document in result) {
                    Log.d("DataS?", "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("DataF?", "Error getting documents: ", exception)
            }


        return fetchedData

    }
}