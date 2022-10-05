package com.example.mvvmretrofitcoroutine.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvmretrofitcoroutine.models.Product

@Database(entities = [Product::class], version = 1, exportSchema = true)
abstract class FakerDB : RoomDatabase() {

    abstract fun getFakerDAO() : FakerDAO

}