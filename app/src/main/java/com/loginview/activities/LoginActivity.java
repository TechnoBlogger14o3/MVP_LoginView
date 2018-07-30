package com.loginview.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loginview.R;
import com.loginview.model.LoginPresenterImpl;
import com.loginview.presenter.LoginPresenter;
import com.loginview.view.LoginView;

public class LoginActivity extends Activity implements LoginView {

    private EditText edtUserName, edtPassword;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPresenter = new LoginPresenterImpl(this);
        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUserName, strPassword;
                strUserName = edtUserName.getText().toString();
                strPassword = edtPassword.getText().toString();
                loginPresenter.performLogin(strUserName, strPassword);
            }
        });
    }

    @Override
    public void loginUserNameEmpty() {
        Toast.makeText(LoginActivity.this, " Please Enter Username", Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginUserPasswordEmpty() {
        Toast.makeText(LoginActivity.this, " Please Enter Password", Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(LoginActivity.this, " Success", Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(LoginActivity.this, "Please use 1234 as UserName and Password", Toast.LENGTH_LONG).show();
    }
}
