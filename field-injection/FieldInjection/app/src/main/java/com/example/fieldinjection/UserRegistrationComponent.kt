package com.example.fieldinjection

import dagger.Component

@Component (modules = [UserRepositoryModule::class, NotificationServiceModule::class])
interface UserRegistrationComponent {
    //Problem: Gradually component will grow in size and
    // we have to manually add function for each type of dependency to provide. Which is difficult to maintain.
   /* fun getUserRegistrationService(): UserRegistrationService
    fun getEmailService(): EmailService*/

    //Solution: Consumer just need to request to component to inform what are all dependencies they need.
    fun inject(activity: MainActivity) //Pass the consumer.
}