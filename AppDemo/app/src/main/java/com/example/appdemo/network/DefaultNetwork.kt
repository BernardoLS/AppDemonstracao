package com.example.appdemo.network

import com.example.appdemo.exception.FailureResponseException
import com.example.appdemo.util.LiveDataResult
import retrofit2.Response

object DefaultNetwork {

    fun <T> request(response: Response<T>, tag: String): LiveDataResult<T> {
        return try {
            val body = response.body()

            if (response.isSuccessful && body != null) {
                LiveDataResult.success(body)
            } else {
                LiveDataResult.error(FailureResponseException())
            }
        } catch (e:Exception) {
            LiveDataResult.error(e)
        }
    }
}