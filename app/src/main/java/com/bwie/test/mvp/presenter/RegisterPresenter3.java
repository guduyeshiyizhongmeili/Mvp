package com.bwie.test.mvp.presenter;


import android.text.TextUtils;

import com.bwie.test.mvp.model.RegisterModel3;

import com.bwie.test.mvp.view.RegisterView3;

import java.io.IOException;

import okhttp3.Call;

/**
 * 刘海峰.19:28
 */

public class RegisterPresenter3 implements RegisterModel3.IRegister3 {
    private RegisterModel3 registerModel;
    private RegisterView3 registerView;
    public RegisterPresenter3(RegisterView3 registerView) {

        this.registerView = registerView;
        registerModel = new RegisterModel3();
        registerModel.setiRegister(this);
    }
    public void regist(String mobile,String pass,String code){
        if (TextUtils.isEmpty(mobile)) {
            registerView.nameError("用户名不能为空");
            return;
        }
        if (TextUtils.isEmpty(pass)) {
            registerView.passError("密码不能为空");
            return;
        }
        if (TextUtils.isEmpty(code)) {
            registerView.passError("码不能为空");
            return;
        }

        registerModel.register(mobile,pass,code);
    }
    @Override
    public void registerSuccess(String code, String msg) {
        registerView.registerSuccess(code,msg);

    }

    @Override
    public void registerFail(String code, String msg) {
        registerView.registerFail(code,msg);

    }

    @Override
    public void failure(Call call, IOException e) {
registerView.failure(call, e);
    }
}
