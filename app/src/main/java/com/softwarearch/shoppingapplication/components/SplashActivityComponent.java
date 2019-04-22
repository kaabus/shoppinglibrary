package com.softwarearch.shoppingapplication.components;

import android.content.Context;

import com.softwarearch.shoppingapplication.view.activities.SplashActivity;
import com.softwarearch.shoppingapplication.context.ActivityContext;
import com.softwarearch.shoppingapplication.context_modules.SplashActivityContextModule;
import com.softwarearch.shoppingapplication.mvp_modules.SplashActivityMvpModule;
import com.softwarearch.shoppingapplication.scopes.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(modules = {SplashActivityContextModule.class, SplashActivityMvpModule.class},
        dependencies = ApplicationComponent.class)
public interface SplashActivityComponent {

    @ActivityContext
    Context getContext();
    void injectSplashActivity(SplashActivity splashActivity);
}
