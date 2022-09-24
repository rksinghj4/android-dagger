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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val component = DaggerUserRegistrationComponent.builder()
            .notificationServiceModule(NotificationServiceModule(3))
            .build()
        component.inject(this)

        userRegistrationService.registerUser("abc@xyz.com", "2222")
        notificationService.send("aa", "bb", "notification from MainActivity")
    }
}