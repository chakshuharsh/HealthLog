package com.example.healthlog.core

import android.app.Application
import android.content.Context
import androidx.compose.runtime.rememberCoroutineScope
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.healthlog.data.UserLoginSession




private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_login_session")

class HealthLogReleaseApplication: Application() {
    lateinit  var userLoginSession: UserLoginSession

    }






//val healthReleaseApplication: HealthLogReleaseApplication = HealthLogReleaseApplication()