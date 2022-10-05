package com.example.mvvmretrofitcoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmretrofitcoroutine.db.FakerDB
import com.example.mvvmretrofitcoroutine.viewmodels.MainViewModel
import com.example.mvvmretrofitcoroutine.viewmodels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var fakerDB1 : FakerDB

    @Inject
    lateinit var fakerDB2 : FakerDB

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private val products: TextView
        get() = findViewById(R.id.products)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as FakerApplication).applicationComponent.inject(this)

        val mapOfViewModels = (application as FakerApplication).applicationComponent.getMap()

        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)

        mainViewModel.productsLiveData.observe(this, Observer {
            products.text =  it.joinToString { x -> x.title + "\n\n" }
        })
    }
}