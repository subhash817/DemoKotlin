package com.example.demokotlin.repoitory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.demokotlin.api.QuoteService
import com.example.demokotlin.models.QuoteList

class QuoteRepository (private val quoteService: QuoteService){
    private val quoteLiveData= MutableLiveData<QuoteList>()
    val quote:LiveData<QuoteList>
    get() = quoteLiveData
    suspend fun getQuotes(page:Int){
        val result=quoteService.getQuotes(page)
        if (result.body() !=null){
            quoteLiveData.postValue(result.body())

        }
    }
}