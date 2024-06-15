package com.example.healthlog


import PrescriptionScreen
import android.content.Context
import android.os.Bundle
import android.provider.ContactsContract.Profile


import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController


import com.example.healthlog.core.ConnectivityObserver
import com.example.healthlog.core.HealthLogApp


import com.example.healthlog.core.NavigationManager
import com.example.healthlog.core.HealthLogAppState
import com.example.healthlog.mainscreens.ProfileScreen
import com.example.healthlog.mainscreens.features.featuresScreen.bloodPressure.PreviousBloodPressureScreen
import com.example.healthlog.mainscreens.features.featuresScreen.labreport.LabReportScreen

import com.example.healthlog.mainscreens.features.featuresScreen.vaccine.NewVaccineScreen
import com.example.healthlog.mainscreens.features.featuresScreen.vaccine.PreviousVaccineScreen
import com.example.healthlog.mainscreens.homeScreen.AddingScreen
import com.example.healthlog.mainscreens.homeScreen.HomeScreen
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


class MainActivity : ComponentActivity() {
    private lateinit var connectivityObserver: ConnectivityObserver
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

//        connectivityObserver = NetworkConnectivityObserver(applicationContext)

        setContent {
//            val status by connectivityObserver.observe().collectAsState(
//                initial = ConnectivityObserver.Status.Unavailable
//            )
//            Log.d("value of status is", "$status")

            val navController = rememberNavController()
            val navigationManager = NavigationManager(navController)
            HealthLogApp(navController, navigationManager, HealthLogAppState)

//            PreviousBloodPressureScreen(navigationManager)
//            CameraPreviewScreen()
//NewVaccineScreen(navigationManager)
//            PreviousVaccineScreen(navigationManager)




//            Box(

//                modifier = Modifier.fillMaxSize(),
//                contentAlignment = Alignment.Center
//            )
//            {
//                Log.d("value of status is", "$status")
//                Text(text = "Network Status: $status")
//            }
//        }
        }
    }
}

@Composable
fun CameraPreviewScreen() {
    val lensFacing = CameraSelector.LENS_FACING_BACK
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current
    val preview = Preview.Builder().build()
    val previewView = remember {
        PreviewView(context)
    }
    val cameraxSelector = CameraSelector.Builder().requireLensFacing(lensFacing).build()
    LaunchedEffect(lensFacing) {
        val cameraProvider = context.getCameraProvider()
        cameraProvider.unbindAll()
        cameraProvider.bindToLifecycle(lifecycleOwner, cameraxSelector, preview)
        preview.setSurfaceProvider(previewView.surfaceProvider)
    }
    AndroidView(factory = { previewView }, modifier = Modifier.fillMaxSize())
}

private suspend fun Context.getCameraProvider(): ProcessCameraProvider =
    suspendCoroutine { continuation ->
        ProcessCameraProvider.getInstance(this).also { cameraProvider ->
            cameraProvider.addListener({
                continuation.resume(cameraProvider.get())
            }, ContextCompat.getMainExecutor(this))
        }
    }




