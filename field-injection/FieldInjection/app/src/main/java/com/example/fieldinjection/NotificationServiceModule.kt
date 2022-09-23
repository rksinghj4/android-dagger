package com.example.fieldinjection

import dagger.Module
import dagger.Provides

@Module
class NotificationServiceModule {

    @Provides
    fun getMessageService(): NotificationService {
        //Do additional processing here
        return MessageService()
    }
}