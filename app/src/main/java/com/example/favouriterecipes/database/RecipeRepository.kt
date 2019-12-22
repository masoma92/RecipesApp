package com.example.favouriterecipes.database

class RecipeRepository(private val database: RecipeDatabaseDao) {

    val recipes = database.getAll()
}