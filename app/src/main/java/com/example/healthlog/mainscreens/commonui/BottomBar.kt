package com.example.healthlog.mainscreens.commonui


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.healthlog.R
import com.example.healthlog.core.NavigationManager


// pass navigatin lambdas for the home and other icons

@Composable
fun BottomBar(navigationManager: NavigationManager){
    val lightBlue = Color(0xFF4169E1)

BottomAppBar (

    actions = {
        Row(
            modifier = Modifier.padding(start = 4.dp)
        ) {
            IconButton(onClick = { navigationManager.navigateToHomeScreen()}) {
                Icon(
                    painter = painterResource(id = R.drawable.home,),
                    contentDescription = "Home Icon for bottom bar",
                    modifier = Modifier.size(30.dp)
                )
            }

            Spacer(modifier = Modifier.width(90.dp))

            IconButton(onClick = { navigationManager.navigateToFeatureScreen()}) {
                Icon(
                    painter = painterResource(id = R.drawable.featureicon),
                    contentDescription = "Feature Icon",
                    modifier = Modifier.size(30.dp)
                )
            }

            Spacer(modifier = Modifier.width(90.dp))

            IconButton(onClick = {navigationManager.navigateToInterestsScreen() }) {
                Icon(
                    painter = painterResource(id = R.drawable.notifications),
                    contentDescription = "Feed icon",
                    modifier = Modifier.size(30.dp)
                )
            }

        }
    },
    modifier = Modifier.height(60.dp)
        .padding(start = 0.dp, top = 5.dp, end = 0.dp, bottom = 0.dp),
    containerColor = lightBlue,
    contentColor = Color.White,

)


}