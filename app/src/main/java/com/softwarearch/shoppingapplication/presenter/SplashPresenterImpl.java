package com.softwarearch.shoppingapplication.presenter;

import com.softwarearch.shoppingapplication.contracts.LoginActivityContract;
import com.softwarearch.shoppingapplication.contracts.SplashActivityContract;
import com.softwarearch.shoppingapplication.database.UserDao;
import com.softwarearch.shoppingapplication.models.database_models.User;

public class SplashPresenterImpl implements SplashActivityContract.Presenter{
    private SplashActivityContract.View mView;
    private UserDao mUserDao;

    public SplashPresenterImpl( UserDao userDao,SplashActivityContract.View mView) {
        this.mView = mView;
        this.mUserDao = userDao;
    }

    @Override
    public boolean isUserFirstTime() {
        return mUserDao.getUser() != null;
    }

    @Override
    public void addUser(User user) throws Exception {
        if (mUserDao!=null){
            mUserDao.insert(user);
        } else {
            throw new Exception("User is null");
        }

    }

    @Override
    public User getUser() {
        return mUserDao.getUser().blockingFirst();
    }
}
