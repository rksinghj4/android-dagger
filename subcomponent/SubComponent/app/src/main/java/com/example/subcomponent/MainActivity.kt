package com.example.subcomponent


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.subcomponent.commonmodule.NotificationService
import com.example.subcomponent.commonmodule.UserRegistrationService
import com.example.subcomponent.commonmodule.UserRepository
import com.example.subcomponent.customannotations.EmailQualifier
import com.example.subcomponent.dependencyapproach.DaggerUserRegistrationComponent
import javax.inject.Inject

/**
 * Problem: if we inject property at top level
 * Kotlin error: Dagger does not support injection into static fields
 */

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var userRegistrationService: UserRegistrationService

    @EmailQualifier
    @Inject
    lateinit var notificationService: NotificationService

    //Problem: 11 -  Dagger will create different object of NotificationService
    // for each injection without singleton.
    //Solution 11 - @Singleton

    @EmailQualifier
    @Inject
    lateinit var notificationService1: NotificationService

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    lateinit var userRepository1: UserRepository

    /**
     * AnalyticsService object is coming from bigger bucket component(i.e AppComponent)
     * So smaller life component must add:
     *
     * @ActivityScope
     * @Component(
     *     dependencies = [AppComponent::class],
     *     modules = [UserRepositoryModule::class, NotificationServiceModule::class]
     * )
     * interface UserRegistrationComponent
     *
     * and bigger bucket/life component
     * @Singleton
     * @Component(modules = [AnalyticsModule::class])
     * interface AppComponent
     *
     * must add signature method  fun getAnalyticsService(): AnalyticsService
     * even though AnalyticsModule provide the same
     */
    @Inject
    lateinit var analyticsService1: AnalyticsService

    @Inject
    lateinit var analyticsService2: AnalyticsService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //If we initialize DaggerAppComponent  in activity then
        // it gives activity wide singleton.
        // Moved this to UserApplication: to get application wide  singleton.

        /**
         * DaggerUserRegistrationComponent.builder() will through errors
         * so we have to use factory to create object of component.
         * We will not forget to pass required values.
         */
        val appcomponent = (application as UserApplication).appComponent
        val userRegistrationComponent =
            DaggerUserRegistrationComponent.factory().create(4, 111, appcomponent)
        userRegistrationComponent.inject(this)

        userRegistrationService.registerUser("abc@xyz.com", "2222")
        notificationService.send("aa", "bb", "notification from MainActivity")

        /**
         * Same appComponent will be fetched from application
         * there for all singleton annotated instance will we same singleton under the appComponent.
         */

        /**
         * Using Factory pattern
         */

        /* val parentAppComponent = (application as UserApplication).parentAppComponent
         val userRegistrationSubComponent = parentAppComponent.getUserRegistrationSubComponentFactory().create(5, 112)
         userRegistrationSubComponent.inject(this)
         userRegistrationService.registerUser("aaaabc@xyz.com", "3333")
         notificationService1.send("aaa", "bbb", "notification from MainActivity")
 */
        /**
         * Using builder pattern
         */

        val parentAppComponent2 = (application as UserApplication).parentAppComponent
        val userRegistrationSubComponent2 =
            parentAppComponent2.getUserRegistrationSubComponentBuilder().retryCount(2)
                .emailRetryCount(5).build()
        userRegistrationSubComponent2.inject(this)

        userRegistrationService.registerUser("aaaabc@xyz.com", "3333")
        notificationService1.send("aaa", "bbb", "notification from MainActivity")
    }
}