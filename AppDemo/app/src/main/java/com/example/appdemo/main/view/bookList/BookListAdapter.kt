package com.example.appdemo.main.view.bookList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appdemo.R
import com.example.appdemo.main.model.BookList
import com.example.appdemo.main.view.book.BookAdapter
import com.example.appdemo.util.buildAdapter
import java.lang.RuntimeException

private const val ITEM_BOOK_LIST = 1

private val recycledViewPool = RecyclerView.RecycledViewPool()

class BookListAdapter(var lists: ArrayList<BookList> = arrayListOf()) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            ITEM_BOOK_LIST -> ItemBookListViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_book_list, parent, false))
            else -> throw RuntimeException()
        }
    }

    override fun getItemCount() = getElements().size

    override fun getItemViewType(position: Int) = getElements()[position]

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder.itemViewType) {
            ITEM_BOOK_LIST -> {
                val viewHolder = holder as ItemBookListViewHolder
                val bookListName = lists[position].name
                val bookList = lists[position].list
                viewHolder.bind(bookListName)

                buildAdapter(
                    viewHolder.recycler,
                    BookAdapter(bookList),
                    null,
                    LinearLayoutManager(viewHolder.itemView.context, RecyclerView.HORIZONTAL, false),
                    recycledViewPool
                    )
            }
        }
    }

    private fun getElements(): ArrayList<Int> {
        val elements = arrayListOf<Int>()
        if (lists.isNotEmpty()) {
            repeat(lists.size) {
                elements.add(ITEM_BOOK_LIST)
            }
        }
        return elements
    }

    fun addBookLists(bookLists: ArrayList<BookList>) {
        lists.clear()
        lists = bookLists
        notifyDataSetChanged()
    }
}