package com.example.favouriterecipes.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.favouriterecipes.R
import com.example.favouriterecipes.database.Recipe
import com.example.favouriterecipes.databinding.FragmentSelectedRecipeBinding
import com.example.favouriterecipes.viewmodels.SelectedRecipeViewModel

/**
 * A simple [Fragment] subclass.
 */
class SelectedRecipeFragment : Fragment() {

    private lateinit var binding: FragmentSelectedRecipeBinding

    lateinit var viewModel: SelectedRecipeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_selected_recipe, container, false)

        viewModel = ViewModelProviders.of(this).get(SelectedRecipeViewModel::class.java)

        binding.selectedRecipeViewModel = viewModel

        binding.removeButton.setOnClickListener { view: View ->
            viewModel.deleteSelectedRecipe()
            view.findNavController().navigate(R.id.action_selectedRecipeFragment_to_recipesMainFragment) }

        binding.editButton.setOnClickListener { view: View ->
            val action = SelectedRecipeFragmentDirections.actionSelectedRecipeFragmentToEditRecipeFragment()
            action.setRecipeName(viewModel.selectedRecipe.recipeName)
            action.setRecipeDescription(viewModel.selectedRecipe.recipeDescription)
            action.setRecipeId(viewModel.selectedRecipe.recipeId)
            view.findNavController().navigate(action)
        }

        //binding.setLifecycleOwner(this)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val id = SelectedRecipeFragmentArgs.fromBundle(arguments).recipeId
        val recipeName = SelectedRecipeFragmentArgs.fromBundle(arguments).recipeName
        val recipeDescription = SelectedRecipeFragmentArgs.fromBundle(arguments).recipeDescription
        viewModel.setSelectedRecipe(id, recipeName, recipeDescription)
    }
}
