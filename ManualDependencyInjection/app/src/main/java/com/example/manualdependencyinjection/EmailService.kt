package com.example.manualdependencyinjection

import android.util.Log

class EmailService {
    internal fun send(to: String, from: String,  body: String?) {
        Log.d(TAG,  "Email sent")
    }
}