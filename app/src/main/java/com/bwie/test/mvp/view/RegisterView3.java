package com.bwie.test.mvp.view;

import java.io.IOException;

import okhttp3.Call;

/**
 * 刘海峰.19:24
 */

public interface RegisterView3 {
    void nameError(String msg);
    void passError(String msg);
    void codeError(String msg);
    void registerSuccess(String code, String msg);

    void registerFail(String code, String msg);

    void failure(Call call, IOException e);
}
