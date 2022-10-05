package com.example.mvvmretrofitcoroutine.di

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.mvvmretrofitcoroutine.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
    /**
     * We can call getMap() on ApplicationComponent's  object
     * to check how many items are added to map.
     */

    fun getMap() : Map<Class<*>, ViewModel>

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context) : ApplicationComponent
    }
}