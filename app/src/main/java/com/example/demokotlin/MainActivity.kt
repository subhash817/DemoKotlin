package com.example.demokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.demokotlin.api.QuoteService
import com.example.demokotlin.api.RetrofitHelper
import com.example.demokotlin.repoitory.QuoteRepository
import com.example.demokotlin.viewmodel.MainViewModel
import com.example.demokotlin.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txtQuote = findViewById<TextView>(R.id.txtQuote)

        val quoteService=RetrofitHelper.getInstance().create(QuoteService::class.java)
        val repository=QuoteRepository(quoteService)
        mainViewModel=ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)
        mainViewModel.quotes.observe(this) {
            Log.d("Quotes", it.results.toString())
            txtQuote.text=it.results.get(0).author.toString()






        }
    }
}