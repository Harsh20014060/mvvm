package com.example.mvvmexample

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuoteDao {
    @Query("select * from quote")
    fun getQuotes(): LiveData<List<Quotes>>

    @Insert
    suspend fun insertQuote(quotes: Quotes)
}