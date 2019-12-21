package com.example.favouriterecipes.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe_table")
data class Recipe(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "recipe_id")
    var recipeId: Long = 0L,

    @ColumnInfo(name = "recipe_name")
    var recipeName: String = "",

    @ColumnInfo(name = "recipe_description")
    var recipeDescription: String = ""
)