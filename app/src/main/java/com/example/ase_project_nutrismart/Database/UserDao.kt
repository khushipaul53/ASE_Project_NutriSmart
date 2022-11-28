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

@Dao
interface UserDao { //    @Query("SELECT * FROM Login")
    //    List<LoginModel> getAll();
    //
    //    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    //    List<User> loadAllByIds(int[] userIds);
    //
    //    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
    //            "last_name LIKE :last LIMIT 1")
    //    User findByName(String first, String last);
    //
    //    @Insert
    //    void insertAll(User... users);
    //
    //    @Delete
    //    void delete(User user);
}