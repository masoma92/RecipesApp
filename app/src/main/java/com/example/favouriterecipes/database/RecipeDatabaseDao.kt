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
    fun delete(recipeId: Long)

    @Update
    fun update(recipe: Recipe)

    @Query("SELECT recipe_id, recipe_name, recipe_description FROM recipe_table WHERE recipe_id =:id")
    fun getById(id: Int): Recipe
}