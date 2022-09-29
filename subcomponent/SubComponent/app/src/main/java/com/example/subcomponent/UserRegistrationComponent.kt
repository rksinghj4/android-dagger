package com.example.subcomponent

import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * All @Singleton annotated  providers and binder will be single within the Component scope.
 */
@ActivityScope
@Component(
    dependencies = [AppComponent::class],
    modules = [UserRepositoryModule::class, NotificationServiceModule::class]
)
interface UserRegistrationComponent {

    @Component.Factory
    interface Factory {
        /**
         * 11- Now component have two integer values with qualifiers and
         * it can supply these anywhere needed with required qualifier.
         */
        fun create(
            @RetryQualifier @BindsInstance retryCount1: Int,
            @EmailRetryQualifier @BindsInstance emailRetryCount: Int,
            appComponent: AppComponent
        ): UserRegistrationComponent
    }

    fun inject(activity: MainActivity) //Pass the consumer.
}