package com.example.healthlog.mainscreens.commonui



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

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

    val buttonColor = Color(25, 25, 112)

Card(
    modifier = Modifier.fillMaxHeight(0.099f),
    shape = RoundedCornerShape(0.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFFE6F0FA))


) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,

        ) {
        TextButton(
            onClick = {

                onNewClick()
            },
            modifier = Modifier.padding(start = 15.dp, top = 0.dp)
                .width(120.dp),
            colors = ButtonDefaults.textButtonColors(containerColor = Color(0xFF3A5FC0)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = "NEW",
                maxLines = 1,
                fontSize = 15.sp,
                color = Color.White,
                letterSpacing = 1.sp
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        TextButton(
            onClick = {

                onPreviousClick()
            },
            modifier = Modifier.padding(end = 15.dp, top = 0.dp).width(130.dp),
            colors = ButtonDefaults.textButtonColors(containerColor = Color(0xFF3A5FC0)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = "PREVIOUS",
                maxLines = 1,
                fontSize = 15.sp,
                color = Color.White,
                letterSpacing = 1.sp
            )
        }
    }
}
      // contains two buttons for new and previous
}