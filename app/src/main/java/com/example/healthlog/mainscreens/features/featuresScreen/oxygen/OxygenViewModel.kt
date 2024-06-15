package com.example.healthlog.mainscreens.features.featuresScreen.oxygen



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

class OxygenViewModel():ViewModel() {
    private val usersCollection = HealthLogAppState.usersCollection
    private val userEmail= HealthLogAppState.useremail // this has changed
    private val _oxygenData = MutableStateFlow<List<DocumentSnapshot>>(emptyList())
    private val oxygenData: StateFlow<List<DocumentSnapshot>> = _oxygenData

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

    fun getOxygenData(): StateFlow<List<DocumentSnapshot>> {

        viewModelScope.launch {
            try {
                val result = usersCollection.document(userEmail).collection("Oxygen Data")
                    .orderBy("Date", Query.Direction.DESCENDING).get().await()
                //Check if data has changed

                if (result.documents.size != _oxygenData.value.size) {
                    _oxygenData.value = result.documents
                }

            } catch (exception: Exception) {
                Log.d(" SpO2 Not fetched?", "Error getting documents: ", exception)
            }
        }
        return oxygenData




    }

    fun deleteOxygenData(documentId:String){

        viewModelScope.launch {
            try{
                usersCollection.document(userEmail).collection("Oxygen Data").document(documentId)
                    .delete()
                _oxygenData.value = _oxygenData.value.filterNot { it.id == documentId }
            }
            catch (exception: Exception) {
                Log.d("BP Delete?", "Error deleting documents: ", exception)

            }
        }

    }
}