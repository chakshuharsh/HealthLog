package com.example.healthlog.ui_authentication.screens.signup

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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthlog.R
import com.example.healthlog.core.NavigationManager

// decrease the size of box
// centre alignment

@Composable
fun PhotoUploadScreen(navigationManager: NavigationManager){

    var selectedImage =  remember {mutableStateOf<ImageBitmap?>(null)}


    Column(
        modifier= Modifier
        .fillMaxSize()
        .padding(top = 10.dp, start = 15.dp, bottom = 3.dp, end = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier= Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {


            Text(
                text = stringResource(id = R.string.app_name),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black
            )

              // place an icon and a text here to continue without images



        }

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text= stringResource(R.string.profile_photo),
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,

            )


        Spacer(modifier = Modifier.height(60.dp))

        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .clickable { }
                .background(Color.Gray),
            contentAlignment = Alignment.Center
        ) {



                //show the default image
               Image(
                   painter = painterResource(id = R.drawable.default_profile_picture),
                   contentDescription = "Default Profile Photo",
                   modifier = Modifier
                       .size(500.dp)

               )



        }

        Spacer(modifier = Modifier.height(52.dp))


        customButton(stringResource(id =R.string.Open_camera))

        Spacer(modifier = Modifier.height(10.dp))

        customButton(stringResource(id =R.string.Open_gallery))

        Spacer(modifier = Modifier.height(10.dp))

        customButton(stringResource(id =R.string.Upload))








    }
}


@Composable
fun customButton(buttonText:String ){ // pass the OnClick functions

    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4169E1)),
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(16.dp),

        shape = RoundedCornerShape(8.dp),

    ) {
        Text(
            text = buttonText,
            fontSize=20.sp
        )

    }
}

