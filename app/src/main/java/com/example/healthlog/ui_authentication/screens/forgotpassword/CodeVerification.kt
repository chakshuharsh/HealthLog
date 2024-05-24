package com.example.healthlog.ui_authentication.screens.forgotpassword

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthlog.R


@Composable
fun CodeVerification() {




    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp, start = 15.dp, bottom = 3.dp, end = 15.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {


            Text(
                text = stringResource(id = R.string.app_name),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black
            )

            Text(
                text = stringResource(id = R.string.Create_Account),
                color = Color(0xFF4169E1),
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                textDecoration = TextDecoration.Underline,
                //clickable
            )


        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 7.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Image(
                painter = painterResource(id = R.drawable.icon_for_forget_password_foreground),
                contentDescription = "Icon for email verification",
                modifier = Modifier.size(50.dp)
            )
            //place a biometric icon here


            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = stringResource(id = R.string.Reset_Password),
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,

                )

            Text(
                text = stringResource(id = R.string.Code_sent),
                color = Color.Gray,
            )
            // add another text composable for user email and pass it to this screen via EmailInput screen
            //add that text along with above text composable

            Spacer(modifier = Modifier.height(30.dp))


        }

    }
}


