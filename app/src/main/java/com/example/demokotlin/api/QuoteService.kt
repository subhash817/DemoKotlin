package com.example.demokotlin.api

import com.example.demokotlin.models.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {
    @GET("/Quotes")
    suspend fun getQuotes(@Query("page") page: Int): Response<QuoteList>
}