package com.example.favouriterecipes.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RecipeDatabaseDao {

    @Query("SELECT * FROM recipe_table")
    fun getAll() : LiveData<List<Recipe>>

    @Insert
    fun insert(recipe: Recipe)

    @Delete
    fun delete(recipe: Recipe)

    @Update
    fun update(recipe: Recipe)
}