package com.example.applicationcomponent

import android.app.Application

class UserApplication : Application() {
    /**
     * UserRegistrationComponent object is created here UserApplication class
     * so it's scope/life is tide with application object
     * So all providers inside the @module class using the
     * same scope annotation(i.e. @Singleton) as @component interface
     * will have same life (i.e. created only once in life time/marked scope)
     */
    lateinit var userRegistrationComponent: UserRegistrationComponent
    override fun onCreate() {
        super.onCreate()
        userRegistrationComponent = DaggerUserRegistrationComponent.factory().create(4, 111)
    }
}