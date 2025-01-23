package com.example.fieldinjection

import android.util.Log
import javax.inject.Inject

interface NotificationService {
    fun send(to: String, from: String, body: String?)
}

//Because we are using @Inject constructor() now dagger got capability to create EmailService objects,
//whenever, wherever needed.
class EmailService @Inject constructor() : NotificationService {
    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Email: $body")
    }
}

class MessageService : NotificationService {
    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Message: $body")
    }
}