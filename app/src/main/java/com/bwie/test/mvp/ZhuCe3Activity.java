package com.bwie.test.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bwie.test.mvp.presenter.RegisterPresenter3;
import com.bwie.test.mvp.view.RegisterView3;

import java.io.IOException;

import okhttp3.Call;

public class ZhuCe3Activity extends AppCompatActivity implements View.OnClickListener,RegisterView3 {

    private EditText mYanzhengma;
    /**
     * 完成
     */
    private Button mXiayibu3;
    private String shoujihao;
    private String mima;
    private RegisterPresenter3  registerPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce3);
        initView();
        initdata();
        Intent intent= getIntent();
        shoujihao=intent.getStringExtra("shoujihao");
        mima=intent.getStringExtra("mima");
    }

    private void initdata() {
        registerPresenter=new RegisterPresenter3(this);
    }

    private void initView() {
        mYanzhengma = (EditText) findViewById(R.id.yanzhengma);
        mXiayibu3 = (Button) findViewById(R.id.xiayibu3);
        mXiayibu3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xiayibu3:
                registerPresenter.regist(shoujihao,mima,mYanzhengma.getText().toString());
                Intent intent=new Intent(ZhuCe3Activity.this,MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void nameError(String msg) {

    }

    @Override
    public void passError(String msg) {

    }

    @Override
    public void codeError(String msg) {

    }

    @Override
    public void registerSuccess(String code, String msg) {

    }

    @Override
    public void registerFail(String code, String msg) {

    }

    @Override
    public void failure(Call call, IOException e) {

    }
}
