package com.example.applicationcomponent

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

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

@Singleton
class SQLRepository @Inject constructor() : UserRepository {
    override fun save(email: String, password: String) {
        Log.d(TAG, "User saved in DB")
    }
}

class FirebaseRepository : UserRepository {
    override fun save(email: String, password: String) {
        Log.d(TAG, "User saved in Firebase")
    }
}