package com.example.healthlog.mainscreens.features.featuresScreen.bloodPressure

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.healthlog.core.NavigationManager
import com.example.healthlog.core.Screen
import com.example.healthlog.mainscreens.commonui.BottomBar
import com.example.healthlog.mainscreens.commonui.CommonCardNew
import com.example.healthlog.mainscreens.commonui.topBarForFeatures
import com.example.healthlog.mainscreens.features.featuresScreen.oxygen.OxygenViewModel

@Composable

fun PreviousBloodPressureScreen(navigationManager: NavigationManager){
    val viewModel = remember { BloodPressureViewModel() }
    val fetchedBloodPressureData = viewModel.getBloodPressureData()
    Log.d("Function called from blood prev","Yes")
    var systolicValue: Int?
    var pulseValue: Int?
    var diastolicValue: Int?
    Log.d("error in var?","Yes")
//    var Date: Timestamp?

    Scaffold(
        topBar = {
            topBarForFeatures(navigationManager)
        },
        bottomBar = {
            BottomBar(navigationManager)
        }
    ) { innerpadding ->
        Log.d("error in bla?","Yes")
        Column(
            modifier = Modifier
                .padding(innerpadding)
                .fillMaxWidth()
        ) {

            CommonCardNew(
                onNewClick = {navigationManager.navigateToBloodPressureScreen()},
                onPreviousClick = {navigationManager.navigateToPreviousBloodPressureScreen()},
            )
Log.d("error in commoncard?","Yes")

            Spacer(modifier = Modifier.height(40.dp))

            for (document in fetchedBloodPressureData.value) {
                systolicValue = document.getString("Systolic")?.toInt()
                systolicValue?.let { Text(text = it.toString()) }
                Spacer(modifier = Modifier.height(20.dp))
                pulseValue=document.getString("Pulse")?.toInt()
                pulseValue?.let { Text(text = it.toString()) }
                Spacer(modifier = Modifier.height(20.dp))
                diastolicValue=document.getString("Diastolic")?.toInt()
                diastolicValue?.let { Text(text = it.toString()) }
                Log.d("Data displayed?","Yes")
//                Date=document.getTimestamp("Date")
//                Date?.let { Text(text = it.toString()) }

            }
        }
    }
}