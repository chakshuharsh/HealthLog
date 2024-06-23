package com.example.healthlog.ui_authentication.screens.login



import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement.Center

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
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
import com.example.healthlog.core.HealthLogAppState
import com.example.healthlog.core.NavigationManager


@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen( navigationManager: NavigationManager) {


    val viewModel = remember { LoginScreenViewModel() }
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val passwordFocusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    var passwordVisibility by remember { mutableStateOf(true) }
    val realBlueColor = Color(10, 27, 155)
    val darkerColor = Color(74, 86, 119)



            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(darkerColor)
                    .background(Color.Transparent),
                verticalArrangement = Center,
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {


                Image(
                    painter = painterResource(id = R.drawable.doctor3),
                    contentDescription = null,
                    modifier =Modifier.size(142.dp)


                    )
Spacer(modifier=Modifier.height(8.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(bottom =14.dp)
                        .fillMaxHeight(0.8f),
                    shape = RoundedCornerShape(36.dp),
                    colors = CardColors(
                        containerColor = Color.Black,
                        contentColor = Color.White,
                        disabledContainerColor = Color.Unspecified,
                        disabledContentColor = Color.Unspecified
                    )

                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxSize(0.94f)
                            .fillMaxHeight()
                            .padding(start = 15.dp, top = 35.dp),
                        verticalArrangement = Center
                    ) {




                        Text(
                            text = "Hello Again!", fontSize = 30.sp, color = Color.White,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )

                        // We missed you so much text
                        Text(
                            text = "Welcome back, you have been missed",
                            color = Color.White,
                            modifier = Modifier
                                .padding(top = 8.dp, start = 20.dp)
                                .align(Alignment.CenterHorizontally),
                            fontSize = 15.sp,
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(24.dp))



                        Text(
                            text = "Email",
                            color = Color.White,
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
                            placeholder = {
                                Text(
                                    "example@gmail.com",
                                    color = Color.White
                                )
                            },
                            textStyle = LocalTextStyle.current.copy(color = Color.White),
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
                            color = Color.White,
                            modifier = Modifier.padding(top = 8.dp),
                            fontSize = 20.sp,
                            textAlign = TextAlign.Left
                        )
                        Spacer(modifier = Modifier.height(15.dp))

                        OutlinedTextField(
                            value = passwordState.value,
                            onValueChange = { newValue: String ->
                                passwordState.value = newValue // Update the passwordState value
                            },
                            modifier = Modifier
                                .focusRequester(passwordFocusRequester)
                                .fillMaxWidth()
                                .width(100.dp),
                            textStyle = LocalTextStyle.current.copy(color = Color.White),
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
                            else PasswordVisualTransformation(),
//colors=OutlinedTextFieldDefaults.colors(focusedContainerColor = Color.White, focusedBorderColor = Color.White, focusedTextColor = Color.White)
                        )

                        Spacer(modifier = Modifier.height(15.dp))


                        Text(
                            text = "Forgot Password",
                            modifier = Modifier
                                .clickable(onClick = { navigationManager.navigateToEmailInput() })
                                .align(Alignment.End),
                            color = Color.White,
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        Button(
                            onClick = {
                                viewModel.login(

                                    emailState.value,
                                    passwordState.value,
                                    navigationManager
                                )
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp), // Adjust corner radius as needed
                        ) {
                            Text(
                                text = "Sign In",
                                fontSize = 20.sp,
                                color = Color.Black
                            )
                        }


                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row() {

                    Text(
                        text = "Don't have an account?",
                        modifier = Modifier.padding(end = 4.dp),
                        color = Color.White
                    )
                    Text(
                        text = "Sign Up",
                        color = Color.Yellow,
                        modifier = Modifier.clickable(onClick = { navigationManager.navigateToSignup() })

                    )
                }

            }

    }





