package com.example.healthlog.ui_authentication.screens.forgotpassword

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import com.example.healthlog.core.NavigationManager
import com.example.healthlog.mainscreens.commonui.BottomBar

@Composable
fun MyComposable(
    navigationManager: NavigationManager
) {
    // ...
Scaffold (
    bottomBar = { BottomBar(navigationManager = navigationManager) }
){PaddingValues ->
    Column (
        modifier = Modifier.padding(PaddingValues)
    ){

    }

}

}