package com.example.healthlog.mainscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthlog.R
import com.example.healthlog.core.NavigationManager
import com.example.healthlog.mainscreens.commonui.BottomBar
import com.example.healthlog.mainscreens.homeScreen.TopBarHomeScreen
val saveColor = Color(0, 127, 255) // this is azure blue
@Composable
fun ProfileScreen(navigationManager: NavigationManager){
    Scaffold(
        bottomBar = {
            BottomBar(navigationManager)
        }

    ) {innerPadding->

        Column(
            modifier = Modifier
                .padding(top = 0.dp)
                .fillMaxSize()
                .background(Color(0xFFE6F0FA))
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            TopBarProfileScreen(navigationManager)

            Spacer(modifier = Modifier.height(40.dp))
            Card(
                shape = CircleShape,
                modifier= Modifier.size(100.dp)
            ){
                Image(painter = painterResource(id = R.drawable.cold), contentDescription ="User Profile" )

            }
            Spacer(modifier = Modifier.height(0.dp))
            ReadOnlyOutlinedTextFields()


        }





        }

}



@Composable
fun ReadOnlyOutlinedTextFields() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        ReadOnlyOutlinedTextField("Chakshu Harsh")
        Spacer(modifier = Modifier.height(16.dp))
        ReadOnlyOutlinedTextField("chakshuharsh97@gmail.com")
        Spacer(modifier = Modifier.height(16.dp))
          ReadOnlyOutlinedTextField("5'10 Inch")
        Spacer(modifier = Modifier.height(16.dp))
        ReadOnlyOutlinedTextField("64 Kg")

    }
}


@Composable
fun TopBarProfileScreen(navigationManager: NavigationManager) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 45.dp),
        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.width(10.dp))

         Box(
             modifier = Modifier
                 .background(color = Color.White, shape = CircleShape)
                 .size(37.dp)
                 .padding(start = 0.dp)
                     .clickable (onClick = {navigationManager.navigateToHomeScreen()}),
             contentAlignment = Alignment.Center
         ){
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "Menu",
                    tint = Color.DarkGray,
                    modifier=Modifier.clickable (onClick = {navigationManager.navigateToHomeScreen()})

                )
            }
        Spacer(modifier = Modifier.width(100.dp))

        Text(
            text = "Profile",
            color = Color.DarkGray,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.width(110.dp))


        Icon(
            imageVector = Icons.Default.Create,
            contentDescription = "Menu",
            tint = Color.DarkGray,
            modifier = Modifier.clickable (onClick = {})
        )

//        Text(
//            text = "Save",
//            color = saveColor,
//            fontSize = 15.sp,
//            fontWeight = FontWeight.Bold,
//            textAlign = TextAlign.End
//        )


    }
}

@Composable
fun ReadOnlyOutlinedTextField(text: String) {
    OutlinedTextField(
        value = text,
        onValueChange = { /* Do nothing since it's read-only */ },
        readOnly = true,
        modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth(),
        shape = RoundedCornerShape(30.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.LightGray,
            unfocusedBorderColor = Color.LightGray,
        )


    )
}



