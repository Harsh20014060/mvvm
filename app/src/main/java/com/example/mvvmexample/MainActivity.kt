package com.example.mvvmexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao = QuoteDatabase.getDatabase(this).quotesDao()
        val repository = QuotesRepository(dao)
        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(quotesRepository = repository)).get(
                MainViewModel::class.java
            )

        mainViewModel.getquotes().observe(this, Observer {
            binding.quotes = it.toString()
        })

        binding.addbtnquotes.setOnClickListener {
            val quote = Quotes(0,"This is testing","Mr. Bot")
            mainViewModel.insertQuote(quote)
            Toast.makeText(this@MainActivity,"data added",Toast.LENGTH_SHORT).show()
        }
    }
}