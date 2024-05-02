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

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


import com.example.healthlog.R

import com.example.healthlog.core.NavigationManager
import com.example.healthlog.core.HealthLogAppState


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignupScreen( navigationManager: NavigationManager){
    val viewModel = remember { SignupScreenViewModel() }

    var nameState= remember{ mutableStateOf("") }

    var emailState = remember { mutableStateOf("") }
    var passwordState =  remember { mutableStateOf("")}
    var passwordVisibility by remember { mutableStateOf(true) }

    val emailFocusRequester = remember { FocusRequester() }

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    val passwordFocusRequester = remember { FocusRequester() }

    val nameFocusRequester = remember { FocusRequester() }



var showError by remember{mutableStateOf(false)}


    if(viewModel.isUserExists){
        showError = true
    }


    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,


        ) {

        Text(
            text = "Welcome to HealthLog", fontSize = 25.sp, color = Color.Black,fontWeight = FontWeight.Bold,
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
            modifier = Modifier.padding(top = 8.dp, start = 20.dp),
            fontSize = 17.sp,
            textAlign = TextAlign.Start
        )
//
        OutlinedTextField(
            value = nameState.value,
            onValueChange = { nameState.value = it },
            modifier = Modifier
                .padding(top = 8.dp, start = 4.dp)
                .focusRequester(nameFocusRequester)
                .fillMaxWidth(0.9f)
                .align(Alignment.CenterHorizontally)
                .width(500.dp),

            placeholder = { Text("ex :John Doe") },
            textStyle = LocalTextStyle.current.copy(color = Color.Black),
            singleLine = true,
            shape = RoundedCornerShape(20.dp),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                autoCorrect = false,
                keyboardType = KeyboardType.Text,

            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    keyboardController?.hide()
                    focusManager.clearFocus()
                    emailFocusRequester.requestFocus()}),
        )

        Spacer(modifier = Modifier.height(15.dp))


        Text(
            text = "Enter Email",
            color = Color.Black,
            modifier = Modifier.padding(top = 8.dp, start = 20.dp).focusRequester(emailFocusRequester),
            fontSize = 17.sp,
            textAlign = TextAlign.Start
        )
//        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            modifier = Modifier
                .focusRequester(emailFocusRequester)
                .padding(top = 8.dp, start = 4.dp)
                .fillMaxWidth(0.9f)
                .align(Alignment.CenterHorizontally)
                .width(500.dp),
            placeholder = { Text("ex :hello@email.com") },
            textStyle = LocalTextStyle.current.copy(color = Color.Black),
            singleLine = true,
            shape = RoundedCornerShape(20.dp),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email,
                autoCorrect = false,
            ),
            keyboardActions = KeyboardActions(
                onNext = {

                    keyboardController?.hide()
                    focusManager.clearFocus()
                    passwordFocusRequester.requestFocus()

                }
            ),
            isError = isEmailValid(emailState.value),

        )

        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Enter Password",
            color = Color.Black,
            modifier = Modifier.padding(top = 8.dp, start = 20.dp),
            fontSize = 17.sp,
            textAlign = TextAlign.Start
        )
//        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = passwordState.value,
            onValueChange = { newValue:String ->
                passwordState.value = newValue // Update the passwordState value
            },
            modifier = Modifier
                .padding(top = 8.dp, start = 4.dp)
                .fillMaxWidth(0.9f)
                .focusRequester(passwordFocusRequester)
                .align(Alignment.CenterHorizontally)
                .width(500.dp),
            textStyle = LocalTextStyle.current.copy(color = Color.Black),


            singleLine = true,
            shape = RoundedCornerShape(20.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done,
                autoCorrect = false,
                keyboardType = KeyboardType.Password,
            ),
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                })
                {
                    val icon: Painter = if (passwordVisibility) {
                        painterResource(id = R.drawable.visibilityopen)
                    } else {
                        painterResource(id = R.drawable.visibility_off)
                    }
                    Icon(painter = icon, contentDescription = "Toggle visibility")
                }
            },
            keyboardActions = KeyboardActions(onDone = {
                keyboardController?.hide()
                focusManager.clearFocus()
            }),
            visualTransformation = if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation()
        )



        Spacer(modifier = Modifier.height(27.dp))
//viewModel.doesUserExist(emailState.value, passwordState.value, nameState.value)
        Button(
            onClick = {

                      if(emailState.value.isEmpty()){
                          emailFocusRequester.requestFocus()
                      }

                if(passwordState.value.isEmpty()){
                    passwordFocusRequester.requestFocus()
                }

                if(nameState.value.isEmpty()){
                    nameFocusRequester.requestFocus()
                }
else{
    viewModel.doesUserExist(emailState.value,passwordState.value,nameState.value)
                }

            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4169E1)),
            modifier = Modifier
                        .fillMaxWidth(0.9f)
                .align(Alignment.CenterHorizontally)
                        .padding(16.dp) ,
            shape = RoundedCornerShape(8.dp),
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
        modifier = Modifier
            .clickable(onClick = { navigationManager.navigateToLogin()})
            .padding(top = 8.dp),
        fontSize = 15.sp,
        textAlign = TextAlign.Center
    )

    Spacer(modifier = Modifier.height(15.dp))


}

        if(showError){
            Text(
                text = "Account already exists, Login instead",
                color = Color.Red,
                modifier = Modifier
                    .padding(top = 8.dp, start = 16.dp)
            )
        }

    }
}

 fun isEmailValid(email: String): Boolean {
    val emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}".toRegex()
     return emailPattern.matches(email)
 }







