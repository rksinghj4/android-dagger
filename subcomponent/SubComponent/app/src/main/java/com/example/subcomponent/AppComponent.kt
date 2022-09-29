package com.example.subcomponent

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AnalyticsModule::class])
interface AppComponent {
    /**
     * AnalyticsService object is application wide
     * singleton
     */
    fun getAnalyticsService(): AnalyticsService

    /**
     * Problem: here we have to add methods for all  dependencies which can be provided by
     * AppComponent with the help of modules and other dependencies if any.
     */
}