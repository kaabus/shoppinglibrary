package com.softwarearch.shoppingapplication.components;

import android.content.Context;

import com.softwarearch.shoppingapplication.api.ApiService;
import com.softwarearch.shoppingapplication.application.ShoppingApplication;
import com.softwarearch.shoppingapplication.context.ApplicationContext;
import com.softwarearch.shoppingapplication.context_modules.ContextModule;
import com.softwarearch.shoppingapplication.context_modules.RetrofitModule;
import com.softwarearch.shoppingapplication.context_modules.RoomDbModule;
import com.softwarearch.shoppingapplication.database.UserDao;
import com.softwarearch.shoppingapplication.scopes.ApplicationScope;

import dagger.Component;

@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class,RoomDbModule.class})
public interface ApplicationComponent {
    ApiService getApiService();
    UserDao getDao();

    @ApplicationContext
    Context getContext();

    void injectApplication(ShoppingApplication mShoppingApplication);
}
