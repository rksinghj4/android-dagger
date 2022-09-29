package com.example.applicationcomponent

import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

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
 * OR use abstract class to binds, here dagger knows,
 * how to create object of (of SQLRepository) it's interface's implementation
 */

@Module
abstract class UserRepositoryModule {
    /**
     * Dagger know how to create SQLRepository object. Therefore used
     * @Binds
     */
    //@Singleton
    @Binds
    abstract fun getSqlRepository(sqlRepository: SQLRepository): UserRepository
}