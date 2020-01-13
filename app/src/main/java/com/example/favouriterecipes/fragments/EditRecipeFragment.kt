package com.example.favouriterecipes.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.favouriterecipes.R
import com.example.favouriterecipes.databinding.FragmentEditRecipeBinding
import com.example.favouriterecipes.viewmodels.EditRecipeViewModel
import com.example.favouriterecipes.viewmodels.SelectedRecipeViewModel

/**
 * A simple [Fragment] subclass.
 */
class EditRecipeFragment : Fragment() {

    private lateinit var binding: FragmentEditRecipeBinding

    private lateinit var viewModel: EditRecipeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_recipe, container, false)

        viewModel = ViewModelProviders.of(this).get(EditRecipeViewModel::class.java)

        binding.editRecipeViewModel = viewModel

        binding.saveButton.setOnClickListener { view : View ->
            viewModel.selectedRecipe.recipeName = binding.editRecipeName.text.toString()
            viewModel.selectedRecipe.recipeDescription = binding.editRecipeDescription.text.toString()

            viewModel.saveModifiedRecipe()
            view.findNavController().navigate(R.id.action_editRecipeFragment_to_recipesMainFragment)
        }

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
