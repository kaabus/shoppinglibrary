package com.softwarearch.shoppingapplication.context_modules;

import android.content.Context;

import com.softwarearch.shoppingapplication.context.ApplicationContext;
import com.softwarearch.shoppingapplication.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private Context context;

    public ContextModule(Context context){
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context providesContext(){
        return context;
    }
}
