package com.example.appdemo.extensions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun CoroutineScope.launchSafe(
    onError: (Throwable) -> Unit = {},
    onSuccess: suspend () -> Unit
) {
    launch {
        try {
            onSuccess()
        } catch (e: Exception) {
            onError(e)
        }
    }
}