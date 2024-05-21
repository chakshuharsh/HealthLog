package com.example.healthlog


import PrescriptionScreen
import android.os.Bundle
import android.provider.ContactsContract.Profile


import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController


import com.example.healthlog.core.ConnectivityObserver
import com.example.healthlog.core.HealthLogApp


import com.example.healthlog.core.NavigationManager
import com.example.healthlog.core.HealthLogAppState
import com.example.healthlog.mainscreens.ProfileScreen
import com.example.healthlog.mainscreens.features.featuresScreen.labreport.LabReportScreen

import com.example.healthlog.mainscreens.features.featuresScreen.vaccine.NewVaccineScreen
import com.example.healthlog.mainscreens.features.featuresScreen.vaccine.PreviousVaccineScreen
import com.example.healthlog.mainscreens.homeScreen.AddingScreen
import com.example.healthlog.mainscreens.homeScreen.HomeScreen


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



