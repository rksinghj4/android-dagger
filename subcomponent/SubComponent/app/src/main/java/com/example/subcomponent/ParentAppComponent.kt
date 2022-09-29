package com.example.subcomponent

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AnalyticsModule::class])
interface ParentAppComponent {
    /**
     * All the dependencies from ParentAppComponent(or AnalyticsModule) are directly supplied to
     * UserRegistrationSubComponent. We don't need to write  any  methods in  ParentAppComponent
     * to supply the dependencies to SubComponent.
     */

    //fun  getUserRegistrationSubComponentFactory() : UserRegistrationSubComponent.Factory

    fun  getUserRegistrationSubComponentBuilder() : UserRegistrationSubComponent.Builder

}