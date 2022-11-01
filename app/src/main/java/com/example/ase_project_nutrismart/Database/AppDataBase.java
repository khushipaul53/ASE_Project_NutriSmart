package com.example.ase_project_nutrismart.Database;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.ase_project_nutrismart.Response.LoginResponse;

@Database(entities = {LoginResponse.class},

        version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract UserDao userDao();

//    AppDataBase db = Room.databaseBuilder(,
//            AppDataBase.class, "database-name").build();
    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
