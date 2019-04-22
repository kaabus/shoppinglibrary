package com.softwarearch.shoppingapplication.context_modules;

import com.softwarearch.shoppingapplication.Utils;
import com.softwarearch.shoppingapplication.application.ShoppingApplication;
import com.softwarearch.shoppingapplication.database.ShoppingApplicationDatabase;
import com.softwarearch.shoppingapplication.database.UserDao;
import com.softwarearch.shoppingapplication.scopes.ApplicationScope;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;

@Module
public class RoomDbModule {

    private final ShoppingApplication mShoppingApplication;

    public RoomDbModule(ShoppingApplication mShoppingApplication) {
        this.mShoppingApplication = mShoppingApplication;
    }



    @Provides
    @ApplicationScope
    UserDao getUserDao(){
        return Room.databaseBuilder(mShoppingApplication, ShoppingApplicationDatabase.class, Utils.databaseName).build().userDao();
    }
}
