package com.example.appdemo.main.view.book

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appdemo.main.model.Book
import kotlinx.android.synthetic.main.item_book.view.*

public class ItemBookViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(book: Book) {
        itemView.text_title.text = book.name
        itemView.text_author.text = book.author
        Glide.with(itemView.context).load(book.thumb).into(itemView.image_cover_reading)
    }
}