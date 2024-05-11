package com.example.healthlog.mainscreens.features.featuresScreen.vaccine

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
import com.example.healthlog.mainscreens.commonui.BottomBar
import com.example.healthlog.mainscreens.commonui.CommonCard
import com.example.healthlog.mainscreens.commonui.CommonCardNew
import com.example.healthlog.mainscreens.commonui.topBarForFeatures

@Composable

fun PreviousVaccineScreen(navigationManager: NavigationManager) {


    val viewModel = remember { VaccineScreenViewModel() }
    val fetchedVaccineData = viewModel.getVaccineData()
    var vaccineName: String?
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
                onNewClick = {navigationManager.navigateToNewVaccineScreen()},
                onPreviousClick = {navigationManager.navigateToPreviousVaccineScreen()},
            )

            Spacer(modifier = Modifier.height(40.dp))

            for (document in fetchedVaccineData.value) {
                vaccineName = document.getString("Name")
                vaccineName?.let { Text(text = it) }
            }
        }
    }
}