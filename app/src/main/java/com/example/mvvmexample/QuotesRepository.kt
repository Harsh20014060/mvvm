package com.example.mvvmexample

import androidx.lifecycle.LiveData

class QuotesRepository(private val quoteDao: QuoteDao) {

    fun getQuotes(): LiveData<List<Quotes>> {
        return quoteDao.getQuotes()
    }


    suspend fun insertQuote(quotes: Quotes) {
        quoteDao.insertQuote(quotes)
    }
}