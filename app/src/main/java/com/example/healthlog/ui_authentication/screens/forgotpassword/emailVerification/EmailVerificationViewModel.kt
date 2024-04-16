package com.example.healthlog.ui_authentication.screens.forgotpassword.emailVerification

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthlog.core.HealthogAppState
import com.google.firebase.auth.ActionCodeSettings
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


class EmailVerificationViewModel:ViewModel(){

    private val auth = HealthogAppState.auth
private val currentUserEmail =auth.currentUser?.email





    fun emailVerification(email:String){
        viewModelScope.launch(Dispatchers.IO) {
            val user = currentUserEmail?.let { HealthogAppState.usersCollection.document(it) }

            // Error hai is actionCodeSettings mai

//        val actionCodeSettings = ActionCodeSettings.newBuilder()
//            .setAndroidPackageName("com.example.healthlog", false, null)
//            .setHandleCodeInApp(true).build()

        user?.let{
                    Log.d("User exists", "User with email $currentUserEmail exists")


       auth.sendPasswordResetEmail(email)
           .addOnCompleteListener { task ->
               if (task.isSuccessful) {
                   Log.d(TAG, "Email sent.")
               }
           }
   }
        }

    }



}