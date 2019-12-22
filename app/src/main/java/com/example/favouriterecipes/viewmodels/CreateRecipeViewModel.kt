package com.example.favouriterecipes.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.favouriterecipes.database.Recipe
import com.example.favouriterecipes.database.RecipeDatabase
import com.example.favouriterecipes.database.RecipeDatabaseDao
import com.example.favouriterecipes.database.RecipeRepository

class CreateRecipeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: RecipeRepository

    private val dataSource: RecipeDatabaseDao

    var recipes: LiveData<List<Recipe>>

    lateinit var selectedRecipe: Recipe

    init {

        dataSource= RecipeDatabase.getInstance(application).recipeDatabaseDao
        repository = RecipeRepository(dataSource)

        recipes = repository.recipes
    }

    fun insertRecipe(recipe: Recipe){
        dataSource.insert(recipe)
    }
}