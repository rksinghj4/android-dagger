package com.example.mvvmretrofitcoroutine.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmretrofitcoroutine.models.Product

@Dao
interface FakerDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(products : List<Product>)

    @Query("SELECT * FROM Product")
    suspend fun getProducts() : List<Product>

}