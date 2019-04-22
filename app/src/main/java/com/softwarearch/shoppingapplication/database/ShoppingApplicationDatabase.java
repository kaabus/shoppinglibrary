package com.softwarearch.shoppingapplication.database;

import com.softwarearch.shoppingapplication.models.database_models.User;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class},version = 1, exportSchema = false)
public abstract class ShoppingApplicationDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
