package com.example.healthlog.mainscreens.features.featuresScreen.labreport

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthlog.core.NavigationManager
import com.example.healthlog.mainscreens.commonui.BottomBar
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LabReportScreen(navigationManager: NavigationManager) {
    var LabReportTitleState = remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    val bottomSheetState = rememberModalBottomSheetState()

    var isButtonEnabled = remember { mutableStateOf(false) }

    val saveButtonColor = Color(0, 127, 255) // this is azure blue

    val scope = rememberCoroutineScope()
    val realBlueColor = Color(74, 86, 119)
    Scaffold(
        bottomBar = {
            BottomBar(navigationManager)
        }

    ) {innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFE6F0FA))
                .padding(innerPadding)
        ) {

            Text(
                text = "HealthLog",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 0.dp, top = 5.dp,start=5.dp),
                fontStyle = FontStyle.Normal
            )



            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(top = 85.dp, start = 0.dp)
                    .fillMaxWidth()
            ) {

                Text(
                    text = "Please Upload Valid Lab Report",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 8.dp),
                    color = Color.Black
                )

                Text(
                    text = "image from a Certified hospital",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 8.dp),
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Always upload a clear copy of your report",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(bottom = 0.dp, start = 0.dp),
                    color = Color.Gray,

                    )



                Spacer(modifier = Modifier.height(50.dp))

                Box(
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(16.dp))
                        .padding(16.dp)
                        .height(160.dp)
                        .width(290.dp)
                        .clickable {
                            scope.launch { bottomSheetState.show() }
                        }
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        IconButton(onClick = { scope.launch { bottomSheetState.show() } }) {
                            Icon(
                                imageVector = Icons.Default.Add, // Replace with actual upload icon
                                contentDescription = "Upload Icon"
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Upload Your Lab Report here",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(bottom = 8.dp),
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.height(22.dp))
                        Button(
                            onClick = { scope.launch { bottomSheetState.show() } },
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.width(150.dp),
                            colors = ButtonColors(
                                containerColor = saveButtonColor,
                                contentColor = Color.White,
                                disabledContainerColor = Color.Gray,
                                disabledContentColor = Color.Cyan
                            ),
                        ) {
                            Text("Upload Here")

                        }
                    }
                }

//            if(showBottomSheet.value){
//
//                ModalBottomSheet(
//                    onDismissRequest = {
//                        showBottomSheet.value = false
//                    },
//                    sheetState = bottomSheetState
//                ){
//                    TextButton(onClick = {}) {
//                        Text(text = "Gallery", fontSize = 18.sp)
//                    }
//                    Spacer(modifier = Modifier.height(16.dp))
//                    TextButton(onClick = {}) {
//                        Text(text = "Camera", fontSize = 18.sp)
//                    }
//                }
//
//            }

                Spacer(modifier = Modifier.height(46.dp))

                Box(
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(8.dp))
                        .padding(16.dp)
                        .height(18.dp)
                        .width(290.dp)
                ) {

                    Text(
                        text = "Prescription Guide",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Gray
                    )

                }

                Spacer(modifier = Modifier.height(24.dp))

                OutlinedTextField(
                    value = LabReportTitleState.value,
                    onValueChange = { LabReportTitleState.value = it },
                    modifier = Modifier
                        .padding(start = 0.dp)
                        .fillMaxWidth(0.9f)
                        .height(50.dp)
                        .width(400.dp),
                    shape = RoundedCornerShape(8.dp),
                    placeholder = {
                        Text(
                            text = "Title",
                            fontSize = 15.sp
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done,
                        keyboardType = KeyboardType.Email,
                        autoCorrect = false,
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                            focusManager.clearFocus()
                        },

                        ),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedBorderColor = Color.LightGray,
                        unfocusedBorderColor = Color.LightGray,
                    )
                )
                Spacer(modifier = Modifier.height(14.dp))
                Button(
                    onClick = { focusManager.clearFocus() },
                    colors = ButtonColors(
                        containerColor = saveButtonColor,
                        contentColor = Color.White,
                        disabledContainerColor = Color.Gray,
                        disabledContentColor = Color.Cyan
                    ),
                    enabled = !isButtonEnabled.value,
                    modifier = Modifier
                        .padding(start = 15.dp, end = 15.dp)
                        .width(350.dp),
                    shape = RoundedCornerShape(11.dp)

                ) {
                    Text(
                        text = "SAVE",
                        fontSize = 21.sp,
                        letterSpacing = 10.sp
                    )


                }


            }


        }


        if (bottomSheetState.isVisible) {
            ModalBottomSheet(
                onDismissRequest = {
                    scope.launch { bottomSheetState.hide() }
                },
                sheetState = bottomSheetState,
                modifier = Modifier.padding(top = 0.dp, bottom = 0.dp)

            ) {

                Column(
                    modifier = Modifier
                        .padding(bottom = 16.dp, top = 0.dp)
                        .fillMaxWidth(),


                    ) {

                    TextButton(onClick = {}) {
                        Text(
                            text = "Gallery",
                            fontSize = 18.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily.SansSerif,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 14.dp),
                            letterSpacing = 2.sp

                        )
                    }
                    Spacer(modifier = Modifier.height(2.dp))
                    TextButton(onClick = {}) {
                        Text(
                            text = "Camera", fontSize = 18.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily.SansSerif,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 14.dp),
                            letterSpacing = 2.sp

                        )
                    }
                }
            }
        }

    }
}
