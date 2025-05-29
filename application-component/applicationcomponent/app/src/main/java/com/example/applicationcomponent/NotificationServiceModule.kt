package com.example.applicationcomponent

import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
//class NotificationServiceModule(val retryCount: Int) { //Problem:  consumer forgot to pass NotificationServiceModule
class NotificationServiceModule {

    //Note: function with @Binds annotation must be abstract and must be in abstract class.

    //Just bind because dagger knows how to create EmailService
    //@Binds
    //abstract fun bindEmailService(emailService: EmailService): NotificationService

    @Singleton // @Singleton annotation is directly applied to providers
    @EmailQualifier
    @Provides
    fun bindEmailService(emailService: EmailService): NotificationService = emailService

    /**
     * Dagger can't create MessageService  object.
     * But we know how to provide. Therefore used Provides.
     */
    @Singleton//Jab tak component jinda h. tab tak hi ye NotificationService dependency jinda rahegi
    @MessageQualifier
    @Provides
    fun getMessageService(@RetryQualifier retryCount:  Int): NotificationService {//Now Dagger knows retryCount 11
        //Do additional processing here
        return MessageService(retryCount)
    }
}