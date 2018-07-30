package com.loginview.model;

import android.text.TextUtils;

import com.loginview.presenter.LoginPresenter;
import com.loginview.view.LoginView;

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void performLogin(String strUserName, String strPassword) {
        if (TextUtils.isEmpty(strUserName)) {
            loginView.loginUserNameEmpty();
        } else if (TextUtils.isEmpty(strPassword)) {
            loginView.loginUserPasswordEmpty();
        } else if ((strUserName.equalsIgnoreCase("1234") && strPassword.equalsIgnoreCase("1234"))) {
            loginView.loginSuccess();
        } else {
            loginView.loginError();
        }
    }
}
