package com.example.appdemo.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getBookList()
        registerObservers()
    }

    private fun registerObservers() {
        viewModel.booklists.observe(this, Observer { bookLists ->
            if(bookLists.isNullOrEmpty()) {
                return@Observer
            } else {
                val list = bookLists[0]
                text_teste.text = list.nome
            }
        })

        viewModel.showError.observe(this, Observer { error ->
            if (error) {
                text_teste.text = "Deu ruim, tente outra vez"
            }
        })
    }
}