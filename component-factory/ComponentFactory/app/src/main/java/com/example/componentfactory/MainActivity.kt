package com.example.componentfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

/**
 * Problem: if we inject property at top level
 * Kotlin error: Dagger does not support injection into static fields
 */
   /* @Inject
    lateinit var userRegistrationService: UserRegistrationService

    @EmailQualifier
    @Inject
    lateinit var notificationService: NotificationService
*/

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var userRegistrationService: UserRegistrationService

    @EmailQualifier
    @Inject
    lateinit var notificationService: NotificationService

    //Problem: 11 -  Dagger will create different object of NotificationService for each injection.
    //Solution 11 - @Singleton
    @EmailQualifier
    @Inject
    lateinit var notificationService1: NotificationService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         * Earlier component was creating NotificationServiceModule  at compile time
         * but now we need to pass some value at run time that's why we need to provide
         * NotificationServiceModule object with required param at run time.
         *
         * Problem: consumer forgot to pass NotificationServiceModule
         * If consumer forgot to write
         * .notificationServiceModule(NotificationServiceModule(3))
         * then it will through error.
         */

       /* val component = DaggerUserRegistrationComponent.builder()
            .notificationServiceModule(NotificationServiceModule(3))
            .build()
        */
        /**
         * Solution:
         * Create Factory for UserRegistrationComponent
         */

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