package com.example.ase_project_nutrismart.Database

import android.content.Context
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

class DatabaseClient private constructor(private val mCtx: Context) {
    val appDatabase: AppDataBase

    companion object {
        private var mInstance: DatabaseClient? = null
        @Synchronized
        fun getInstance(mCtx: Context): DatabaseClient? {
            if (mInstance == null) {
                mInstance = DatabaseClient(mCtx)
            }
            return mInstance
        }
    }

    init {

        //creating the app database with Room database builder
        //MyToDos is the name of the database
        appDatabase = Room.databaseBuilder(mCtx, AppDataBase::class.java, "NurtiSmart").build()
    }
}