package com.example.subcomponent.dependencyapproach

import com.example.subcomponent.commonmodule.AnalyticsModule
import com.example.subcomponent.AnalyticsService
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AnalyticsModule::class])
interface AppComponent {
    /**
     * AnalyticsService object is application wide
     * singleton, if smaller bucket or smaller life time component
     * e.g @ActivityScoped component wants to get some dependencies from bigger bucket component then
     * bigger bucket component has to add signature method like getAnalyticsService() below and
     * smaller bucket component has to add dependencies = [AppComponent::class]
     *
     * @ActivityScope
     * @Component(
     *     dependencies = [AppComponent::class],
     *     modules = [UserRepositoryModule::class, NotificationServiceModule::class]
     * )
     *
     * Note: Smaller bucket and larger bucket both are using same @Component annotation
     *
     * Solution is @Subcomponent - we don't need to add signature methods
     */
    fun getAnalyticsService(): AnalyticsService

    /**
     * Problem: here we have to add methods for all  dependencies which can be provided by
     * AppComponent with the help of modules and
     * other dependencies if any(like @Inject constructor with scoped annotation).
     */
}