package com.softwarearch.shoppingapplication.context_modules;

import android.content.Context;

import com.softwarearch.shoppingapplication.view.activities.LoginActivity;
import com.softwarearch.shoppingapplication.context.ActivityContext;
import com.softwarearch.shoppingapplication.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginActivityContextModule {
    private LoginActivity loginActivity;
    private Context context;

    public LoginActivityContextModule(LoginActivity loginActivity){
        this.loginActivity = loginActivity;
        context = loginActivity;
    }

    @Provides
    @ActivityScope
    public LoginActivity providesLoginActivity(){
        return loginActivity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context providesContext(){
        return context;
    }
}
