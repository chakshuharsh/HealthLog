package com.example.healthlog.mainscreens.features.featuresScreen.allergy

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
import com.example.healthlog.mainscreens.commonui.CommonCardNew
import com.example.healthlog.mainscreens.commonui.topBarForFeatures

@Composable

fun PreviousAllergyScreen(navigationManager: NavigationManager){

    val viewModel = remember { AllergyViewModel() }
    val fetchedAllergyData = viewModel.getAllergyData()
    var allergyName: String?
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
                onPreviousClick = {navigationManager.navigateToPreviousAllergyScreen()},
            )

            Spacer(modifier = Modifier.height(40.dp))

            for (document in fetchedAllergyData.value) {
                allergyName = document.getString("Name")
                allergyName?.let { Text(text = it) }
            }
        }
    }
}
