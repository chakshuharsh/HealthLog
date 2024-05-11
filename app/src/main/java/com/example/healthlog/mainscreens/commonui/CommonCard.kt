package com.example.healthlog.mainscreens.commonui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CommonCard(

){
    val lightBlue = Color(0xFF4169E1)
val commonCardColor = Color(25, 25, 112)
    val topBarForFeaturesColor = Color(25, 25, 112)
    Card(
        modifier = Modifier.height(50.dp)
            .fillMaxWidth(),
        colors = CardColors(containerColor = commonCardColor, contentColor = Color.White, disabledContainerColor = Color.Gray, disabledContentColor = Color.Gray),
        shape = RoundedCornerShape(0.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween,

        ) {
            TextButton(onClick = {  },
modifier = Modifier.padding(start =1.dp)
    .fillMaxWidth(0.5f)
                ) {
                Text(text ="NEW",
                    maxLines = 1,
                    fontSize = 20.sp,
                    color = Color.White,
                    letterSpacing = 3.sp
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            TextButton(onClick = {  },
            modifier = Modifier.padding(end= 10.dp)
                .fillMaxWidth()
                ) {
                Text(text ="PREVIOUS",
                    maxLines = 1,
                    fontSize = 20.sp,
                    color = Color.White,
                    letterSpacing = 3.sp
                )
            }
        }
    }  // contains two buttons for new and previous
}