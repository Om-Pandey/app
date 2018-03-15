package com.example.kiit.login2.model;

import android.text.TextUtils;

import com.example.kiit.login2.LOgin.loginview;
import com.example.kiit.login2.Presenter.presenter;

/**
 * Created by KIIT on 16-02-2018.
 */

public class presenterImpl implements presenter {
    loginview loginview;

    public presenterImpl(loginview loginview) {
        this.loginview = loginview;
    }

    @Override
    public void validate(String username, String password) {

        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password))
            loginview.LoginValidate();
        else
        {
            if (username.equals("Om") && password.equals("pandey"))
                loginview.LoginSuccess();
            else
                loginview.LoginFail();
        }
    }
}
