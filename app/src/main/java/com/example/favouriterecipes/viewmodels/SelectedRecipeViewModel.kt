package com.example.favouriterecipes.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.favouriterecipes.database.Recipe
import com.example.favouriterecipes.database.RecipeDatabase
import com.example.favouriterecipes.database.RecipeRepository

class SelectedRecipeViewModel(application: Application) : AndroidViewModel(application) {

    //lateinit var selectedRecipe: Recipe

    lateinit var selectedRecipe: Recipe

    private val repository: RecipeRepository

    init {
        val dataSource= RecipeDatabase.getInstance(application).recipeDatabaseDao
        repository = RecipeRepository(dataSource)

    }

    fun deleteSelectedRecipe(){
        repository.delete(selectedRecipe.recipeId)
    }

    fun setSelectedRecipe(id: Long, recipeName: String, recipeDescription: String){

        selectedRecipe = Recipe(id, recipeName, recipeDescription)
    }


}