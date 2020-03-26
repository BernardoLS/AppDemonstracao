package com.example.appdemo.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appdemo.enum.Status
import com.example.appdemo.main.model.BookList
import com.example.appdemo.main.network.MainNetwork

class MainViewModel(val mainNetwork: MainNetwork): ViewModel() {

    val showError = MutableLiveData<Boolean>()
    val showLoader = MutableLiveData<Boolean>()
    val booklists = MutableLiveData<ArrayList<BookList>>()

    fun getBookList() {
        mainNetwork.getBookLists { result ->
            when(result.status) {
                Status.SUCCESS -> {
                    booklists.postValue(result.data)
                    showLoader.postValue(false)
                }
                Status.LOADING -> showLoader.postValue(true)
                Status.ERROR -> {
                    showError.postValue(true)
                    showLoader.postValue(false)
                }
            }
        }
    }

}