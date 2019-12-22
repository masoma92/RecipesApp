package com.example.favouriterecipes.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RecipeDatabaseDao {

    @Insert
    fun insert(recipe: Recipe)

    @Query("SELECT * FROM recipe_table")
    fun getAll() : LiveData<List<Recipe>>

    @Query("SELECT * FROM recipe_table ORDER BY recipe_id DESC LIMIT 1")
    fun getFirstRecipe(): Recipe?
}