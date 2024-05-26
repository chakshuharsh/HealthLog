package com.example.healthlog.mainscreens.features.featuresScreen.allergy

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
import com.example.healthlog.mainscreens.commonui.BottomBar
import com.example.healthlog.mainscreens.commonui.CommonCardNew
import com.example.healthlog.mainscreens.commonui.topBarForFeatures
import com.example.healthlog.mainscreens.features.featuresScreen.vaccine.MedicineSection

@Composable

fun PreviousAllergyScreen(navigationManager: NavigationManager){

    val viewModel = remember { AllergyViewModel() }
    val fetchedAllergyData = viewModel.getAllergyData().collectAsState().value

    Scaffold(
        topBar = {
            topBarForFeatures(navigationManager)
        },
        bottomBar = {
            BottomBar(navigationManager)
        }
    ) { innerpadding ->

        Column(
            modifier = Modifier
                .padding(innerpadding)
                .fillMaxWidth()
        ) {

            CommonCardNew(
                onNewClick = {navigationManager.navigateToAllergyScreen()},
                onPreviousClick = {},
            )

            Spacer(modifier = Modifier.height(40.dp))

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                items(fetchedAllergyData.size) { index ->
                    val document = fetchedAllergyData[index]
                    val allergyName = document.getString("Name")
                    val allergyDate = document.getDate("Date")?.toString()

                    MedicineSection(allergyName, allergyDate)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }


        }
    }
}


@Composable
fun MedicineSection(allergyName: String?, allergyDate: String?) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 0.dp, end = 0.dp).height(70.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFB3D9FF)),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(13.dp),
    ) {

        Row() {

            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = allergyName ?: "Unknown Vaccine",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left,
                )
                Spacer(modifier = Modifier.width(13.dp))

                Text(
                    text = "$allergyDate",
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }

            Image(
                painter = painterResource(id = R.drawable.vaccineimage), contentDescription = "Medicine",
                modifier = Modifier.padding(start = 10.dp, top = 15.dp)
            )

        }
    }
}