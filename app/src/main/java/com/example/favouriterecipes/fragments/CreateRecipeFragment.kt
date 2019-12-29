package com.example.favouriterecipes.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.findNavController

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
            view: View ->
            onClick()
            view.findNavController().navigate(R.id.action_createRecipeFragment_to_recipesMainFragment)
        }

        return binding.root

    }

    private fun onClick(){
        viewModel.insertRecipe(binding.editRecipeName.text.toString(), binding.editRecipeDescription.text.toString())
        Navigation.createNavigateOnClickListener(R.id.recipesMainFragment)
    }


}
