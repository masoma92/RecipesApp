package com.example.favouriterecipes

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.favouriterecipes.database.Recipe
import com.example.favouriterecipes.database.RecipeDatabase
import com.example.favouriterecipes.database.RecipeDatabaseDao
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.lang.Exception

@RunWith(AndroidJUnit4::class)
class RecipeDatabaseTest {

    private lateinit var recipeDao: RecipeDatabaseDao

    private lateinit var db: RecipeDatabase

    @Before
    fun createDb(){
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        db = Room.inMemoryDatabaseBuilder(context, RecipeDatabase::class.java).allowMainThreadQueries().build()

        recipeDao = db.recipeDatabaseDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb(){
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetRecipe(){
        val recipe = Recipe(recipeName = "Pörkölt")
        recipeDao.insert(recipe)
        val currentRecipe = recipeDao.getFirstRecipe()
        assertEquals(currentRecipe?.recipeName, "Pörkölt")
    }

    @Test
    @Throws(Exception::class)
    fun getAllRecipes(){
        val allRecipes = recipeDao.getAll()

        assertNotNull(allRecipes)
    }
}