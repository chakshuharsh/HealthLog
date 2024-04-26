package com.example.healthlog.ui_authentication.screens.login


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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.healthlog.R
import com.example.healthlog.core.NavigationManager
import com.example.healthlog.core.Screen


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(navigationManager: NavigationManager){

    val viewModel = remember{LoginScreenViewModel(navigationManager)}
    val emailState=remember{mutableStateOf("")}
    val passwordState=remember{mutableStateOf("")}
    val passwordFocusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    var passwordVisibility by remember { mutableStateOf(true) }


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
                text = "Hello Again!", fontSize = 30.sp, color = Color.Black,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            // We missed you so much text
            Text(
                text = "Welcome back, you have been missed",
                color = Color.Gray,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .align(Alignment.CenterHorizontally),
                fontSize = 15.sp,
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
                shape = RoundedCornerShape(20.dp),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Email,
                    autoCorrect = false,
                ),
                keyboardActions = KeyboardActions(onNext = { passwordFocusRequester.requestFocus() })
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
                onValueChange = { newValue:String ->
                    passwordState.value = newValue // Update the passwordState value
                },
                modifier = Modifier
                    .focusRequester(passwordFocusRequester)
                    .fillMaxWidth()
                    .width(100.dp),
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

            Spacer(modifier = Modifier.height(15.dp))


            Text(
                text = "Forgot Password",
                modifier = Modifier
                    .clickable(onClick = { navigationManager.navigateToEmailInput() })
                    .align(Alignment.End),
                color = Color.Blue,
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { viewModel.login(emailState.value,passwordState.value,navigationManager)},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4169E1)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                        shape = RoundedCornerShape(8.dp), // Adjust corner radius as needed
            ) {
                Text(
                    text = "Sign In",
                    fontSize=20.sp
                )
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
                modifier = Modifier.clickable(onClick = {navigationManager.navigateToSignup()})

            )
        }

    }
}




