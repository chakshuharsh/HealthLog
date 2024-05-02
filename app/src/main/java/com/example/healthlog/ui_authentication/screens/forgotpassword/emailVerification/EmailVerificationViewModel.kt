package com.example.healthlog.ui_authentication.screens.forgotpassword.emailVerification

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.healthlog.core.HealthLogAppState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class EmailVerificationViewModel():ViewModel(){

    private val auth = HealthLogAppState.auth
private val currentUserEmail =auth.currentUser?.email





    fun emailVerification(email:String){
        viewModelScope.launch(Dispatchers.IO) {
            val user = currentUserEmail?.let { HealthLogAppState.usersCollection.document(it) }

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