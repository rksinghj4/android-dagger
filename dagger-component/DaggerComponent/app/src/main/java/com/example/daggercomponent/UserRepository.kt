package com.example.daggercomponent

import android.util.Log
import javax.inject.Inject

class UserRepository  @Inject constructor() {
    internal fun save(email: String, password: String) {
        Log.d(TAG, "User saved in DB")
    }
}