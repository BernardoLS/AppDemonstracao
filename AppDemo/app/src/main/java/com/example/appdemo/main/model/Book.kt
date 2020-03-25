package com.example.appdemo.main.model

import java.io.Serializable

data class Book(
    val name: String = "",
    val author: String = "",
    val synopsis: String = "",
    val thumb: String = "",
    val publicationYear: Int = 0,
    val publisher: String = "",
    val pageCount: Int = 0
): Serializable