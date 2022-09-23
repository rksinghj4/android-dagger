package com.example.fieldinjection

import dagger.Module
import dagger.Provides

@Module
class UserRepositoryModule {
    @Provides
    fun getFrireBaseRepository(): UserRepository {
        return FirebaseRepository()
    }
}