package com.example.favouriterecipes.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.favouriterecipes.database.Recipe
import com.example.favouriterecipes.database.RecipeDatabase
import com.example.favouriterecipes.database.RecipeDatabaseDao
import com.example.favouriterecipes.database.RecipeRepository
import kotlinx.coroutines.*

class CreateRecipeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: RecipeRepository

    init {

        val dataSource= RecipeDatabase.getInstance(application).recipeDatabaseDao
        repository = RecipeRepository(dataSource)

    }

    //from here udacity

    private var viewModelJob = Job()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun insertRecipe(recipeName: String, recipeDescription: String){
        uiScope.launch {
            val recipe = Recipe(recipeName = recipeName, recipeDescription = recipeDescription)

            withContext(Dispatchers.IO){
                repository.insert(recipe)
            }

        }

    }
}