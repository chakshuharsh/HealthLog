package com.example.healthlog.mainscreens.features.featuresScreen.bloodPressure


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthlog.core.HealthLogAppState

import com.example.healthlog.core.NavigationManager
import com.example.healthlog.mainscreens.commonui.BottomBar
import com.example.healthlog.mainscreens.commonui.CommonCard
import com.example.healthlog.mainscreens.commonui.CommonCardNew
import com.example.healthlog.mainscreens.commonui.topBarForFeatures
import com.example.healthlog.mainscreens.features.featuresScreen.oxygen.OxygenViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BloodPressureScreen( navigationManager: NavigationManager) {

    val viewModel = remember{ BloodPressureViewModel() }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    val dateFormatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())


    val datePickerState =
        rememberDatePickerState(initialSelectedDateMillis = System.currentTimeMillis())

    val selectedDateInMillis = datePickerState.selectedDateMillis ?: System.currentTimeMillis()
    val selectedCalendar = Calendar.getInstance().apply {
        timeInMillis = selectedDateInMillis
    }
    val formattedDate = dateFormatter.format(selectedCalendar.time)


    var notesState = remember { mutableStateOf("") }


    val realBlueColor = Color(74,86,119)


    val numbersList = (20..300).toList()

    var openDialog = remember { mutableStateOf(false) }

    val listStateSystolic = rememberLazyListState()
    val listStateDiastolic = rememberLazyListState()
    val listStatePulse = rememberLazyListState()

    var selectedNumberSystolic = remember { mutableStateOf(0) }
    var selectedNumberDiastolic = remember { mutableStateOf(0) }

    var selectedNumberPulse = remember { mutableStateOf(0) }

    var isButtonEnabled = remember{mutableStateOf(false)}


    if(selectedNumberDiastolic.value!=0&&selectedNumberSystolic.value!=0&&selectedNumberPulse.value!=0){
        isButtonEnabled.value=true
    }
//    LaunchedEffect(listStateSystolic,listStateDiastolic,listStatePulse){
//        listStateSystolic.scrollToItem(60)
//        listStateDiastolic.scrollToItem(65)
//        listStatePulse.scrollToItem(52)
//
//    }

    Scaffold(
        topBar = {
            topBarForFeatures(navigationManager)
        },
        bottomBar = {
            BottomBar(navigationManager)
        }
    ) { innerpadding ->

        Column(
            modifier = androidx.compose.ui.Modifier
                .padding(innerpadding)
                .fillMaxWidth()
        ) {

            CommonCardNew(
                onNewClick = {},
                onPreviousClick = {navigationManager.navigateToPreviousBloodPressureScreen()},
            )


            Spacer(modifier = Modifier.height(40.dp))

            Row(
                modifier = Modifier
                    .fillMaxHeight(0.37f)
                    .fillMaxWidth()
            )
            {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(start = 10.dp)
                ) {
                    Text(
                        text = "Systolic",
                        fontSize = 25.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(1.dp))
                    LazyColumn(
                        state = listStateSystolic,
                        modifier = Modifier.fillMaxHeight()
                    ) {
//

                        items(count = Int.MAX_VALUE) { index ->
//
                            SelectableNumber(
                                number = numbersList[index],
                                selectedNumber = selectedNumberSystolic.value,
                                onNumberSelected = {
                                    selectedNumberSystolic.value = numbersList[index]
                                }
                            )
                        }

                    }


                }

                Spacer(modifier = Modifier.width(30.dp))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    Text(
                        text = "Diastolic",
                        fontSize = 25.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(1.dp))
                    LazyColumn(
                        state = listStateDiastolic,
                        modifier = Modifier.fillMaxHeight()
                    ) {

                        items(count = Int.MAX_VALUE) { index ->
                            SelectableNumber(
                                number = numbersList[index],
                                selectedNumber = selectedNumberDiastolic.value,
                                onNumberSelected = {
                                    selectedNumberDiastolic.value = numbersList[index]
                                }
                            )

                        }
                    }


                }

                Spacer(modifier = Modifier.width(30.dp))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(end = 10.dp)
                ) {
                    Text(
                        text = "Pulse",
                        fontSize = 25.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(1.dp))
                    LazyColumn(
                        state = listStatePulse,
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        items(count = Int.MAX_VALUE) { index ->


                                SelectableNumber(
                                    number = numbersList[index],
                                    selectedNumber = selectedNumberPulse.value,
                                    onNumberSelected = {
                                        selectedNumberPulse.value = numbersList[index]
                                    }
                                )

                        }
                    }
                }
            }


            Spacer(modifier = Modifier.height(13.dp))
            Row(
                modifier = Modifier
                    .padding(start = 1.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(onClick = { openDialog.value = true }) {
                    Icon(
                        imageVector = Icons.Filled.DateRange,
                        contentDescription = "Icon for back navigation",
                        modifier = Modifier.size(60.dp),
                        tint = Color.Blue

                    )
                }

                if (openDialog.value) {
                    DatePickerDialog(
                        onDismissRequest = { openDialog.value = false },
                        confirmButton = {

                            TextButton(onClick = { openDialog.value = false }) {
                                Text("Ok")
                            }

                        },
                        dismissButton = {
                            TextButton(onClick = { openDialog.value = false }) {
                                Text("Cancel")
                            }
                        },
                        content = {
                            DatePicker(
                                state = datePickerState,
                            )
                        }

                    )

                }

                Text(
                    text = formattedDate,
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable { openDialog.value = true }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))


            OutlinedTextField(
                value = notesState.value,
                onValueChange = { notesState.value = it },
                modifier = Modifier
                    .padding(start = 16.dp)
                    .fillMaxWidth(0.9f)
                    .width(400.dp)
                    .height(71.dp),
                shape = RoundedCornerShape(20.dp),
                placeholder = { Text(text = "Notes") },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Email,
                    autoCorrect = false,
                ),
                keyboardActions = KeyboardActions(onDone = {
                    keyboardController?.hide()
                    focusManager.clearFocus()
                }),
            )
            Spacer(modifier = Modifier.height(120.dp))
            Button(
                onClick = { viewModel.saveBloodPressureData(selectedNumberSystolic.value,selectedNumberDiastolic.value,selectedNumberPulse.value,selectedDateInMillis) },
                colors = ButtonColors(
                    containerColor = realBlueColor,
                    contentColor = Color.White,
                    disabledContainerColor = Color.Gray,
                    disabledContentColor = Color.Cyan
                ),
                enabled = isButtonEnabled.value,
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp)
                    .width(350.dp),
                shape = RoundedCornerShape(20.dp)

            ) {
                Text(
                    text = "SAVE",
                    fontSize = 21.sp,
                    letterSpacing = 10.sp
                )


            }


        }




    }


}


@Composable
fun SelectableNumber(
    number: Int,
    selectedNumber: Int,
    onNumberSelected: (Int) -> Unit
) {
    val isSelected = number == selectedNumber
    val lightBlue = Color(0xFF4169E1)
    val shape : Shape = RoundedCornerShape(8.dp)
    val boxWidth = (45 + (number.toString().length * 8)) // Approximate width based on the number of characters
    val realBlueColor = Color(74,86,119)

    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(width = boxWidth.dp,height = 44.dp)
            .background(if (isSelected) realBlueColor else Color.Transparent,shape)
            .clickable { onNumberSelected(number) },

    ) {
        Text(
            text = number.toString(),
            color = if (isSelected) Color.White else Color.Black,
            fontSize = 40.sp,//37
            modifier = Modifier

                .align(Alignment.Center)

        )
    }

}