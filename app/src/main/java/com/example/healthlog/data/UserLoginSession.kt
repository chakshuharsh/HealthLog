package com.example.healthlog.data

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map



class UserLoginSession(private val dataStore: DataStore<Preferences>) {

    val isUserLoggedIn: Flow<Boolean> = dataStore.data
        .catch {
            if(it is IOException) {
                Log.e(TAG, "Error reading preferences.", it)
                emit(emptyPreferences())
            } else {
                throw it
            }
        }.map{ preferences ->
        preferences[IS_USER_LOGGED_IN] ?: false
    }

    private companion object {
        val IS_USER_LOGGED_IN = booleanPreferencesKey("is_user_logged_in")
        const val TAG = "UserPreferencesRepo"
    }

suspend fun saveUserLoginState(isUserLoggedIn: Boolean) {
    dataStore.edit { preferences ->
        preferences[IS_USER_LOGGED_IN] = isUserLoggedIn
    }
}
// get data pending


}