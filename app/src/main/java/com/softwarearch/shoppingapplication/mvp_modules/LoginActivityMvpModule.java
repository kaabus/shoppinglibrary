package com.softwarearch.shoppingapplication.mvp_modules;

import com.softwarearch.shoppingapplication.api.ApiService;
import com.softwarearch.shoppingapplication.contracts.LoginActivityContract;
import com.softwarearch.shoppingapplication.database.UserDao;
import com.softwarearch.shoppingapplication.presenter.LoginPresenterImpl;
import com.softwarearch.shoppingapplication.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;
@Module
public class LoginActivityMvpModule {

    private LoginActivityContract.View mView;

    public LoginActivityMvpModule(LoginActivityContract.View mView){
        this.mView = mView;
    }

    @Provides
    @ActivityScope
    LoginActivityContract.View provideView(){
        return mView;
    }

    @Provides
    @ActivityScope
    LoginPresenterImpl providePresenter(ApiService apiService, UserDao userDao, LoginActivityContract.View mView){
        return new LoginPresenterImpl(apiService,userDao, mView);
    }
}
