package com.bwie.test.mvp.model;

import com.bwie.test.mvp.common.Api;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 刘海峰.20:59
 */

public class RegisterModel2 {
    public void register(String mobile,String pwd){
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("mobile",mobile);
        builder.add("password",pwd);
        FormBody body = builder.build();
        Request request = new Request.Builder().post(body).url(Api.REGISTER_API2).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                iRegister.failure(call,e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if (response!=null&&response.isSuccessful()){
                    String result = response.body().string();

                    System.out.println("result======="+result);
                    //走解析逻辑，解析完成走如下逻辑
                    if ("result.code".equals("0")){
                        iRegister.registerSuccess("result.code","result.msg");
                    }else{
                        iRegister.registerFail("result.code","result.msg");
                    }

                }
            }
        });



    }
    private IRegister2 iRegister;
    public void setiRegister(IRegister2 iRegister) {
        this.iRegister= iRegister;
    }
    public  interface IRegister2{
        void registerSuccess(String code,String msg);
        void registerFail(String code,String msg);
        void failure(Call call, IOException e);

    }
}
