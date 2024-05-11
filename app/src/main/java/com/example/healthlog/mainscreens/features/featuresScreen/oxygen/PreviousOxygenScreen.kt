package com.example.healthlog.mainscreens.features.featuresScreen.oxygen




import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.healthlog.core.NavigationManager
import com.example.healthlog.mainscreens.commonui.BottomBar
import com.example.healthlog.mainscreens.commonui.CommonCardNew
import com.example.healthlog.mainscreens.commonui.topBarForFeatures
@Composable

fun PreviousOxygenScreen(navigationManager: NavigationManager){

    val viewModel = remember { OxygenViewModel() }
    val fetchedOxygenData = viewModel.getOxygenData()
    Log.d("Function called from oxygen prev","Yes")
    var oxygenValue: Int?
    var pulseValue: Int?
//    var Date: Timestamp?

    Scaffold(
        topBar = {
            topBarForFeatures(navigationManager)
        },
        bottomBar = {
            BottomBar(navigationManager)
        }
    ) { innerpadding ->

        Column(
            modifier = Modifier
                .padding(innerpadding)
                .fillMaxWidth()
        ) {

            CommonCardNew(
                onNewClick = {navigationManager.navigateToOxygenScreen()},
                onPreviousClick = {navigationManager.navigateToPreviousOxygenScreen()},
            )

            Spacer(modifier = Modifier.height(40.dp))

            for (document in fetchedOxygenData.value) {
                oxygenValue = document.getString("Oxygen value")?.toInt()
                oxygenValue?.let { Text(text = it.toString()) }
                Spacer(modifier = Modifier.height(20.dp))
                pulseValue=document.getString("Pulse")?.toInt()
                pulseValue?.let { Text(text = it.toString()) }
                Spacer(modifier = Modifier.height(20.dp))
//                Date=document.getTimestamp("Date")
//                Date?.let { Text(text = it.toString()) }

            }
            Log.d("Data displayed?","Yes")
        }
    }
}
