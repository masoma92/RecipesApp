package com.example.favouriterecipes.viewmodels

import android.app.Application
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.favouriterecipes.database.Recipe
import com.example.favouriterecipes.database.RecipeDatabase
import com.example.favouriterecipes.database.RecipeDatabaseDao
import com.example.favouriterecipes.database.RecipeRepository

class RecipesMainViewModel(application: Application) : AndroidViewModel(application), AdapterView.OnItemSelectedListener {

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        selectedRecipe = parent?.getItemAtPosition(position) as Recipe
        Log.i("RecipesMainViewModel", "selected " + selectedRecipe)
    }

    private val repository: RecipeRepository

    var recipes:LiveData<List<Recipe>>

    lateinit var selectedRecipe: Recipe

    init {
        val dataSource=RecipeDatabase.getInstance(application).recipeDatabaseDao
        repository = RecipeRepository(dataSource)

        recipes = repository.recipes
    }

}