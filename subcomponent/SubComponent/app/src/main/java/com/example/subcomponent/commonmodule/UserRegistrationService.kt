package com.example.subcomponent.commonmodule

import android.util.Log
import com.example.subcomponent.TAG
import com.example.subcomponent.customannotations.MessageQualifier
import javax.inject.Inject

/**
 * Problems with the class
 * 1. Unit testing is not possible.
 * 2. Not extensible
 * 3. Single responsibility not obeyed
 * 4. Lifetime of these objects(i.e emailService, userRepository) are tied with container class. Not reusable.
 */
/*class UserRegistrationService {
    private val emailService = EmailService()
    private val userRepository = UserRepository()
    internal fun registerUser(email: String, password: String) {
        userRepository.save(email = email, password = password)
        emailService.send(email, "no-reply@abc.com", "User registered")
    }
}*/

//Above all 4 problems are solved here using constructor injection.
class UserRegistrationService @Inject constructor(
    @MessageQualifier private val notificationService: NotificationService,
    private val userRepository: UserRepository
) {
    init {
        Log.d(TAG, "UserRegistrationService initialization")
    }

    internal fun registerUser(email: String, password: String) {
        userRepository.save(email = email, password = password)
        notificationService.send(email, "no-reply@abc.com", "User registered")
    }
}