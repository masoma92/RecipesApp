package com.example.favouriterecipes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Recipe::class], version = 1, exportSchema = false)
abstract class RecipeDatabase: RoomDatabase() {

    abstract val recipeDatabaseDao: RecipeDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: RecipeDatabase? = null

        fun getInstance(context: Context) : RecipeDatabase{
            synchronized(this){
                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(context.applicationContext, RecipeDatabase::class.java, "recipe_table")
                        .addCallback(seedDatabaseCallback(context))
                        .fallbackToDestructiveMigration()
                        .build()
                }

                return instance
            }
        }

        private fun seedDatabaseCallback(context: Context): RoomDatabase.Callback {
            return object : Callback(){
                override fun onCreate(db: SupportSQLiteDatabase){
                    super.onCreate(db)
                    Thread(Runnable { var recipeDao = getInstance(context).recipeDatabaseDao
                    for (r in getRecipes())
                        recipeDao.insert(r)
                    }).start()
                }
            }
        }

    }

}