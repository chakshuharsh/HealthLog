package com.example.healthlog.ui_authentication.screens.forgotpassword.emailVerification

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.healthlog.R
import com.example.healthlog.core.NavigationManager
import com.example.healthlog.ui_authentication.screens.signup.SignupScreenViewModel
import com.example.healthlog.ui_authentication.screens.signup.isEmailValid


// pass some functions for clickable :-
// create acc -> make it clickable
// Reset password
// Back to login


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun EmailInput(navigationManager: NavigationManager){
    val viewModel = remember { EmailVerificationViewModel() }
    var emailStateVerificatrion = remember { mutableStateOf("") }

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    Column(modifier= Modifier
        .fillMaxSize()
        .padding(top = 10.dp, start = 15.dp, bottom = 3.dp, end = 15.dp)
    ) {
        Row(
            modifier=Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){


            Text(
                text= stringResource(id = R.string.app_name),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
               color = Color.Black
            )

            Text(
                text= stringResource(id = R.string.Create_Account),
                color = Color(0xFF4169E1),
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable(onClick = {navigationManager.navigateToSignup()})
            )



        }

        Spacer(modifier = Modifier.height(20.dp))


        Column(
            modifier= Modifier
                .fillMaxSize()
                .padding(start = 7.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ){

Image(
    painter = painterResource(id = R.drawable.icon_for_forget_password_foreground),
    contentDescription = "Icon for email verification",
            modifier = Modifier.size(50.dp)
)
            //place a biometric icon here


            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text= stringResource(id = R.string.Forgot_Password),
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,

                )

            Text(
                text= stringResource(id = R.string.No_worries),
                color = Color.Gray,
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = stringResource(id = R.string.Email),
                color = Color.Black,
                fontSize = 17.sp,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 45.dp)
            )


            OutlinedTextField(
                value = emailStateVerificatrion.value,
                onValueChange = { emailStateVerificatrion.value = it },
                modifier = Modifier
                    .padding(top = 8.dp, start = 16.dp)
                    .fillMaxWidth(0.9f)
                    .width(500.dp),
                placeholder = { Text("ex :hello@email.com") },
                textStyle = LocalTextStyle.current.copy(color = Color.Black),
                singleLine = true,
                shape = RoundedCornerShape(20.dp),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Email,
                    autoCorrect = false,
                ),
                keyboardActions = KeyboardActions(onDone = {
                    keyboardController?.hide()
                    focusManager.clearFocus()
                }),
                isError = isEmailValid(emailStateVerificatrion.value),
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {viewModel.emailVerification(emailStateVerificatrion.value)},

                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4169E1)),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(16.dp),

                shape = RoundedCornerShape(8.dp),

            ) {
                Text(
                    text = stringResource(id = R.string.Reset_Password),
                    fontSize=20.sp
                )
            }
            Text(
                text= stringResource(id = R.string.Back_To_Login),
                color = Color.Gray,
                modifier =Modifier.clickable(onClick = {navigationManager.navigateToLogin()}),
                textDecoration = TextDecoration.Underline,
            )

        }


    }


}



