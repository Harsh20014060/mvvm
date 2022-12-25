package com.example.mvvmexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val quotesRepository: QuotesRepository) : ViewModel() {
    fun getquotes(): LiveData<List<Quotes>> {
        return quotesRepository.getQuotes()
    }

    fun insertQuote(quotes: Quotes) {
        viewModelScope.launch(Dispatchers.IO) { quotesRepository.insertQuote(quotes) }

    }
}