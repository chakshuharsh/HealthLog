package com.example.healthlog.mainscreens.features.featuresScreen.Oxygen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.ColumnScopeInstance.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthlog.core.HealthogAppState
import com.example.healthlog.core.NavigationManager
import com.example.healthlog.mainscreens.commonui.BottomBar
import com.example.healthlog.mainscreens.commonui.CommonCard
import com.example.healthlog.mainscreens.commonui.topBarForFeatures
import com.example.healthlog.mainscreens.features.featuresScreen.Vaccine.VaccineScreenViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import kotlin.math.absoluteValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OxygenScreen(navigationManager: NavigationManager) {


    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    val dateFormatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())


    val datePickerState =
        rememberDatePickerState(initialSelectedDateMillis = System.currentTimeMillis())

    val selectedDateInMillis = datePickerState.selectedDateMillis ?: System.currentTimeMillis()
    val selectedCalendar = Calendar.getInstance().apply {
        timeInMillis = selectedDateInMillis
    }

    val numbersList = (20..300).toList()
    var selectedNumberOxygen = remember { mutableStateOf(0) }

    var selectedNumberPulse = remember { mutableStateOf(0) }

    var isButtonEnabled = remember{mutableStateOf(false)}

    if(selectedNumberPulse.value!=0&&selectedNumberOxygen.value!=0){
        isButtonEnabled.value=true
    }

    val formattedDate = dateFormatter.format(selectedCalendar.time)




    var notesState = remember { mutableStateOf("") }

    val listStateOxygen = rememberLazyListState()
    val listStatePulse = rememberLazyListState()

    val lightBlue = Color(0xFF4169E1) // royal blue

    val realLightBlueColor = Color(74,86,119)


    var openDialog = remember { mutableStateOf(false) }


        LaunchedEffect(listStateOxygen,listStatePulse){

        listStateOxygen.scrollToItem(75)
        listStatePulse.scrollToItem(52)

    }

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

            CommonCard()

            Spacer(modifier = Modifier.height(40.dp))

            Row(modifier = Modifier.fillMaxHeight(0.37f)) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(start = 70.dp)
                ) {
                    Text(
                        text = "SpO2",
                        fontSize = 30.sp,
                        color = Color.Black,
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                LazyColumn(
                    state =listStateOxygen,
                    modifier = Modifier.fillMaxHeight()
                ){
                    items(count = Int.MAX_VALUE){index ->
                        SelectableNumber(
                            number = numbersList[index],
                            selectedNumber = selectedNumberOxygen.value,
                            onNumberSelected = {
                                selectedNumberOxygen.value = numbersList[index]
                            }
                        )
                    }
                }


                }
                Spacer(modifier = Modifier.width(70.dp))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(end = 40.dp)
                ) {
                    Text(
                        text = "Pulse",
                        fontSize = 30.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(5.dp))
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
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .padding(start = 5.dp)
                    .fillMaxWidth(),
                verticalAlignment= Alignment.CenterVertically
            ) {

                IconButton(onClick = { openDialog.value= true  }) {
                    Icon(
                        imageVector = Icons.Filled.DateRange,
                        contentDescription = "Icon for back navigation",
                        modifier = Modifier.size(60.dp),
                        tint = Color.Blue

                    )
                }

                if(openDialog.value){
                    DatePickerDialog(
                        onDismissRequest = {openDialog.value=false},
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
                onValueChange =  {notesState.value = it },
                modifier = Modifier
                    .padding(start = 16.dp)
                    .fillMaxWidth(0.9f)
                    .width(400.dp)
                    .height(71.dp),
                shape = RoundedCornerShape(20.dp),
                placeholder = {Text(text = "Notes",
                    fontSize = 24.sp)},
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
                onClick = { /*TODO*/ },
                colors = ButtonColors(
                    containerColor = realLightBlueColor,
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
    val realLightBlue = Color(74,86,119)
    val shape : Shape = RoundedCornerShape(8.dp)
    val boxWidth = (45 + (number.toString().length * 8)) // Approximate width based on the number of characters


    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(width = boxWidth.dp,height = 44.dp)
            .background(if (isSelected) realLightBlue else Color.Transparent,shape)
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



//
//@Composable
//fun NumberItem(number: Int) {
//
//
//
//Text(
//text = number.toString(),
//fontSize = 70.sp,
//color = Color.Black,
//)
//}


