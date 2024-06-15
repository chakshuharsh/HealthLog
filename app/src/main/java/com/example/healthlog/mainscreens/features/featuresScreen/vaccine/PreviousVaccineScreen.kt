package com.example.healthlog.mainscreens.features.featuresScreen.vaccine

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.wear.compose.material.ExperimentalWearMaterialApi
import androidx.wear.compose.material.FractionalThreshold
import androidx.wear.compose.material.SwipeableDefaults.resistanceConfig
import androidx.wear.compose.material.rememberSwipeableState
import androidx.wear.compose.material.swipeable
import com.example.healthlog.R
import com.example.healthlog.core.NavigationManager
import com.example.healthlog.mainscreens.commonui.BottomBar
import com.example.healthlog.mainscreens.commonui.CommonCard
import com.example.healthlog.mainscreens.commonui.CommonCardNew
import com.example.healthlog.mainscreens.commonui.topBarForFeatures

import com.google.firebase.firestore.DocumentSnapshot
import kotlinx.coroutines.launch
import kotlin.math.roundToInt



//TODO
// Edit function to update the data in the database
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
        },
        containerColor = Color(0xFFE6F0FA)
    ) { innerpadding ->

        Column(
            modifier = Modifier
                .padding(innerpadding)
                .fillMaxWidth()

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

                    MedicineSection(vaccineName, vaccineDate,viewModel,document)
                    Spacer(modifier = Modifier.height(16.dp))

                }
            }
        }
    }
}


@OptIn(ExperimentalWearMaterialApi::class, ExperimentalFoundationApi::class,
    ExperimentalMaterial3Api::class
)
@Composable
fun MedicineSection(vaccineName: String?, vaccineDate: String?,viewModel: VaccineScreenViewModel,documentSnapshot: DocumentSnapshot) {

    val swipeableState = rememberSwipeableState(0)
    val squareSize = 128.dp
    val bottomSheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    val width = 7.dp
    val sizePx = with(LocalDensity.current) { squareSize.toPx() }
    val anchors = mapOf(0f to 0, sizePx to 1)
    val maxSwipeDistance = with(LocalDensity.current) { squareSize.toPx() }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .swipeable(
                    state = swipeableState,
                    orientation = Orientation.Horizontal,
                    anchors = anchors, // Anchors
//                thresholds = { _, _ -> FractionalThreshold(0.3f) }, // Threshold
//                resistance = resistanceConfig(1f) // No resistance


                )
                .offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) }
                .padding(start = 0.dp, end = 0.dp)
                .height(70.dp)
                .combinedClickable(
                    onLongClick = {
                        //add another function just to update the UI
                        scope.launch { bottomSheetState.show() } },
                    onClick = {}
                ),

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
                    painter = painterResource(id = R.drawable.vaccineimage),
                    contentDescription = "Medicine",
                    modifier = Modifier.padding(start = 10.dp, top = 15.dp)
                )


        }
    }

    if (bottomSheetState.isVisible) {
        ModalBottomSheet(
            onDismissRequest = {
                scope.launch { bottomSheetState.hide() }
            },
            sheetState = bottomSheetState,
            modifier = Modifier.padding(top = 0.dp, bottom = 0.dp)

        ) {

            Column(
                modifier = Modifier
                    .padding(bottom = 16.dp, top = 0.dp)
                    .fillMaxWidth(),


                ) {

                TextButton(onClick = {}) {
                    Text(
                        text = "Edit",
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily.SansSerif,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 14.dp),
                        letterSpacing = 2.sp

                    )
                }
                Spacer(modifier = Modifier.height(2.dp))
                TextButton(onClick = {
                    viewModel.deleteVaccineData(documentSnapshot.id)
                scope.launch { bottomSheetState.hide() }}
                ) {
                    Text(
                        text = "Delete", fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily.SansSerif,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 14.dp),
                        letterSpacing = 2.sp

                    )
                }
            }
        }
    }


}


