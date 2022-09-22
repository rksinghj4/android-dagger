package com.example.manualdependencyinjection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Problem: If we are using UserRegistrationService  at 10 places then we have to create
        // supply EmailService and UserRepository objects  every time.

        val emailService = EmailService()
        val userRepository = UserRepository()
        val userRegistrationService = UserRegistrationService(emailService, userRepository)
        userRegistrationService.registerUser("abc@xyz.com", "122")
    }
}