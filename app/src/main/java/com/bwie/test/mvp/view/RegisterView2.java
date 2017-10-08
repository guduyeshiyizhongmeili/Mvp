package com.bwie.test.mvp.view;

import java.io.IOException;

import okhttp3.Call;

/**
 * 刘海峰.14:39
 */

public interface RegisterView2 {
    void nameError(String msg);
    void passError(String msg);
    void registerSuccess(String code, String msg);

    void registerFail(String code, String msg);

    void failure(Call call, IOException e);
}
