package com.example.fieldinjection
import dagger.Component

//Yahan Scope(@Singleton, @Raj) ka thappa nahi laga or nahi  kisi module ke ander jo method dependency
// provide kar rahe hain un pe laga h. Therefore every time we will get new object created.
//Use Scope annotation - Consumer/Dependent jab tak jinda h tab tak hi Dependencies jinda rahni chaiye.

@Component (modules = [UserRepositoryModule::class, NotificationServiceModule::class])
interface UserRegistrationComponent {
    //Problem: Gradually component will grow in size and
    // we have to manually add function for each type of dependency to provide. Which is difficult to maintain.
   /* fun getUserRegistrationService(): UserRegistrationService
    fun getEmailService(): EmailService*/

    //Solution: Consumer just need to request to component to inform what are all dependencies they need.
    fun inject(activity: MainActivity)//Pass the consumer.
    //Pass the consumer. Then only UserRegistrationComponent will be able to access needed dependencies to initialize
}