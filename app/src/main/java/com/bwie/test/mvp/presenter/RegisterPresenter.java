package com.bwie.test.mvp.presenter;

import android.text.TextUtils;

import com.bwie.test.mvp.model.RegisterModel;
import com.bwie.test.mvp.view.RegisterView;

import java.io.IOException;

import okhttp3.Call;

/**
 * 刘海峰.19:16
 */

public class RegisterPresenter implements RegisterModel.IRegister {
    private RegisterModel registerModel;
    private RegisterView registerView;
    public RegisterPresenter(RegisterView registerView) {

        this.registerView = registerView;
        registerModel = new RegisterModel();
        registerModel.setiRegister(this);

    }
public void regist(String mobile){
    if (TextUtils.isEmpty(mobile)) {
        registerView.nameError("用户名不能为空");
        return;
    }
registerModel.register(mobile);
}

    @Override
    public void registerSuccess(String code, String msg) {
registerView.registerSuccess(code,msg);
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
