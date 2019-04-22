package com.softwarearch.shoppingapplication.mvp_modules;

import com.softwarearch.shoppingapplication.api.ApiService;
import com.softwarearch.shoppingapplication.contracts.LoginActivityContract;
import com.softwarearch.shoppingapplication.contracts.SplashActivityContract;
import com.softwarearch.shoppingapplication.database.UserDao;
import com.softwarearch.shoppingapplication.presenter.LoginPresenterImpl;
import com.softwarearch.shoppingapplication.presenter.SplashPresenterImpl;
import com.softwarearch.shoppingapplication.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class SplashActivityMvpModule {

    private SplashActivityContract.View mView;

    public SplashActivityMvpModule(SplashActivityContract.View mView){
        this.mView = mView;
    }

    @Provides
    @ActivityScope
    SplashActivityContract.View provideView(){
        return mView;
    }

    @Provides
    @ActivityScope
    SplashPresenterImpl providePresenter(UserDao userDao, SplashActivityContract.View mView){
        return new SplashPresenterImpl(userDao, mView);
    }
}
