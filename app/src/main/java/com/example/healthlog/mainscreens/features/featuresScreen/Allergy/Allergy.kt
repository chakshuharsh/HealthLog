package com.example.healthlog.mainscreens.features.featuresScreen.Allergy

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthlog.R
import com.example.healthlog.core.HealthogAppState
import com.example.healthlog.core.NavigationManager
import com.example.healthlog.mainscreens.commonui.BottomBar
import com.example.healthlog.mainscreens.commonui.CommonCard
import com.example.healthlog.mainscreens.commonui.topBarForFeatures
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllergyScreen(navigationManager: NavigationManager){

    var allergyState = remember { mutableStateOf("") }
    var  isAllergyEmpty = allergyState.value.isEmpty()
    var openDialog = remember{mutableStateOf(false)}
    val datePickerState = rememberDatePickerState(initialSelectedDateMillis = System.currentTimeMillis())
    val dateFormatter = SimpleDateFormat("d MMM yyyy", Locale.getDefault())
    val selectedDateInMillis = datePickerState.selectedDateMillis ?: System.currentTimeMillis()
    val selectedCalendar = Calendar.getInstance().apply {
        timeInMillis = selectedDateInMillis
    }
    val formattedDate = dateFormatter.format(selectedCalendar.time)
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    var isButtonEnabled= remember{mutableStateOf(false)}
    isButtonEnabled.value=allergyState.value.isEmpty()

    val realBlueColor = Color(74,86,119)

    val lightBlue = Color(0xFF4169E1)
    Scaffold(
        topBar = {
            topBarForFeatures(navigationManager)
        },
        bottomBar = {
            BottomBar(navigationManager)
        }
    ) {innerPadding->
        Column(modifier = androidx.compose.ui.Modifier
            .padding(innerPadding)
            .fillMaxWidth()
        ) {
           CommonCard()

            Spacer(modifier = Modifier.height(40.dp))

            Row(
                modifier = Modifier
                    .padding(start = 5.dp, top = 2.dp)
                    .fillMaxWidth(),
                verticalAlignment= Alignment.CenterVertically
            ) {

                Image(
                    bitmap = ImageBitmap.imageResource(R.drawable.allergy),
                    contentDescription = "Allergy",
                    modifier = Modifier
                        .size(60.dp)
                        .padding(start = 6.dp),
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.CenterEnd
                )
                Spacer(modifier = Modifier.width(20.dp))

                Text(
                    text = "Allergy",
                    color = Color.Blue,
                    modifier = Modifier
                        .padding(top = 17.dp,bottom = 5.dp),
                    fontSize = 25.sp

                )
            } // contains Image and Text

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = allergyState.value,
                onValueChange =  {allergyState.value = it },
                modifier = Modifier
                    .padding(start = 16.dp)
                    .fillMaxWidth(0.8f)
                    .width(400.dp),
                shape = RoundedCornerShape(20.dp),
                placeholder = {Text(text = "Allergy")},
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Email,
                    autoCorrect = false,
                ),
                keyboardActions = KeyboardActions(onDone = {
                    keyboardController?.hide()
                    focusManager.clearFocus()
                }
                ),
            )

            Row(
                modifier = Modifier
                    .padding(start = 5.dp, top = 32.dp)
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
            Spacer(modifier = Modifier.height(250.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonColors(
                    containerColor = realBlueColor,
                    contentColor = Color.White,
                    disabledContainerColor = Color.Gray,
                    disabledContentColor = Color.Cyan
                ),
                enabled = !isButtonEnabled.value,
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