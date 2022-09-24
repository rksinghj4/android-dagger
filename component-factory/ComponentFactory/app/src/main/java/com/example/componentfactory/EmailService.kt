package com.example.componentfactory

import android.util.Log
import javax.inject.Inject

interface NotificationService {
    fun send(to: String, from: String, body: String?)
}

class EmailService @Inject constructor() : NotificationService {
    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Email: $body")
    }
}

class MessageService(val retryCount: Int) : NotificationService {
    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Message: $body, retryCount = $retryCount")
    }
}