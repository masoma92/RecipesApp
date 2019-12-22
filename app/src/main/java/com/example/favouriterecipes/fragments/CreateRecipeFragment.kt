package com.example.favouriterecipes.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation

import com.example.favouriterecipes.R
import com.example.favouriterecipes.database.Recipe
import com.example.favouriterecipes.database.RecipeDatabase
import com.example.favouriterecipes.database.RecipeDatabaseDao
import com.example.favouriterecipes.databinding.FragmentCreateRecipeBinding
import com.example.favouriterecipes.viewmodels.CreateRecipeViewModel

/**
 * A simple [Fragment] subclass.
 */
class CreateRecipeFragment : Fragment() {

    lateinit var viewModel: CreateRecipeViewModel

    private lateinit var binding: FragmentCreateRecipeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_recipe, container, false)

        viewModel = ViewModelProviders.of(this).get(CreateRecipeViewModel::class.java)

        binding.saveButton.setOnClickListener{
            createRecipe()
            Navigation.createNavigateOnClickListener(R.id.recipesMainFragment)}

        return binding.root

    }

    private fun createRecipe(){

        val recipe = Recipe(recipeName = binding.editRecipeName.toString(), recipeDescription = binding.editRecipeDescription.toString())

        viewModel.insertRecipe(recipe)
    }


}
