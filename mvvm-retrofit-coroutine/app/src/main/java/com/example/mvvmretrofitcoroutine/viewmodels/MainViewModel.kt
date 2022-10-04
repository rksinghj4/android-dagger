package com.example.mvvmretrofitcoroutine.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmretrofitcoroutine.models.Product
import com.example.mvvmretrofitcoroutine.repository.ProductRepository
import com.example.mvvmretrofitcoroutine.utils.Constants.TAG
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: ProductRepository,
                                        private val randomize: Randomize) : ViewModel() {

    val productsLiveData : LiveData<List<Product>>
        get() = repository.products

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }

}

class Randomize @Inject constructor(){
    fun doAction(){
        Log.d(TAG, "Random Action")
    }
}