package com.example.favouriterecipes.database

class RecipeRepository(private val databaseDao: RecipeDatabaseDao) {

    val recipes = databaseDao.getAll()

    fun insert(recipe: Recipe){
        databaseDao.insert(recipe)
    }

    fun delete(recipe: Recipe){
        databaseDao.delete(recipe)
    }

    fun update(recipe: Recipe){
        databaseDao.update(recipe)
    }

    fun getById(id: Int){
        val recipes = databaseDao.getAll()
    }
}