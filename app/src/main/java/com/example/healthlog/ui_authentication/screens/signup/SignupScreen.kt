package com.example.healthlog.ui_authentication.screens.signup



import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SignupScreen(){
    val viewModel = remember { SignupScreenviewmodel() }
    var isClicked2:Boolean by remember { mutableStateOf(false) }
    var nameState= remember{ mutableStateOf("") }
    var dOBState= remember{ mutableStateOf("") }
    var numberState= remember{ mutableStateOf("") }
    var genderState= remember{ mutableStateOf("") }
    var emailState = remember { mutableStateOf("") }
    var passwordState =  remember { mutableStateOf("")}

    var dateDropdownExpanded = remember { mutableStateOf(true) }
    var monthDropdownExpanded = remember { mutableStateOf(true) }
    var yearDropdownExpanded = remember { mutableStateOf(true) }



    var selectedDate = remember { mutableIntStateOf(1) }
    var selectedMonth = remember { mutableIntStateOf(1) }
    var selectedYear = remember { mutableIntStateOf(2024) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,

        ) {

        Text(
            text = "Welcome to HealthLog", fontSize = 30.sp, color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Text(
            text = "Please Introduce yourself",
            color = Color.Gray,
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.CenterHorizontally),
            fontSize = 15.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Enter Name",
            color = Color.Black,
            modifier = Modifier.padding(top = 8.dp, start = 16.dp),
            fontSize = 20.sp,
            textAlign = TextAlign.Start

        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = nameState.value,
            onValueChange = { nameState.value = it },
            modifier = Modifier.padding(top = 8.dp, start = 16.dp)
                .fillMaxWidth(0.9f)
                .width(500.dp),
            placeholder = { Text("ex :John Doe") },
            textStyle = LocalTextStyle.current.copy(color = Color.Black),
            singleLine = true,
            shape = RoundedCornerShape(20.dp),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { /* Move focus to password field */ })
        )

        Text(
            text = "Enter Email",
            color = Color.Black,
            modifier = Modifier.padding(top = 8.dp, start = 16.dp),
            fontSize = 20.sp,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            modifier = Modifier.padding(top = 8.dp, start = 16.dp)
                .fillMaxWidth(0.9f)
                .width(500.dp),
            placeholder = { Text("ex :hello@email.com") },
            textStyle = LocalTextStyle.current.copy(color = Color.Black),
            singleLine = true,
            shape = RoundedCornerShape(20.dp),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = {   })
        )


        Text(
            text = "Enter Password",
            color = Color.Black,
            modifier = Modifier.padding(top = 8.dp, start = 16.dp),
            fontSize = 20.sp,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = passwordState.value,
            onValueChange = { passwordState.value = it },
            modifier = Modifier.padding(top = 8.dp, start = 16.dp)
                .fillMaxWidth(0.9f)
                .width(500.dp),
            textStyle = LocalTextStyle.current.copy(color = Color.Black),
            singleLine = true,
            shape = RoundedCornerShape(20.dp),
//            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),

            keyboardActions = KeyboardActions(onNext = {  })
        )






//        Text(
//            text = "Enter Date of Birth",
//            color = Color.Black,
//            modifier = Modifier.padding(top = 8.dp,start=4.dp),
//            fontSize = 20.sp,
//            textAlign = TextAlign.Left
//        )
//        Spacer(modifier = Modifier.height(15.dp))


//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.spacedBy(8.dp)
//        ){
//
//            DropdownMenu(expanded = dateDropdownExpanded.value, onDismissRequest = { dateDropdownExpanded.value=false })
//            {
//
//
//                for(day in 1..30){
//
//                    DropdownMenuItem(text = {day.toString() }, onClick = { selectedDate.intValue=day })
//
//                }
//
//
//
//            }
//
//
//
//
//
//
//            DropdownMenu(
//                expanded = monthDropdownExpanded.value,
//                onDismissRequest = { monthDropdownExpanded.value=false }
//            ){
//
//                val months = listOf(
//                    "Jan", "Feb", "Mar", "Apr", "May", "Jun",
//                    "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")
//
//
//                for((index,month) in months.withIndex()) {
//                    DropdownMenuItem(text = { month}, onClick = { selectedMonth.intValue=index+1 })
//
//                }
//            }
//
//
//            DropdownMenu(expanded = yearDropdownExpanded.value, onDismissRequest = { yearDropdownExpanded.value = false }) {
//
//                val currentYear=2024
//                val years=(1900..currentYear).toList().reversed()
//                for(year in years){
//
//                    DropdownMenuItem(text = { year.toString() }, onClick = { selectedYear.intValue=year })
//
//                }
//            }
//
//
//        }

//
//        Text(
//            text = "Mobile Number",
//            color = Color.Black,
//            modifier = Modifier.padding(top = 8.dp,start=4.dp),
//            fontSize = 20.sp,
//            textAlign = TextAlign.Left
//        )
//        Spacer(modifier = Modifier.height(15.dp))
//
//        OutlinedTextField(
//            value = numberState.value,
//            onValueChange = { numberState.value = it },
//            modifier = Modifier
//                .fillMaxWidth(0.8f)
//                .width(100.dp),
//            textStyle = LocalTextStyle.current.copy(color = Color.Black),
//            singleLine = true,
//            shape = RoundedCornerShape(20.dp),
//            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
//            keyboardActions = KeyboardActions(onNext = { /* Move focus to password field */ })
//        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {  viewModel.signUp(emailState.value,passwordState.value)},

            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp)) // Adjust corner radius as needed
        ) {
            Text(text = "Sign Up",
                fontSize=25.sp)
        }

Row(modifier=Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically) {
    Text(
        text = "Already have an account! ",
        color = Color.Gray,
        modifier = Modifier
            .padding(top = 8.dp),
        fontSize = 15.sp,
        textAlign = TextAlign.Center
    )

    Text(
        text = "Login",
        color = Color.Blue,
        modifier = Modifier.clickable(onClick ={isClicked2=true} )
            .padding(top = 8.dp),
        fontSize = 15.sp,
        textAlign = TextAlign.Center
    )
}

    }
}




@Preview
@Composable
fun PreviewSignupScreen() {
    SignupScreen()
}