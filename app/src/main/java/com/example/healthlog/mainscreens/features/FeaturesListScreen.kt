package com.example.healthlog.mainscreens.features

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import com.example.healthlog.R
import com.example.healthlog.core.NavigationManager
import com.example.healthlog.core.HealthLogAppState
import com.example.healthlog.mainscreens.commonui.BottomBar
import com.example.healthlog.mainscreens.commonui.FeatureBox
import com.example.healthlog.mainscreens.commonui.topBarForFeatures

// prescription
// o2
//vaccine
// prescription
// lab tests
// create a card that shows the name of the feature along with icon and pass a navoigation to it

data class Feature(
    val featureText: String,
    val image: ImageBitmap,
    val onClick:()-> Unit
)





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeatureListScreen( navigationManager: NavigationManager){

    val topBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())



    val featureList = listOf(

        Feature(
        featureText = "Blood Pressure",
        image = ImageBitmap.imageResource(R.drawable.blood_pressure),
            onClick = {navigationManager.navigateToBloodPressureScreen()}
     ),
        Feature(
        featureText = "Vaccine",
        image = ImageBitmap.imageResource(R.drawable.vaccine),
            onClick = {navigationManager.navigateToNewVaccineScreen()}
    ),
        Feature(
        featureText = "SpO2",
        image = ImageBitmap.imageResource(R.drawable.o2),
            onClick = {navigationManager.navigateToOxygenScreen()}
    ),
        Feature(
        featureText = "Prescription",
        image = ImageBitmap.imageResource(R.drawable.prescription),
            onClick = {navigationManager.navigateToPrescriptionScreen()}
    ),
        Feature(
        featureText = "Lab Tests",
        image = ImageBitmap.imageResource(R.drawable.test),
            onClick = {navigationManager.navigateToLabReportScreen()}
    ),
        Feature(
        featureText = "Sugar levels",
        image = ImageBitmap.imageResource(R.drawable.sugar_blood_level),
            onClick = {navigationManager.navigateToNewVaccineScreen()}
    ),
        Feature(
            featureText = "Allergy",
        image = ImageBitmap.imageResource(R.drawable.allergy),
            onClick = {navigationManager.navigateToAllergyScreen()}
    )

    ) // list of card that represents features

    Scaffold(
topBar = {
topBarForFeatures(navigationManager)
},

        bottomBar = {
          BottomBar(navigationManager)
        },
    ) {innerPadding->
        // displays the list in lazy column

            LazyColumn(contentPadding = innerPadding) {
                items(featureList.size) { index ->
                    val feature = featureList[index]
                    FeatureBox(feature.featureText, feature.image,feature.onClick)
                }
            }

    }

}