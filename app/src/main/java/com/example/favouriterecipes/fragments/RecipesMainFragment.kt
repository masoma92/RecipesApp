package com.example.favouriterecipes.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsSpinner
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.favouriterecipes.R
import com.example.favouriterecipes.database.Recipe
import com.example.favouriterecipes.databinding.FragmentRecipesMainBinding
import com.example.favouriterecipes.viewmodels.RecipesMainViewModel

/**
 * A simple [Fragment] subclass.
 */
class RecipesMainFragment : Fragment() {

    lateinit var viewModel: RecipesMainViewModel

    private lateinit var binding: FragmentRecipesMainBinding

    private lateinit var listView: ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recipes_main, container, false)

        viewModel = ViewModelProviders.of(this).get(RecipesMainViewModel::class.java)

        var adapter = ArrayAdapter<Recipe>(this.requireContext(), android.R.layout.simple_list_item_1)

        viewModel.recipes.observe(this, Observer { recipes -> recipes?.forEach{
            adapter.add(it)
        } })

        listView = binding.listviewRecipes
        listView.adapter = adapter

        binding.createRecipeButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_recipesMainFragment_to_createRecipeFragment))

        binding.setLifecycleOwner(this)

        return binding.root

    }


}
