package com.example.ase_project_nutrismart.Database

import androidx.room.Database
import com.example.ase_project_nutrismart.Response.LoginResponse
import androidx.room.RoomDatabase
import com.example.ase_project_nutrismart.Database.UserDao
import androidx.room.DatabaseConfiguration
import androidx.sqlite.db.SupportSQLiteOpenHelper
import androidx.room.InvalidationTracker
import com.example.ase_project_nutrismart.Database.AppDataBase
import com.example.ase_project_nutrismart.Database.DatabaseClient
import kotlin.jvm.Synchronized
import androidx.room.Room
import androidx.room.Dao

@Database(entities = [LoginResponse::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao?

    //    AppDataBase db = Room.databaseBuilder(,
    //            AppDataBase.class, "database-name").build();
    override fun createOpenHelper(config: DatabaseConfiguration): SupportSQLiteOpenHelper {
        return null
    }

    override fun createInvalidationTracker(): InvalidationTracker {
        return null
    }

    override fun clearAllTables() {}
}