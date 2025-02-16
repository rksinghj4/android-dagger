package com.example.subcomponent

import android.app.Application
import com.example.subcomponent.dependencyapproach.AppComponent
import com.example.subcomponent.dependencyapproach.DaggerAppComponent
import com.example.subcomponent.subcomponentapproach.DaggerParentAppComponent
import com.example.subcomponent.subcomponentapproach.ParentAppComponent

class UserApplication: Application() {
    lateinit var appComponent: AppComponent//Lives as long as UserApplication obj
    lateinit var parentAppComponent: ParentAppComponent///Lives as long as UserApplication obj
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
        parentAppComponent = DaggerParentAppComponent.builder().build()
    }
}