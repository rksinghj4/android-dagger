package com.example.applicationcomponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * All @Singleton annotated  providers and binder will be single within the Component scope.
 */
@Singleton
@Component (modules = [UserRepositoryModule::class, NotificationServiceModule::class, AnalyticsModule::class])
interface UserRegistrationComponent {

    @Component.Factory
    interface Factory  {
        /**
         * 11- Now component have two integer values with qualifiers and
         * it can supply these anywhere needed with required qualifier.
         */
        fun create(@RetryQualifier @BindsInstance retryCount1: Int,  @EmailRetryQualifier @BindsInstance emailRetryCount: Int): UserRegistrationComponent
    }

    fun inject(activity: MainActivity) //Pass the consumer.
}