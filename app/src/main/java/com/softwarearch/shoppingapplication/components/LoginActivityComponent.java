package com.softwarearch.shoppingapplication.components;

import android.content.Context;

import com.softwarearch.shoppingapplication.view.activities.LoginActivity;
import com.softwarearch.shoppingapplication.context.ActivityContext;
import com.softwarearch.shoppingapplication.context_modules.LoginActivityContextModule;
import com.softwarearch.shoppingapplication.mvp_modules.LoginActivityMvpModule;
import com.softwarearch.shoppingapplication.scopes.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(modules = {LoginActivityContextModule.class, LoginActivityMvpModule.class},
        dependencies = ApplicationComponent.class)
public interface LoginActivityComponent {

    @ActivityContext
    Context getContext();
    void injectLoginActivity(LoginActivity loginActivity);
}
