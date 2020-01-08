package com.example.favouriterecipes.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.favouriterecipes.R
import com.example.favouriterecipes.databinding.FragmentSelectedRecipeBinding
import com.example.favouriterecipes.viewmodels.SelectedRecipeViewModel

/**
 * A simple [Fragment] subclass.
 */
class SelectedRecipeFragment : Fragment() {

    private lateinit var binding: FragmentSelectedRecipeBinding

    lateinit var viewModel: SelectedRecipeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_recipe, container, false)

        viewModel = ViewModelProviders.of(this).get(SelectedRecipeViewModel::class.java)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val id = SelectedRecipeFragmentArgs.fromBundle(arguments).recipeId
        val recipe = viewModel.getSelectedRecipe(id)
        viewModel.selectedRecipe = recipe
    }
}
