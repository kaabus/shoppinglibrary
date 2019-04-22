package com.softwarearch.shoppingapplication.contracts;

import com.softwarearch.shoppingapplication.models.reponse_models.LoginResponseModel;

public interface LoginActivityContract {

    interface View{
        void successfulLogin(LoginResponseModel loginResponseModel);
        void showError(String call, String statusMessage);
        void showProgress();
        void hideProgress();
        void showComplete();
    }

    interface Presenter{
        void loadLoginData(String email, String password);
    }
}
