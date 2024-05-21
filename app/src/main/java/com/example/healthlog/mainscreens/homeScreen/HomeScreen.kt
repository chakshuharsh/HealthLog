package com.example.healthlog.mainscreens.homeScreen



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthlog.R


import com.example.healthlog.core.NavigationManager
import com.example.healthlog.mainscreens.commonui.BottomBar

val cardColor = Color(0, 127, 255) // this is azure blue
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen( navigationManager: NavigationManager){

Scaffold(
    bottomBar = {
        BottomBar(navigationManager)
    }

) {innerPadding->

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE6F0FA))
            .padding(innerPadding)
    ){

        TopBarHomeScreen(navigationManager)
        Spacer(modifier = Modifier.height(35.dp))
        Text(text = "Hi! Chakshu Harsh",
            fontSize = 25.sp,
            modifier = Modifier.padding(start=79.dp),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.SansSerif
        )
        Spacer(modifier = Modifier.height(45.dp))
        SummarySection()
        Spacer(modifier = Modifier.height(15.dp))
        MedicineSection()

    }
    }


    }

@Composable
fun TopBarHomeScreen(navigationManager: NavigationManager) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = { navigationManager.navigateToProfileScreen()}) {
            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu", tint = Color.DarkGray)
        }

       Card(
           shape = CircleShape,
           modifier = Modifier.clickable ( onClick ={} ),
           colors = CardDefaults.cardColors(containerColor = cardColor),
       ){

       }
    }
}


@Composable
fun SummarySection() {
    Row(
        modifier = Modifier.fillMaxWidth()
            ,
        horizontalArrangement = Arrangement.Center
    ) {
        SummaryCard("2,000", "Kcal burnt",R.drawable.calories)
Spacer(modifier = Modifier.width(5.dp))
        SummaryCard("5,000", "Step to walk",R.drawable.footprint)
    }
}





@Composable
fun SummaryCard(value: String, label: String,imageId:Int) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .height(180.dp)
            .padding(start = 0.dp, end = 8.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor),

        shape = RoundedCornerShape(27.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = imageId.toInt()),
                contentDescription = "Icon for email verification",
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = value, fontSize = 28.sp, fontWeight = FontWeight.Bold,color=Color.White)
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = label, fontSize = 12.sp,color=Color.White)
        }
    }
}



@Composable
fun MedicineSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(start = 20.dp, end = 0.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFB3D9FF)),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(23.dp),
    ) {

        Row() {

            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Your Medication", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(13.dp))
                // Replace with your circular progress indicator
                Text(text = "65%", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(13.dp))
                Text(text = "Your medicine report", fontSize = 14.sp, color = Color.Black)
            }

      Image(painter = painterResource(id = R.drawable.medicine), contentDescription = "Medicine",
          modifier =Modifier.padding(start=10.dp,top=0.dp,bottom=10.dp))

        }
     }
}

