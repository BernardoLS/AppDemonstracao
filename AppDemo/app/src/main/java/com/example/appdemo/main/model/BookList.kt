package com.example.appdemo.main.model

import java.io.Serializable

data class BookList(val nome: String = "", val lista: ArrayList<Book> = arrayListOf()) : Serializable