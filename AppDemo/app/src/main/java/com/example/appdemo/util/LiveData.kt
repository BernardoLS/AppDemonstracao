package com.example.appdemo.util

import com.example.appdemo.enum.Status

class LiveDataResult<T>(val status: Status, val data: T? = null, val error: Throwable? = null) {
    companion object {
        fun <T> success (data: T) = LiveDataResult<T>(Status.SUCCESS, data)
        fun <T> error(err: Throwable) = LiveDataResult<T>(Status.ERROR, null, err)
        fun <T> loading() = LiveDataResult<T>(Status.LOADING)
    }
}