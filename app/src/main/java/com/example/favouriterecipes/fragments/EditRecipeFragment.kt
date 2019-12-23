package com.example.favouriterecipes.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.favouriterecipes.R
import com.example.favouriterecipes.databinding.FragmentEditRecipeBinding

/**
 * A simple [Fragment] subclass.
 */
class EditRecipeFragment : Fragment() {

    private lateinit var binding: FragmentEditRecipeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_recipe, container, false)

        return binding.root

    }


}
