package com.example.healthlog.mainscreens.Features

import android.graphics.Color
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.example.healthlog.R
import com.example.healthlog.mainscreens.commonui.FeatureBox
import com.example.healthlog.mainscreens.commonui.MainScreenTopBar

// prescription
// o2
//vaccine
// prescription
// lab tests
// create a card that shows the name of the feature along with icon and pass a navoigation to it

data class Feature(
    val featureText: String,
    val image: ImageBitmap,
)





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeatureScreen(){

    val topBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())


    val featureList = listOf(

        Feature(
        featureText = "Blood Pressure",
        image = ImageBitmap.imageResource(R.drawable.blood_pressure),
     ),
        Feature(
        featureText = "Vaccine",
        image = ImageBitmap.imageResource(R.drawable.vaccine),
    ),
        Feature(
        featureText = "SpO2",
        image = ImageBitmap.imageResource(R.drawable.o2),
    ),
        Feature(
        featureText = "Prescription",
        image = ImageBitmap.imageResource(R.drawable.prescription),
    ),
        Feature(
        featureText = "Lac Tests",
        image = ImageBitmap.imageResource(R.drawable.test),
    ),
        Feature(
        featureText = "Sugar levels",
        image = ImageBitmap.imageResource(R.drawable.sugar_blood_level),
    ),
        Feature(
            featureText = "Allergy",
        image = ImageBitmap.imageResource(R.drawable.allergy),
    )

    ) // list of card that represents features

    Scaffold(
topBar = {
    MainScreenTopBar("Username", scrollBehavior = topBarScrollBehavior)
},
    ) {innerPadding->
        // displays the list in lazy column

            LazyColumn(contentPadding = innerPadding) {
                items(featureList.size) { index ->
                    val feature = featureList[index]
                    FeatureBox(feature.featureText, feature.image)
                }
            }

    }

}