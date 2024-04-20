package com.example.healthlog.mainscreens.commonui

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FeatureBox(
    featureText: String,
    image: ImageBitmap,

) {

    Card(
        modifier = Modifier.padding(8.dp)
            .fillMaxWidth(),
        //make it clickable and pass a onClick lambda
        // do something for colors
        shape = RoundedCornerShape(8.dp),
//        colors = CardColors(contentColor = myColor, containerColor = Color.BLUE, disabledContainerColor = androidx.compose.ui.graphics.Color.Gray, disabledContentColor = Color.BLACK)

    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            // Text for feature
            Text(
                text = featureText,
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                color = androidx.compose.ui.graphics.Color.Blue
            )
            Spacer(modifier = Modifier.width(50.dp))

            Image(
                bitmap = image,
                contentDescription = "Feature Image",
                modifier = Modifier.size(50.dp),
                contentScale = ContentScale.Fit,
                alignment = Alignment.CenterEnd
            )

        }

    }
}