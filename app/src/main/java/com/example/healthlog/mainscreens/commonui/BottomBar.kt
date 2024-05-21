package com.example.healthlog.mainscreens.commonui


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.healthlog.R
import com.example.healthlog.core.NavigationManager


// pass navigatin lambdas for the home and other icons

@Composable
fun BottomBar(navigationManager: NavigationManager){

    val bottomBarColor =Color(25, 25, 112)

Card(
   colors= CardColors(containerColor = bottomBarColor, contentColor = Color.White, disabledContentColor = Color.Gray, disabledContainerColor = bottomBarColor),
            shape = RoundedCornerShape(16.dp),
    modifier=Modifier.padding(start=5.dp,end=5.dp,bottom =5.dp)
) {
    BottomAppBar(

        actions = {
            Row(
                modifier = Modifier.padding(start = 4.dp)
            ) {
                Card(
                    colors = CardDefaults.cardColors(containerColor = bottomBarColor),
                    shape = CircleShape,


                ) {
                    IconButton(onClick = {
                        navigationManager.navigateToHomeScreen()
                   })
                    {
                        Icon(
                            painter = painterResource(id = R.drawable.home,),
                            contentDescription = "Home Icon for bottom bar",
                            modifier = Modifier.size(27.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(90.dp))

                Card(
                    colors = CardDefaults.cardColors(containerColor = bottomBarColor),
                            shape = CircleShape,

                ) {
                    IconButton(onClick = {
                        navigationManager.navigateToFeatureScreen()
                        }) {
                        Icon(
                            painter = painterResource(id = R.drawable.featureicon),
                            contentDescription = "Feature Icon",
                            modifier = Modifier.size(27.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(90.dp))

                Card(
                    colors = CardDefaults.cardColors(containerColor = bottomBarColor),
                    shape = CircleShape
                ) {
                    IconButton(onClick = {
                        navigationManager.navigateToInterestsScreen()
                      }) {
                        Icon(
                            painter = painterResource(id = R.drawable.notifications),
                            contentDescription = "Feed icon",
                            modifier = Modifier.size(27.dp)

                        )
                    }
                }
            }
        },
        modifier = Modifier.height(60.dp).fillMaxSize()
            .padding(start = 4.dp, top = 5.dp, end = 4.dp, bottom = 4.dp),
        containerColor = bottomBarColor,
        contentColor = Color.White,

        )
}

}