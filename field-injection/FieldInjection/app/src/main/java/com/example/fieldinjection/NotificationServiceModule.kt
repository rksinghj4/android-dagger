package com.example.fieldinjection

import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NotificationServiceModule {
    //Note: function with @Binds annotation must be abstract and must be in abstract class.

    //Just bind because dagger knows how to create EmailService
//    @Binds
//    abstract fun bindEmailService(emailService: EmailService): NotificationService

    //Yahan Scope(@Singleton, @Raj) ka thappa nahi laga or nahi  UserRegistrationComponent pe laga j
    // Therefore every time we will get new object created for NotificationService.
    @EmailQualifier
    @Provides
    fun bindEmailService(emailService: EmailService): NotificationService = emailService

    /**
     * Dagger can't create MessageService  object.
     * But we know how to provide. Therefore used Provides.
     */
    @MessageQualifier
    @Provides
    fun getMessageService(): NotificationService {
        //Do additional processing here
        return MessageService()
    }
}