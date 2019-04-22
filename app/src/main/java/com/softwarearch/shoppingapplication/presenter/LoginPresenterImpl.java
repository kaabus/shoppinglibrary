package com.softwarearch.shoppingapplication.presenter;

import android.util.Log;

import com.softwarearch.shoppingapplication.api.ApiService;
import com.softwarearch.shoppingapplication.contracts.LoginActivityContract;
import com.softwarearch.shoppingapplication.database.UserDao;
import com.softwarearch.shoppingapplication.models.reponse_models.LoginResponseModel;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenterImpl implements LoginActivityContract.Presenter {

    private ApiService apiService;
    private LoginActivityContract.View mView;
    private UserDao userDao;

    @Inject
    public LoginPresenterImpl(ApiService apiService,UserDao userDao, LoginActivityContract.View mView){
        this.apiService = apiService;
        this.mView = mView;
        this.userDao =userDao;
    }

    @Override
    public void loadLoginData(String username, String password) {
        mView.showProgress();

        apiService.getLoginResponse(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginResponseModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginResponseModel loginResponseModel) {
                        if(loginResponseModel != null){
                            if(loginResponseModel.status == 200 || loginResponseModel.status == 201){
                                mView.successfulLogin(loginResponseModel);

                            }else{
                                mView.showError("Login error", loginResponseModel.statusMsg);
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError("network error","Error occurred");
                        Log.e("Login", e.getMessage(), e);
                        mView.hideProgress();
                    }

                    @Override
                    public void onComplete() {
                        mView.showComplete();
                        mView.hideProgress();
                    }
                });
    }
}
