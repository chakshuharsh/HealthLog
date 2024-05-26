package com.example.healthlog.mainscreens.features.featuresScreen.vaccine

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.Alignment
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
import com.example.healthlog.mainscreens.commonui.CommonCard
import com.example.healthlog.mainscreens.commonui.CommonCardNew
import com.example.healthlog.mainscreens.commonui.topBarForFeatures

@Composable

fun PreviousVaccineScreen(navigationManager: NavigationManager) {


    val viewModel = remember { VaccineScreenViewModel() }
    val fetchedVaccineData = viewModel.getVaccineData().collectAsState().value


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
                .fillMaxWidth().background(Color(0xFFE6F0FA))
        ) {

            CommonCardNew(
                onNewClick = {navigationManager.navigateToNewVaccineScreen()},
                onPreviousClick = {},
            )

            Spacer(modifier = Modifier.height(0.dp))

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                items(fetchedVaccineData.size) { index ->
                    val document = fetchedVaccineData[index]
                    val vaccineName = document.getString("Name")
                    val vaccineDate = document.getDate("Date")?.toString()

                    MedicineSection(vaccineName, vaccineDate)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}


@Composable
fun MedicineSection(vaccineName: String?, vaccineDate: String?) {
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
            text = vaccineName ?: "Unknown Vaccine",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left,
        )
        Spacer(modifier = Modifier.width(13.dp))

        Text(
            text = "$vaccineDate",
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