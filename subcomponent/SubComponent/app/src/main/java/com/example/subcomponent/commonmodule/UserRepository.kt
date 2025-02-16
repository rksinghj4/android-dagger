package com.example.subcomponent.commonmodule

import android.util.Log
import com.example.subcomponent.AnalyticsService
import com.example.subcomponent.TAG
import com.example.subcomponent.customannotations.ActivityScope
import javax.inject.Inject

interface UserRepository {
    fun save(email: String, password: String)
}

/**
 * Dagger is allowed to call constructor.
 */
// @Singleton annotation is directly applied to providers
//but in case of @Binds we should apply to dagger known @Injected constructor.
// We can apply to place where we @Binds but then we have to apply  @Singleton
// in all connectors/components who wants to create objects.

@ActivityScope
class SQLRepository @Inject constructor(val analyticsService: AnalyticsService) : UserRepository {
    override fun save(email: String, password: String) {
        Log.d(TAG, "User saved in DB")
        analyticsService.trackEvent("Save user", "CREATE")
    }
}

class FirebaseRepository(val analyticsService: AnalyticsService) : UserRepository {
    override fun save(email: String, password: String) {
        Log.d(TAG, "User saved in Firebase")
        analyticsService.trackEvent("Save user", "CREATE")
    }
}