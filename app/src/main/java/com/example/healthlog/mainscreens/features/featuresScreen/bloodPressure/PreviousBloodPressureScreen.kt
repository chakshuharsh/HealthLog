package com.example.healthlog.mainscreens.features.featuresScreen.bloodPressure

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthlog.R
import com.example.healthlog.core.NavigationManager
import com.example.healthlog.core.Screen
import com.example.healthlog.mainscreens.commonui.BottomBar
import com.example.healthlog.mainscreens.commonui.CommonCardNew
import com.example.healthlog.mainscreens.commonui.topBarForFeatures
import com.example.healthlog.mainscreens.features.featuresScreen.oxygen.OxygenViewModel
import com.example.healthlog.mainscreens.features.featuresScreen.vaccine.MedicineSection

@Composable

fun PreviousBloodPressureScreen(navigationManager: NavigationManager){

    Log.d("Function called from blood prev","Yes")

    val viewModel = remember { BloodPressureViewModel() }
    Log.d("Break Point 1","Yes")

    val fetchedBloodPressureData = viewModel.getBloodPressureData().collectAsState().value
    Log.d("Break Point 2","Yes")




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
                onPreviousClick = {},
            )
               Log.d("error in commoncard?","Yes")

            Spacer(modifier = Modifier.height(40.dp))

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                items(fetchedBloodPressureData.size) { index ->
                    val document = fetchedBloodPressureData[index]
                    val systolic = document.getLong("Systolic")?.toString() ?: "N/A"
                    val diastolic = document.getLong("Diastolic")?.toString() ?: "N/A"
                    val pulse = document.getLong("Pulse")?.toString() ?: "N/A"

                    BloodPressureSection(systolic, diastolic, pulse)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
            Log.d("Break Point 3","Yes")

        }
    }
}





@Composable
fun BloodPressureSection(Systolic: String?, Diastolic: String?,Pulse:String?) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 0.dp, end = 0.dp).height(70.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFB3D9FF)),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(13.dp),
    ) {

        Row() {


                Text(
                    text = Systolic ?: "Unknown Data",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left,
                )
                Spacer(modifier = Modifier.width(13.dp))
            Image(
                painter = painterResource(id = R.drawable.systolic), contentDescription = "Systolic",
                modifier = Modifier.padding(start = 10.dp, top = 15.dp)
            )
            Spacer(modifier = Modifier.width(13.dp))
                Text(
                    text = Diastolic?:"Unknown Data",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left,
                )
            Spacer(modifier = Modifier.width(13.dp))
            Image(
                painter = painterResource(id = R.drawable.diastolic), contentDescription = "Diastolic",
                modifier = Modifier.padding(start = 10.dp, top = 15.dp)
            )
            Text(
                text = Pulse?:"Unknown Data",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left,
            )
            Image(
                painter = painterResource(id = R.drawable.pulse), contentDescription = "pulse",
                modifier = Modifier.padding(start = 10.dp, top = 15.dp)
            )

            }



        }
    }
