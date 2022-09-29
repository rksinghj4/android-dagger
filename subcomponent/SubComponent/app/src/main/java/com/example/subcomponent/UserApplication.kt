package com.example.subcomponent

import android.app.Application

class UserApplication: Application() {
    lateinit var appComponent: AppComponent
    lateinit var parentAppComponent: ParentAppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
        parentAppComponent = DaggerParentAppComponent.builder().build()
    }
}