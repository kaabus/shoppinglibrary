package com.softwarearch.shoppingapplication.application;

import android.app.Activity;
import android.app.Application;

import com.softwarearch.shoppingapplication.components.ApplicationComponent;
import com.softwarearch.shoppingapplication.components.DaggerApplicationComponent;
import com.softwarearch.shoppingapplication.context_modules.ContextModule;
import com.softwarearch.shoppingapplication.context_modules.RoomDbModule;

public class ShoppingApplication extends Application {

    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        dependencyInjection();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public static ShoppingApplication get(Activity activity){
        return (ShoppingApplication) activity.getApplication();
    }

    private void dependencyInjection(){
        applicationComponent = DaggerApplicationComponent.builder()
                .roomDbModule(new RoomDbModule(this))
                .contextModule(new ContextModule(this)).build();

        applicationComponent.injectApplication(this);
    }
}
