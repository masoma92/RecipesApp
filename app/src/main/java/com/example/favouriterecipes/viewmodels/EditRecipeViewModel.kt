package com.example.favouriterecipes.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.favouriterecipes.database.Recipe
import com.example.favouriterecipes.database.RecipeDatabase
import com.example.favouriterecipes.database.RecipeRepository

class EditRecipeViewModel(application: Application) : AndroidViewModel(application) {

    // recipe to update values
    lateinit var selectedRecipe: Recipe

    private val repository: RecipeRepository

    init {

        val dataSource= RecipeDatabase.getInstance(application).recipeDatabaseDao
        repository = RecipeRepository(dataSource)

    }


}