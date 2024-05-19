package com.example.healthlog.ui_authentication.screens.signup

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Canvas
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
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

//    var selectedImage =  remember {mutableStateOf<ImageBitmap?>(null)}
//    var imageUri by remember { mutableStateOf<Uri?>(null) }
//    val context = LocalContext.current

//    val selectImageLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
//        imageUri = uri
//    }

        TextButton(onClick = { /*TODO*/ }) {
            Icon(
                Icons.Default.ArrowBack, contentDescription = null
            )
        }




    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 110.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
    ){
        Text(text = "Add a", fontSize = 30.sp)
        Text(text = "Profile Picture", fontSize = 30.sp)

        Spacer(modifier = Modifier.height(36.dp))

        Box (
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .clickable { },
            contentAlignment = Alignment.Center
        ) {

            Text(
                modifier = Modifier.offset(y = (30).dp),
                text = "Add Photo" , textAlign = TextAlign.Center)



            Canvas(modifier = Modifier.matchParentSize()) {
                val radius = size.minDimension / 2
                val stroke = Stroke(
                    width = 6.dp.toPx(),
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(50f, 40f), 0f)
                )
                drawCircle(Color.Gray, radius, style = stroke)





            }
//            if (imageUri == null) {
//                Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                     Icon(
////                        imageVector = ImageVector.vectorResource(id = R.drawable.add_24dp_fill0_wght400_grad0_opsz24),
////                        contentDescription = "Add Photo",
////                        modifier = Modifier.size(24.dp)
////                    )
//                    Text(text = "Add Photo", fontSize = 14.sp)
//                }
//            } else {
                // Load the image using any image loading library, e.g., Coil
//                Image(
//                    painter = rememberImagePainter(data = imageUri),
//                    contentDescription = null,
//                    modifier = Modifier.size(150.dp),
//                    contentScale = ContentScale.Crop
//                )
//            }


            TextButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Default.Add, contentDescription = null
                )
            }



        }

        Spacer(modifier = Modifier.height(285.dp))

        Button(onClick = { /* Continue action */ },
            modifier = Modifier
                .fillMaxWidth(0.92f)
                .height(50.dp),
//                    shape = ShapeDefaults.Small,
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(Color.LightGray)
        ) {
            Text(text = "Continue    ",   fontSize = 20.sp, textAlign = TextAlign.Center)
            Icon(
                Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(onClick = { /* Skip action */ },

        ) {
            Text(text = "Skip", fontSize = 20.sp)
        }
    }
}

