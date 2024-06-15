package com.example.healthlog.mainscreens.features.featuresScreen.oxygen




import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthlog.core.NavigationManager
import com.example.healthlog.mainscreens.commonui.BottomBar
import com.example.healthlog.mainscreens.commonui.CommonCardNew
import com.example.healthlog.mainscreens.commonui.topBarForFeatures
import com.example.healthlog.mainscreens.features.featuresScreen.bloodPressure.BloodPressureSection
import com.example.healthlog.mainscreens.features.featuresScreen.bloodPressure.BloodPressureViewModel
import com.google.firebase.firestore.DocumentSnapshot
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale

@Composable

fun PreviousOxygenScreen(navigationManager: NavigationManager){

    val viewModel = remember { OxygenViewModel() }


    val fetchedOxygenData = viewModel.getOxygenData().collectAsState().value

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
                onNewClick = {navigationManager.navigateToOxygenScreen()},
                onPreviousClick = {navigationManager.navigateToPreviousOxygenScreen()},
            )

            Spacer(modifier = Modifier.height(0.dp))
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                items(fetchedOxygenData.size) { index ->
                    val document = fetchedOxygenData[index]

            val spo2 = document.getLong("SpO2")?.toString() ?: "N/A"
                    val pulse = document.getLong("Pulse")?.toString() ?: "N/A"
                    val dateString = document.getDate("Date")?.toString() ?: "N/A"


                    val dateFormatter = SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.getDefault()) // Adjusted format pattern


                    val parsedDate = dateFormatter.parse(dateString)?.time

                    val newDateFormatter = SimpleDateFormat("MMMM d, yyyy", Locale.getDefault()) // Format for desired output
                    val formattedDate = newDateFormatter.format(parsedDate)
                    // Proceed with formatting the date using the parsedDate object

                    Log.w("DateParsing", "Failed to parse date string: $dateString")



                    OxygenSection( pulse,spo2,formattedDate,viewModel,document)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }


        }
    }
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun OxygenSection(pulse:String?,spo2:String?,date:String?,viewModel: OxygenViewModel,documentSnapshot: DocumentSnapshot) {

    val squareSize = 128.dp
    val bottomSheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    val width = 7.dp
    val sizePx = with(LocalDensity.current) { squareSize.toPx() }
    val anchors = mapOf(0f to 0, sizePx to 1)
    val maxSwipeDistance = with(LocalDensity.current) { squareSize.toPx() }


    Log.d("Break Point 4", "Yes")
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 0.dp, end = 0.dp)
            .combinedClickable(
                onLongClick = {
                    //add another function just to update the UI
                    scope.launch { bottomSheetState.show() } },
                onClick = {}
            )
            .height(120.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFB3D9FF)),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(13.dp),
    ) {
        Column() {

            Text(
                text = date ?: "Unknown Data",
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Left,
                modifier = Modifier.padding(start=15.dp,top=10.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Canvas(modifier = Modifier.fillMaxWidth()) {
                drawLine(
                    start= Offset(x=size.width,y=0f),
                    end = Offset(x = 0f, y = size.height),
                    color= Color.White,
                    alpha=1.0f,
                    strokeWidth = 3f,


                    )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 10.dp, top = 10.dp, bottom = 0.dp)
            ) {




                Column() {

                    Text(
                        text = "SpO2",
                        fontSize = 18.sp,
                    )

                    Text(
                        text = "$spo2%"?: "Unknown Data",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Left,
                        color = Color.Blue

                    )

                }
                Spacer(modifier = Modifier.width(37.dp))

                Column() {

                    Text(
                        text = "Pulse",
                        fontSize = 18.sp,
                    )
                    Text(
                        text = pulse ?: "Unknown Data",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Left,
                    )
                    Text(
                        text = "Bpm",
                        fontSize = 18.sp,
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                }

            }
            Row() {

                Spacer(modifier = Modifier.width(60.dp))


            }

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
                    viewModel.deleteOxygenData(documentSnapshot.id)
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



