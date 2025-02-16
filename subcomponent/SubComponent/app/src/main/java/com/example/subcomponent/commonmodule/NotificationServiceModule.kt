package com.example.subcomponent.commonmodule

import com.example.subcomponent.customannotations.ActivityScope
import com.example.subcomponent.customannotations.EmailQualifier
import com.example.subcomponent.customannotations.MessageQualifier
import com.example.subcomponent.customannotations.RetryQualifier
import dagger.Module
import dagger.Provides

@Module
//class NotificationServiceModule(val retryCount: Int) { //Problem:  consumer forgot to pass NotificationServiceModule
class NotificationServiceModule {

    //Note: function with @Binds annotation must be abstract and must be in abstract class.

    //Just bind because dagger knows how to create EmailService
    //@Binds
    //abstract fun bindEmailService(emailService: EmailService): NotificationService

    @ActivityScope // @Singleton annotation is directly applied to providers
    @EmailQualifier
    @Provides
    fun bindEmailService(emailService: EmailService): NotificationService = emailService

    /**
     * Dagger can't create MessageService  object.
     * But we know how to provide. Therefore used Provides.
     */
    @ActivityScope
    @MessageQualifier
    @Provides
    fun getMessageService(@RetryQualifier retryCount:  Int): NotificationService {//Now Dagger knows retryCount 11
        //Do additional processing here
        return MessageService(retryCount)
    }
}