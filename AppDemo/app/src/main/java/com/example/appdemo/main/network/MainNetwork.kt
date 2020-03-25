package com.example.appdemo.main.network

import com.example.appdemo.enum.Status
import com.example.appdemo.extensions.launchSafe
import com.example.appdemo.main.model.BookList
import com.example.appdemo.main.model.Genres
import com.example.appdemo.network.Controller
import com.example.appdemo.network.DefaultNetwork
import com.example.appdemo.util.LiveDataResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val key = "5eb28dfc6e03eb1be97005b1dfe8c588"
private const val language = "pt-BR"

class MainNetwork(){
    private val TAG = "BookLists"

    private val api = Controller.retrofit.create(BookListApi::class.java)

    fun getBookLists(listener: (LiveDataResult<List<BookList>>) -> Unit) {
        CoroutineScope(Dispatchers.IO).launchSafe(
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
    fun getBookLists(): Response<List<BookList>>
}
interface MovieApi {
    @GET("genre/movie/list")
    fun getGenres(
        @Query("api_key") key: String,
        @Query("language") language: String
        ): Response<Genres>
}