package com.example.fieldinjection

import android.util.Log
import javax.inject.Inject

interface UserRepository {
    fun save(email: String, password: String)
}

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