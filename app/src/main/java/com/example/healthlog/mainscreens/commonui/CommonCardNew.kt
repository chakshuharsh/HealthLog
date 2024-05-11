package com.example.healthlog.mainscreens.commonui



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CommonCardNew(
    onNewClick: () -> Unit,
    onPreviousClick: () -> Unit
){

    val commonCardColor = Color(25, 25, 112)
//    val topBarForFeaturesColor = Color(25, 25, 112)
//    var previousButtonColor =remember{mutableStateOf(Color.Gray)}
//    var newbuttonColor =remember{mutableStateOf(commonCardColor)}

    var newTextColor = remember{ mutableStateOf(Color.White) }
    var prevTextColor = remember{ mutableStateOf(Color.Black) }

    Row(
            modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,

        ) {
            TextButton(onClick = {
//                previousButtonColor.value=Color.LightGray
//                                 newbuttonColor.value=commonCardColor
//                newTextColor.value=Color.White
//                prevTextColor.value=Color.Black
                onNewClick()},
                modifier = Modifier.padding(start =15.dp)
                    .width(120.dp),
                colors= ButtonDefaults.textButtonColors(containerColor = commonCardColor),
shape = RoundedCornerShape(12.dp)
            ) {
                Text(text ="NEW",
                    maxLines = 1,
                    fontSize = 15.sp,
                    color = newTextColor.value,
                    letterSpacing = 1.sp
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            TextButton(onClick = {
//                                 previousButtonColor.value = commonCardColor
//                                 newbuttonColor.value=Color.LightGray
//                                 newTextColor.value=Color.Black
//                prevTextColor.value=Color.White
                onPreviousClick()
                                 },
                modifier = Modifier.padding(end= 15.dp).width(130.dp),
                colors= ButtonDefaults.textButtonColors(containerColor = commonCardColor),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(text ="PREVIOUS",
                    maxLines = 1,
                    fontSize = 15.sp,
                    color = prevTextColor.value,
                    letterSpacing = 1.sp
                )
            }
        }
      // contains two buttons for new and previous
}