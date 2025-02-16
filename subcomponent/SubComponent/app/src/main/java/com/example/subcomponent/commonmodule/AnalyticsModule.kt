package com.example.subcomponent.commonmodule

import com.example.subcomponent.AnalyticsService
import com.example.subcomponent.Mixpanel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * AnalyticsModule is used by bigger bucket component(in side UserApplication)
 */
@Module
class AnalyticsModule {

    @Singleton
    @Provides
    fun getAnalyticsService(): AnalyticsService {
        /**
         *Lives as long as AppComponent (whose life is inside UserApplication obj)
         * Because AppComponent and this method both have same @Singleton scope
         */
        return Mixpanel()
    }
}