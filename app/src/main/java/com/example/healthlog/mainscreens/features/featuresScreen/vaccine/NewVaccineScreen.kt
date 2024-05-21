package com.example.healthlog.mainscreens.features.featuresScreen.vaccine


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthlog.R

import com.example.healthlog.core.NavigationManager
import com.example.healthlog.mainscreens.commonui.BottomBar
import com.example.healthlog.mainscreens.commonui.CommonCard
import com.example.healthlog.mainscreens.commonui.CommonCardNew
import com.example.healthlog.mainscreens.commonui.topBarForFeatures
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewVaccineScreen( navigationManager: NavigationManager){

    val viewModel = remember{VaccineScreenViewModel()}

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

     val dateFormatter = SimpleDateFormat("d MMM yyyy", Locale.getDefault())


    val datePickerState = rememberDatePickerState(initialSelectedDateMillis = System.currentTimeMillis())

    val selectedDateInMillis = datePickerState.selectedDateMillis ?: System.currentTimeMillis()
    val selectedCalendar = Calendar.getInstance().apply {
        timeInMillis = selectedDateInMillis
    }
    val formattedDate = dateFormatter.format(selectedCalendar.time)


    var vaccineState = remember { mutableStateOf("") }


var isButtonEnabled= remember{mutableStateOf(false)}

    var openDialog = remember{mutableStateOf(false)}

    isButtonEnabled.value=vaccineState.value.isEmpty()

    val realBlueColor = Color(74,86,119)





    Scaffold(
    topBar = {
        topBarForFeatures(navigationManager)
    },
    bottomBar = {
        BottomBar(navigationManager)
    },
        modifier = Modifier.fillMaxSize()

) {innerpadding->

    Column(modifier = Modifier
        .padding(innerpadding)
        .fillMaxSize()
        .background(Color(0xFFE6F0FA))
    ) {
        Spacer(modifier = Modifier.height(0.dp))
        CommonCardNew(
            onNewClick = {navigationManager.navigateToNewVaccineScreen()},
            onPreviousClick = {navigationManager.navigateToPreviousVaccineScreen()},
        )

        Spacer(modifier = Modifier.height(10.dp))

       Row(
           modifier = Modifier
               .padding(start = 5.dp, top = 2.dp)
               .fillMaxWidth(),
           verticalAlignment= Alignment.CenterVertically
       ) {

           Image(
               bitmap = ImageBitmap.imageResource(R.drawable.vaccine),
               contentDescription = "VACCINE IMAGE",
               modifier = Modifier
                   .size(60.dp)
                   .padding(start = 6.dp),
               contentScale = ContentScale.Fit,
               alignment = Alignment.CenterEnd
           )
          Spacer(modifier = Modifier.width(10.dp))

           Text(
               text = "Vaccine",
               color = Color.Black,
               modifier = Modifier
                   .padding(top = 17.dp,bottom = 5.dp),
               fontSize = 25.sp,
               fontWeight = FontWeight.Medium

               )
       } // contains Image and Text

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = vaccineState.value,
             onValueChange =  {vaccineState.value = it },
            modifier = Modifier
                .padding(start = 16.dp)
                .fillMaxWidth(0.8f)
                .width(400.dp),
            shape = RoundedCornerShape(20.dp),
            placeholder = {Text(text = "Vaccine")},
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
    content = {DatePicker(
        state = datePickerState,
    )
    }

    )

            }
Spacer(modifier = Modifier.width(13.dp))

Card(
modifier = Modifier
    .height(52.dp)
    .clickable { openDialog.value = true }
) {
    Text(
        text = formattedDate,
        fontSize = 18.sp,
        color = Color.Black,
        modifier = Modifier
            .padding(16.dp)

    )

}





        }
        Spacer(modifier = Modifier.height(60.dp))

        MedicineSection(navigationManager)

        Spacer(modifier = Modifier.height(60.dp))

        Button(
            onClick = { viewModel.saveVaccineData(selectedDateInMillis,vaccineState.value)
                vaccineState.value = ""
                datePickerState.selectedDateMillis = System.currentTimeMillis()},
            colors = ButtonColors(
                containerColor = Color(0xFF4169E1),
                contentColor = Color.White,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.Cyan
            ),
            enabled = !isButtonEnabled.value,
            modifier = Modifier
                .padding(start = 15.dp, end = 10.dp)
                .width(350.dp),
            shape = RoundedCornerShape(10.dp)

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
fun MedicineSection(navigationManager: NavigationManager) {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(start = 20.dp, end = 0.dp,top =0.dp).clickable(onClick = {navigationManager.navigateToPreviousVaccineScreen()}),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFB3D9FF)),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(23.dp),
    ) {

        Row() {

            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Your Vaccines", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(13.dp))
                // Replace with your circular progress indicator
                Text(text = "65%", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(13.dp))
                Text(text = "Your previous vaccines", fontSize = 14.sp, color = Color.Black)
            }

            Image(painter = painterResource(id = R.drawable.vaccineimage), contentDescription = "Medicine",
                modifier =Modifier.padding(start=10.dp,top=0.dp,bottom=10.dp)
                    .clickable  (onClick = {navigationManager.navigateToPreviousVaccineScreen()})
            )

        }
    }
}