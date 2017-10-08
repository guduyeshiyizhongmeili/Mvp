package com.bwie.test.mvp.presenter;


import android.text.TextUtils;


import com.bwie.test.mvp.model.RegisterModel2;

import com.bwie.test.mvp.view.RegisterView2;

import java.io.IOException;

import okhttp3.Call;

/**
 * 刘海峰.14:46
 */

public class RegisterPresenter2 implements RegisterModel2.IRegister2{
    private RegisterModel2 registerModel;
    private RegisterView2 registerView;
    public RegisterPresenter2(RegisterView2 registerView) {

        this.registerView = registerView;
        registerModel = new RegisterModel2();
        registerModel.setiRegister(this);
    }
    public void regist(String mobile,String pass){
        if (TextUtils.isEmpty(mobile)) {
            registerView.nameError("用户名不能为空");
            return;
        }
        if (TextUtils.isEmpty(pass)) {
            registerView.passError("密码不能为空");
            return;
        }
        registerModel.register(mobile,pass);
    }
    @Override
    public void registerSuccess(String code, String msg) {
registerView.registerSuccess(code, msg);
    }

    @Override
    public void registerFail(String code, String msg) {
registerView.registerFail(code, msg);
    }

    @Override
    public void failure(Call call, IOException e) {
registerView.failure(call, e);
    }
}
