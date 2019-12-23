package com.example.favouriterecipes.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.favouriterecipes.R
import com.example.favouriterecipes.databinding.FragmentSelectedRecipeBinding

/**
 * A simple [Fragment] subclass.
 */
class SelectedRecipeFragment : Fragment() {

    private lateinit var binding: FragmentSelectedRecipeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_recipe, container, false)

        return binding.root
    }


}
