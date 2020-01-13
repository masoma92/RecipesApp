package com.example.favouriterecipes.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import com.example.favouriterecipes.R
import com.example.favouriterecipes.database.Recipe
import com.example.favouriterecipes.database.RecipeDatabase
import com.example.favouriterecipes.database.RecipeRepository
import kotlinx.coroutines.*

class SelectedRecipeViewModel(application: Application) : AndroidViewModel(application) {

    //lateinit var selectedRecipe: Recipe

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

    fun deleteSelectedRecipe(){
        uiScope.launch {
            val recipeId = selectedRecipe.recipeId

            withContext(Dispatchers.IO){
                repository.delete(recipeId)
            }
        }
    }


}