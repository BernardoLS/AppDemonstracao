package com.example.appdemo.main.view.book

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appdemo.R
import com.example.appdemo.main.model.Book

class BookAdapter(val bookList: ArrayList<Book>): RecyclerView.Adapter<ItemBookViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemBookViewHolder {
        return ItemBookViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false))
    }

    override fun getItemCount() = bookList.size

    override fun onBindViewHolder(holder: ItemBookViewHolder, position: Int) {
        val book = bookList[position]
        holder.bind(book)
    }

}