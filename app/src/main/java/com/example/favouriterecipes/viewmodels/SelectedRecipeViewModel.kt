package com.example.favouriterecipes.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.favouriterecipes.database.Recipe
import com.example.favouriterecipes.database.RecipeDatabase
import com.example.favouriterecipes.database.RecipeRepository

class SelectedRecipeViewModel(application: Application) : AndroidViewModel(application) {

    lateinit var selectedRecipe: Recipe

    private val repository: RecipeRepository

    init {
        val dataSource= RecipeDatabase.getInstance(application).recipeDatabaseDao
        repository = RecipeRepository(dataSource)

    }

    fun deleteSelectedRecipe(id: Int){
        repository.delete(getSelectedRecipe(id))
    }

    fun getSelectedRecipe(id: Int) : Recipe{
        val recipes = repository.recipes
        return recipes.value?.elementAt(id) as Recipe
    }

}