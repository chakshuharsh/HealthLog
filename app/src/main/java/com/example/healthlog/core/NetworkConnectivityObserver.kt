package com.example.healthlog.core

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch


class NetworkConnectivityObserver(
    private val context: Context
): ConnectivityObserver {

    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    private val networkRequest: NetworkRequest = NetworkRequest.Builder()
        .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
        .build()


    override fun observe(): Flow<ConnectivityObserver.Status> {
        return callbackFlow {
            val callback = object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {

                    super.onAvailable(network)
                    if (isInternetAvailable(network)) {
                        launch { send(ConnectivityObserver.Status.Available) }
                        HealthLogAppState.isInternetConnected.postValue(true)
                    } else {
                        launch { send(ConnectivityObserver.Status.Unavailable) }
                        HealthLogAppState.isInternetConnected.postValue(false)
                    }



                }

                override fun onLosing(network: Network, maxMsToLive: Int) {
                    super.onLosing(network, maxMsToLive)
                    if (isInternetAvailable(network)) {
                        launch { send(ConnectivityObserver.Status.Available) }
                        HealthLogAppState.isInternetConnected.postValue(true)
                    } else {
                        launch { send(ConnectivityObserver.Status.Unavailable) }
                        HealthLogAppState.isInternetConnected.postValue(false)
                    }
                }

                override fun onLost(network: Network) {
                    super.onLost(network)
                    launch { send(ConnectivityObserver.Status.Unavailable) }
                    HealthLogAppState.isInternetConnected.postValue(false)
                }

                override fun onUnavailable() {
                    super.onUnavailable()
                    launch { send(ConnectivityObserver.Status.Unavailable) }
                    HealthLogAppState.isInternetConnected.postValue(false)

                }
            }

            connectivityManager.registerDefaultNetworkCallback(callback)
            awaitClose {
                connectivityManager.unregisterNetworkCallback(callback)
            }
        }.distinctUntilChanged()
    }

    @SuppressLint("SuspiciousIndentation")
    private fun isInternetAvailable(network: Network): Boolean {
        val capabilities = connectivityManager.getNetworkCapabilities(network)

            return capabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
    }
}
