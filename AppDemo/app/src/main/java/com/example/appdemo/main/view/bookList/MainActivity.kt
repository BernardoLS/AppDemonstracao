package com.example.appdemo.main.view.bookList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appdemo.R
import com.example.appdemo.main.network.MainNetwork
import com.example.appdemo.main.viewmodel.MainViewModel
import com.example.appdemo.util.getFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(
            this, getFactory(MainViewModel(MainNetwork(Dispatchers.IO)))
        ).get(MainViewModel::class.java)
    }

    private val adapter: BookListAdapter by lazy {
        BookListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getBookList()
        registerObservers()
        configAdapter()
    }

    private fun registerObservers() {
        viewModel.booklists.observe(this, Observer { bookLists ->
            if(bookLists.isNullOrEmpty()) {
                return@Observer
            } else {
                adapter.addBookLists(bookLists)
                recycler_book_lists.visibility = View.VISIBLE
                progress_main.visibility = View.GONE
            }
        })

        viewModel.showError.observe(this, Observer { error ->
            if (error) {
                progress_main.visibility = View.GONE
            }
        })
    }

    private fun configAdapter() {
        recycler_book_lists.layoutManager = LinearLayoutManager(this)
        recycler_book_lists.adapter = adapter
    }
}