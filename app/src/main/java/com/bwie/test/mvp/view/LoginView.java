package com.bwie.test.mvp.view;

import java.io.IOException;

import okhttp3.Call;

/**
 * 刘海峰.14:47
 */

public interface LoginView {
    void showProgressbar();

    void hideProgressbar();

    void nameError(String msg);

    void passError(String msg);

    void loginSuccess(String code, String msg);

    void loginFail(String code, String msg);

    void failure(Call call, IOException e);

}
