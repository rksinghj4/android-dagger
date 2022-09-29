package com.example.subcomponent

import android.util.Log

/**
 *  Since AnalyticsService is a interface
 *  We need to write a module to create object of it's implementing calss
 */
interface AnalyticsService {
    fun trackEvent(eventName: String, eventType: String)
}

class Mixpanel : AnalyticsService {
    override fun trackEvent(eventName: String, eventType: String) {
        Log.d(TAG, "Mixpanel $eventName - $eventType")
    }
}

class FirebaseAnalytics : AnalyticsService {
    override fun trackEvent(eventName: String, eventType: String) {
        Log.d(TAG, "FirebaseAnalytics $eventName - $eventType")
    }
}