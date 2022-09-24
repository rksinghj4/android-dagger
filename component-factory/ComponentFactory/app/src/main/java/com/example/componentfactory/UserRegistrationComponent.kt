package com.example.componentfactory

import dagger.BindsInstance
import dagger.Component

@Component (modules = [UserRepositoryModule::class, NotificationServiceModule::class])
interface UserRegistrationComponent {

    @Component.Factory
    interface Factory  {
        /**
         * 11- Now component have two integer values with qualifiers and
         * it can supply these anywhere needed with required qualifier 11.
         */
        fun create(@RetryQualifier @BindsInstance retryCount1: Int,  @EmailRetryQualifier @BindsInstance emailRetryCount: Int): UserRegistrationComponent
    }

    fun inject(activity: MainActivity) //Pass the consumer.
}