package com.example.appdemo.main.network

import com.example.appdemo.extensions.launchSafe
import com.example.appdemo.main.model.BookList
import com.example.appdemo.network.Controller
import com.example.appdemo.network.DefaultNetwork
import com.example.appdemo.util.LiveDataResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import retrofit2.Response
import retrofit2.http.GET

class MainNetwork(private val dispatcher: CoroutineDispatcher){
    private val TAG = "BookLists"

    private val api = Controller.retrofit.create(BookListApi::class.java)
    fun getBookLists(listener: (LiveDataResult<ArrayList<BookList>>) -> Unit) {
        CoroutineScope(dispatcher).launchSafe(
            {
                println("ninjaaaa $it")
                listener(LiveDataResult.error(it))
            },
            {
                val request = api.getBookLists()
                println("ninja nt - ${request.body()}")
                listener(DefaultNetwork.request(request, TAG))
            }
        )
    }
}

interface BookListApi {
    @GET("book.json")
    suspend fun getBookLists(): Response<ArrayList<BookList>>
}