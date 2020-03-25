package com.example.appdemo.main.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.appdemo.main.model.BookList
import kotlinx.android.synthetic.main.item_book_list.view.*

public class ItemBookListViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
    val recycler = itemView.recycler_generation_list
    fun bind(bookList: BookList) {
        itemView.text_generation_list_title.text = bookList.nome
    }
}