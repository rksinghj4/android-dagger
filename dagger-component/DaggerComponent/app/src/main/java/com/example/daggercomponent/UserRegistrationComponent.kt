package com.example.daggercomponent

import dagger.Component

@Component
interface UserRegistrationComponent {
    //Problem: Gradually component will grow in size and
    // we have to manually add function for each type  of dependency to provide. Which is difficult to maintain.
    fun getUserRegistrationService(): UserRegistrationService
    fun getEmailService(): EmailService
}