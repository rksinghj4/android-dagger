package com.example.daggercomponent

import android.util.Log
import javax.inject.Inject

class EmailService @Inject constructor() {
    internal fun send(to: String, from: String,  body: String?) {
        Log.d(TAG,  "$body")
    }
}