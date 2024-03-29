package com.example.healthlog.ui_authentication.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement.Center
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp






@Composable
fun LoginScreen(){
    val emailState=remember{mutableStateOf("")}
    val passwordState=remember{mutableStateOf("")}
    var isClicked:Boolean by remember { mutableStateOf(false) }// scrap remove it in  production

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize(0.9f)
                .padding(horizontal = 16.dp),
            verticalArrangement = Center
        ) {
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Sign In", fontSize = 30.sp, color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            // We missed you so much text
            Text(
                text = "Hi! Welcome back, you have been missed",
                color = Color.Gray,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .align(Alignment.CenterHorizontally),
                fontSize = 10.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))



            Text(
                text = "Email",
                color = Color.Black,
                modifier = Modifier.padding(top = 8.dp),
                fontSize = 20.sp,
                textAlign = TextAlign.Left
            )
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                value = emailState.value,
                onValueChange = { emailState.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .width(500.dp),
                placeholder = { Text("example@gmail.com") },
                textStyle = LocalTextStyle.current.copy(color = Color.Black),
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { /* Move focus to password field */ })
            )

            Text(
                text = "Password",
                color = Color.Black,
                modifier = Modifier.padding(top = 8.dp),
                fontSize = 20.sp,
                textAlign = TextAlign.Left
            )
            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(
                value = passwordState.value,
                onValueChange = { passwordState.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .width(100.dp),
                textStyle = LocalTextStyle.current.copy(color = Color.Black),
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { /* Move focus to password field */ })
            )

            Spacer(modifier = Modifier.height(15.dp))


            Text(
                text = "Forgot Password",
                modifier = Modifier
                    .clickable(onClick = { isClicked = true })
                    .align(Alignment.End),
                color = Color.Blue,
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { isClicked = false },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp)) // Adjust corner radius as needed
            ) {
                Text(text = "Sign In")
            }
            Spacer(modifier = Modifier.height(50.dp))


        }

        Row() {

            Text(
                text = "Don't have an account?",
                modifier = Modifier.padding(end = 4.dp)
            )
            Text(
                text = "Sign Up",
                color = Color.Blue,
                modifier = Modifier.clickable(onClick = { isClicked = false })

            )
        }

    }
}




@Preview
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}