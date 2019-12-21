package com.example.favouriterecipes.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.favouriterecipes.database.RecipeDatabaseDao

class MainViewModel(
    val database: RecipeDatabaseDao,
    application: Application) : AndroidViewModel(application) {

}