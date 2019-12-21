package com.example.favouriterecipes


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.favouriterecipes.databinding.FragmentRecipesMainBinding

/**
 * A simple [Fragment] subclass.
 */
class RecipesMainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentRecipesMainBinding>(inflater, R.layout.fragment_recipes_main, container, false)

        return binding.root

    }


}
