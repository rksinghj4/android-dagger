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

    @Named("Email")
    @Provides
    fun bindEmailService(emailService: EmailService): NotificationService = emailService

    /**
     * Dagger can't create MessageService  object.
     * But we know how to provide. Therefore used Provides.
     */
    @Named("Message") //High chances of typos. There for use custom named Qualifier
    @Provides
    fun getMessageService(): NotificationService {
        //Do additional processing here
        return MessageService()
    }
}