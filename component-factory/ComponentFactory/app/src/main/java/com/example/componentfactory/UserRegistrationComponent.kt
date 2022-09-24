package com.example.componentfactory

import dagger.BindsInstance
import dagger.Component

@Component (modules = [UserRepositoryModule::class, NotificationServiceModule::class])
interface UserRegistrationComponent {

    @Component.Factory
    interface Factory  {
        /**
         * 11- Now component have retryCount and it can supply it anywhere needed 11.
         */
        fun create(@RetryQualifier @BindsInstance retryCount1: Int,  @EmailRetryQualifier @BindsInstance emailRetryCount: Int): UserRegistrationComponent
    }

    fun inject(activity: MainActivity) //Pass the consumer.
}