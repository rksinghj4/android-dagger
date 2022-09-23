package com.example.fieldinjection

import dagger.Module
import dagger.Provides

@Module
class NotificationServiceModule {

    /**
     * Dagger can't create MessageService  object.
     * But we know how to provide. Therefore used Provides.
     */
    @Provides
    fun getMessageService(): NotificationService {
        //Do additional processing here
        return MessageService()
    }
}