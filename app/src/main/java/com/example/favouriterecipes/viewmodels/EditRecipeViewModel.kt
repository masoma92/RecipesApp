package com.example.favouriterecipes.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.favouriterecipes.database.Recipe
import com.example.favouriterecipes.database.RecipeDatabase
import com.example.favouriterecipes.database.RecipeRepository
import kotlinx.coroutines.*

class EditRecipeViewModel(application: Application) : AndroidViewModel(application) {

    // recipe to update values
    lateinit var selectedRecipe: Recipe

    private val repository: RecipeRepository

    private var viewModelJob = Job()

    init {

        val dataSource= RecipeDatabase.getInstance(application).recipeDatabaseDao
        repository = RecipeRepository(dataSource)

    }

    fun setSelectedRecipe(id: Long, recipeName: String, recipeDescription: String){
        selectedRecipe = Recipe(id, recipeName, recipeDescription)
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun saveModifiedRecipe(){
        uiScope.launch {

            withContext(Dispatchers.IO){
                repository.update(selectedRecipe)
            }
        }
    }


}