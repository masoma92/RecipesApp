package com.example.favouriterecipes.database

import androidx.room.Query

class RecipeRepository(private val databaseDao: RecipeDatabaseDao) {

    val recipes = databaseDao.getAll()

    fun insert(recipe: Recipe){
        databaseDao.insert(recipe)
    }

    fun delete(recipeId: Long){
        databaseDao.delete(recipeId)
    }

    fun update(recipe: Recipe){
        databaseDao.update(recipe)
    }

    fun getById(id: Int): Recipe{
        return databaseDao.getById(id)
    }

}