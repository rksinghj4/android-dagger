package com.example.subcomponent

import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
    modules = [UserRepositoryModule::class, NotificationServiceModule::class]
)
interface UserRegistrationSubComponent {
    /*@Subcomponent.Factory
    interface Factory {
        *//**
         * 11- Now component have two integer values with qualifiers and
         * it can supply these anywhere needed with required qualifier.
         *//*
        fun create(
            @RetryQualifier @BindsInstance retryCount1: Int,
            @EmailRetryQualifier @BindsInstance emailRetryCount: Int,
        ): UserRegistrationSubComponent
    }
*/
    /**
     * Note: Only one method can create a given subcomponent.
     */

    @Subcomponent.Builder
    interface Builder {
        fun build(): UserRegistrationSubComponent
        fun  retryCount(@RetryQualifier @BindsInstance retryCount1: Int): Builder
        fun emailRetryCount( @EmailRetryQualifier @BindsInstance emailRetryCount: Int) : Builder
    }

    fun inject(activity: MainActivity) //Pass the consumer.
}