package com.softwarearch.shoppingapplication.context_modules;

import android.content.Context;

import com.softwarearch.shoppingapplication.view.activities.SplashActivity;
import com.softwarearch.shoppingapplication.context.ActivityContext;
import com.softwarearch.shoppingapplication.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class SplashActivityContextModule {
    private SplashActivity splashActivity;
    private Context context;

    public SplashActivityContextModule(SplashActivity splashActivity){
        this.splashActivity = splashActivity;
        context = splashActivity;
    }

    @Provides
    @ActivityScope
    public SplashActivity providesLoginActivity(){
        return splashActivity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context providesContext(){
        return context;
    }
}
