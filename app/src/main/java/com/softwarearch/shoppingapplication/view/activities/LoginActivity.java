package com.softwarearch.shoppingapplication.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.softwarearch.shoppingapplication.R;
import com.softwarearch.shoppingapplication.Utils;
import com.softwarearch.shoppingapplication.application.ShoppingApplication;
import com.softwarearch.shoppingapplication.components.ApplicationComponent;
import com.softwarearch.shoppingapplication.components.DaggerLoginActivityComponent;
import com.softwarearch.shoppingapplication.components.LoginActivityComponent;
import com.softwarearch.shoppingapplication.context.ApplicationContext;
import com.softwarearch.shoppingapplication.context_modules.LoginActivityContextModule;
import com.softwarearch.shoppingapplication.contracts.LoginActivityContract;
import com.softwarearch.shoppingapplication.mvp_modules.LoginActivityMvpModule;
import com.softwarearch.shoppingapplication.presenter.LoginPresenterImpl;
import com.softwarearch.shoppingapplication.models.reponse_models.LoginResponseModel;

import java.util.Objects;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LoginActivityContract.View {

    @BindView(R.id.username_textInput)
    TextInputEditText usernameEditText;

    @BindView(R.id.password_textInput)
    TextInputEditText passwordEditText;

    LoginActivityComponent loginActivityComponent;

    @Inject
    @ApplicationContext
    public Context context;



    @Inject
    LoginPresenterImpl loginPresenter;

    public LoginActivity(Context context){

    }
    public LoginActivity(){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        ApplicationComponent applicationComponent = ShoppingApplication.get(this).getApplicationComponent();

        loginActivityComponent = DaggerLoginActivityComponent.builder()
                .loginActivityContextModule(new LoginActivityContextModule(this))
                .loginActivityMvpModule(new LoginActivityMvpModule(this))
                .applicationComponent(applicationComponent)
                .build();
        loginActivityComponent.injectLoginActivity(this);
    }

    @OnClick(R.id.login_button)
    public void login(View view){
        checkPassword(Objects.requireNonNull(usernameEditText.getText()).toString(), Objects.requireNonNull(passwordEditText.getText()).toString());
    }

    public String checkPassword(String username, String password){
        if(TextUtils.isEmpty(username)){
            Utils.showToast(getApplicationContext(), "Enter valid username");
            return "Enter valid username";
        }else if(password.length() <= 5){
            Utils.showToast(getApplicationContext(), "Please enter password longer than 5 characters");
            return "Please enter password longer than 5 characters";
        }else{
            loginPresenter.loadLoginData(username, password);
            return "Success";
        }
    }

    @Override
    public void successfulLogin(LoginResponseModel loginResponseModel) {
        // TODO: show UI or navigate to other activity from here e.g.
        Utils.showToast(getApplicationContext(), loginResponseModel.statusMsg);
    }

    @Override
    public void showError(String call, String message) {
        /*show UI element informing the user of Error
         depending on the call assigned in the Presenter
         e.g. for network error. see implementation below
         This will show the error messages attached to the call.*/

        if(call.equals("network error")) Utils.showToast(getApplicationContext(), message);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showComplete() {

    }
}
