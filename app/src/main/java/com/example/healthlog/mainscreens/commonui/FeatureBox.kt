package com.example.healthlog.mainscreens.commonui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors

import androidx.compose.material3.Text


import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthlog.core.NavigationManager

@Composable
fun FeatureBox(
    featureText: String,
    image: ImageBitmap,
    onClick:()-> Unit

) {
    val realBlueColor = Color(0, 127, 255) // this is azure blue
    Card(
        modifier = Modifier.padding(8.dp)
            .fillMaxWidth()
            .clickable { onClick() },
        //make it clickable and pass a onClick lambda
        // do something for colors
        shape = RoundedCornerShape(8.dp),
        colors = CardColors(contentColor = androidx.compose.ui.graphics.Color.White, containerColor = realBlueColor, disabledContainerColor = androidx.compose.ui.graphics.Color.Gray, disabledContentColor = androidx.compose.ui.graphics.Color.White)

    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            // Text for feature
            Text(
                text = featureText,
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Medium, fontStyle = FontStyle.Normal),
                color = androidx.compose.ui.graphics.Color.White
            )
//            Spacer(modifier = Modifier.width(100.dp))
            Spacer(modifier = Modifier.weight(1.59f))
//Card(
//    colors = CardColors(contentColor = androidx.compose.ui.graphics.Color.White, containerColor = Color.Blue, disabledContainerColor = androidx.compose.ui.graphics.Color.Gray, disabledContentColor = androidx.compose.ui.graphics.Color.White),
//modifier = Modifier.fillMaxWidth(0.5f)
//) {
    Image(
        bitmap = image,
        contentDescription = "Feature Image",
        modifier = Modifier.size(50.dp)
        .fillMaxWidth()
            .fillMaxSize(),
        contentScale = ContentScale.Fit,
        alignment = Alignment.CenterEnd
    )
//}
        }

    }
}