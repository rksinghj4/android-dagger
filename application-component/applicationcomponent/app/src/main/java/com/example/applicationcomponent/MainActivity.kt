package com.example.applicationcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

/**
 * Problem: if we inject property at top level
 * Kotlin error: Dagger does not support injection into static fields
 */

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var userRegistrationService: UserRegistrationService

    @EmailQualifier
    @Inject
    lateinit var notificationService: NotificationService

    //Problem: 11 -  Dagger will create different object of NotificationService
    // for each injection without singlton .
    //Solution 11 - @Singleton

    @EmailQualifier
    @Inject
    lateinit var notificationService1: NotificationService
    @Inject
    lateinit var userRepository: UserRepository
    @Inject
    lateinit var userRepository1: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val component = DaggerUserRegistrationComponent.factory().create( 4, 111)

        /**
         * DaggerUserRegistrationComponent.builder() will through errors
         * so we have to use factory to create object of component.
         * We will not forget to pass required values.
         */

        component.inject(this)

        userRegistrationService.registerUser("abc@xyz.com", "2222")
        notificationService.send("aa", "bb", "notification from MainActivity")

    }
}