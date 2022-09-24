package com.example.componentfactory

import android.util.Log
import javax.inject.Inject

interface NotificationService {
    fun send(to: String, from: String, body: String?)
}

//Note: UserRegistrationComponent has an and interger value with @EmailRetryQualifier,
// he will supply this value.
class EmailService @Inject constructor(@EmailRetryQualifier  retryCount: Int) : NotificationService {
     val retryCountEmail = retryCount
    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Email: $body, retryCount = $retryCountEmail")
    }
}

class MessageService(val retryCount: Int) : NotificationService {
    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Message: $body, retryCount = $retryCount")
    }
}