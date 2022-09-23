package com.example.fieldinjection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var userRegistrationService: UserRegistrationService

    @Inject
    lateinit var notificationService: NotificationService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val component = DaggerUserRegistrationComponent.builder().build()

       //By passing consumer here we requesting connector(i.e component)
        // to supply all @Injected dependencies for this consumer.
        // Then component will check if he can create all at compile time.

        component.inject(this)

        /* component.getUserRegistrationService().registerUser("abc@xyz.com", "122")
         component.getEmailService().send("me", "you", "Email sent from MainActivity")*/

        userRegistrationService.registerUser("abc@xyz.com", "122")
        notificationService.send("me", "you", "User registered from MainActivity")
    }
}