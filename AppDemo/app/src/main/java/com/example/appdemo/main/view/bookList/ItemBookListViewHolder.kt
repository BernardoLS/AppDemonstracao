package com.example.appdemo.main.view.bookList

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.appdemo.main.model.BookList
import kotlinx.android.synthetic.main.item_book_list.view.*

class ItemBookListViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
    val recycler: RecyclerView = itemView.recycler_book_list
    fun bind(name: String) {
        itemView.text_list_title.text = name
    }
}