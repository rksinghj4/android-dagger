package com.example.mvvmretrofitcoroutine.di

import androidx.lifecycle.ViewModel
import com.example.mvvmretrofitcoroutine.viewmodels.MainViewModel
import com.example.mvvmretrofitcoroutine.viewmodels.MainViewModel2
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    /**
     * Multiple bindings for ViewModel with the help of key-value pair
     * into map
     */
    @Binds
    @ClassKey(MainViewModel::class)
    @IntoMap
    abstract fun mainViewModel(mainViewModel: MainViewModel) : ViewModel

    @Binds
    @ClassKey(MainViewModel2::class)
    @IntoMap
    abstract fun mainViewModel2(mainViewModel2: MainViewModel2) : ViewModel

}