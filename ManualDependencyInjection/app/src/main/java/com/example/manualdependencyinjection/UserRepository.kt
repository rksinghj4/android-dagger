package com.example.manualdependencyinjection

import android.util.Log

class UserRepository {
    internal fun save(email: String, password: String) {
        Log.d(TAG, "User saved in DB")
    }
}