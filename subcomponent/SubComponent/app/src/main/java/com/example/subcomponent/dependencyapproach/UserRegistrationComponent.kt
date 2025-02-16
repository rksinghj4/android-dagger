package com.example.subcomponent.dependencyapproach

import com.example.subcomponent.MainActivity
import com.example.subcomponent.commonmodule.NotificationServiceModule
import com.example.subcomponent.commonmodule.UserRepositoryModule
import com.example.subcomponent.customannotations.ActivityScope
import com.example.subcomponent.customannotations.EmailRetryQualifier
import com.example.subcomponent.customannotations.RetryQualifier
import dagger.BindsInstance
import dagger.Component

/**
 * All @Singleton annotated  providers and binder will be single within the Component scope.
 */
@ActivityScope
@Component(
    dependencies = [AppComponent::class],//Note UserRegistrationComponent depends upon bigger component
    // so bigger component has to add signature method
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