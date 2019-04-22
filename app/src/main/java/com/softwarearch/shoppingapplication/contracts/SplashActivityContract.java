package com.softwarearch.shoppingapplication.contracts;

import com.softwarearch.shoppingapplication.models.database_models.User;
import com.softwarearch.shoppingapplication.models.reponse_models.LoginResponseModel;

public interface SplashActivityContract {

    interface View{
        void addUser(boolean firstLaunch);
        void showError(String call, String statusMessage);
        void showProgress();
        void hideProgress();
        void showComplete();
    }

    interface Presenter{
        boolean isUserFirstTime();
        void addUser(User user) throws Exception;
        User getUser();
    }
}
