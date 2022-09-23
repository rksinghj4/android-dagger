package com.example.fieldinjection

import dagger.Binds
import dagger.Module
import dagger.Provides

//@Module
//class UserRepositoryModule {
//    /**
//     * Problem: Without qualifier we can't provide multiple implementations for UserRepository.
//     * That's why we can use one at a time.
//     */
//
//    @Provides
//    fun getFrireBaseRepository(): UserRepository {
//        return FirebaseRepository()
//    }
//
//    /**
//     * Alternative of below one  is with @Binds because dagger know how to create SQLRepository.
//     */
//
//
//    @Provides
//    fun getSqlRepository(sqlRepository: SQLRepository): UserRepository {
//        return sqlRepository
//    }
//
//}
//


/**
 * OR use abstract class to binds  dagger known object to it's interface
 */

@Module
abstract class UserRepositoryModule {
    /**
     * Dagger know how to create SQLRepository object. Therefore used
     * @Binds
     */
    @Binds
    abstract fun getSqlRepository(sqlRepository: SQLRepository): UserRepository
}