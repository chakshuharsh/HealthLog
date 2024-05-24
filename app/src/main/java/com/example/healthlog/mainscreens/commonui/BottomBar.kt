package com.example.healthlog.mainscreens.commonui


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.FloatingActionButton

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
    val bottomBarColor = Color.Black
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


                    IconButton(onClick = { /* Handle action icon click */ }) {
                        Icon(
                            modifier = Modifier.size(100.dp),
                            painter = painterResource(id = R.drawable.home_health_24dp_fill0_wght400_grad0_opsz24), contentDescription = null
                        )
                    }

                Spacer(modifier = Modifier.width(90.dp))



                IconButton(onClick = { /* Handle action icon click */ }) {
                    Icon(
                        modifier = Modifier.size(100.dp),
                        painter = painterResource(id = R.drawable.admin_meds_40dp_fill0_wght400_grad0_opsz40), contentDescription = null
                    )
                }

                Spacer(modifier = Modifier.width(90.dp))


                IconButton(onClick = { /* Handle action icon click */ }) {
                    Icon(
                        modifier = Modifier.size(100.dp),
                        painter = painterResource(id = R.drawable.clinical_notes_40dp_fill0_wght400_grad0_opsz40), contentDescription = null
                    )
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