package com.example.subcomponent.subcomponentapproach

import com.example.subcomponent.customannotations.ActivityScope
import com.example.subcomponent.customannotations.EmailRetryQualifier
import com.example.subcomponent.MainActivity
import com.example.subcomponent.commonmodule.NotificationServiceModule
import com.example.subcomponent.customannotations.RetryQualifier
import com.example.subcomponent.commonmodule.UserRepositoryModule
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(//Chhota ban k dependencies mang lo Bade @Component se.
// But yahan dependencies = add mat karo bcoz @Subcomponent laga liya h
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
//Chhota ban ke dependency mang rahe ho to apna object create karne ka tarika
// bigger life time wale component  ko bata do (i.eBuilder pattern)
    @Subcomponent.Builder//Mujhe bade @Component se dependency chahiye m hi chhota ban jata hun
    interface Builder {
        fun build(): UserRegistrationSubComponent
        fun  retryCount(@RetryQualifier @BindsInstance retryCount1: Int): Builder
        fun emailRetryCount( @EmailRetryQualifier @BindsInstance emailRetryCount: Int) : Builder
    }

    fun inject(activity: MainActivity) //Pass the consumer.
}