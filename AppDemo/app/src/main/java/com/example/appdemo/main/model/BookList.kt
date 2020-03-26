package com.example.appdemo.main.model

import java.io.Serializable

data class BookList(val name: String = "", val list: ArrayList<Book> = arrayListOf()) : Serializable