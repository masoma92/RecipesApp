package com.example.favouriterecipes.database

class RecipeRepository(private val databaseDao: RecipeDatabaseDao) {

    val recipes = databaseDao.getAll()

    fun insert(recipe: Recipe){
        databaseDao.insert(recipe)
    }
}