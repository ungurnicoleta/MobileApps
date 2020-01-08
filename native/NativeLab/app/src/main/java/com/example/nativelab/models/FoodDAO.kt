package com.example.nativelab.models

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface FoodDao {
    @Query("SELECT * FROM food_items")
    fun getAll(): List<Food>

    @Query("SELECT * FROM food_items WHERE title LIKE :title")
    fun findByTitle(title: String): LiveData<List<Food>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg food: Food)

    @Delete
    fun delete(food: Food)

    @Update
    fun updateFood(vararg foods: Food)
}