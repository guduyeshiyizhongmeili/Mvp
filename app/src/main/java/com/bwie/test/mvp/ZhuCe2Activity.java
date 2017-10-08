package com.bwie.test.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.bwie.test.mvp.presenter.RegisterPresenter2;
import com.bwie.test.mvp.view.RegisterView2;

import java.io.IOException;

import okhttp3.Call;

public class ZhuCe2Activity extends AppCompatActivity implements View.OnClickListener ,RegisterView2{

    private EditText mMima;
    /**
     * 下一步
     */
    private Button mXiayibu2;
    private LinearLayout mActivityZhuce2;
    private RegisterPresenter2 registerPresenter;
    private String shoujihao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce2);
        initView();
        initdata();
       Intent intent= getIntent();
        shoujihao=intent.getStringExtra("shoujihao");


    }

    private void initdata() {
        registerPresenter=new RegisterPresenter2(this);
    }

    private void initView() {
        mMima = (EditText) findViewById(R.id.mima);
        mXiayibu2 = (Button) findViewById(R.id.xiayibu2);
        mXiayibu2.setOnClickListener(this);
        mActivityZhuce2 = (LinearLayout) findViewById(R.id.activity_zhuce2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xiayibu2:
registerPresenter.regist(shoujihao,mMima.getText().toString());
                Intent intent = new Intent(ZhuCe2Activity.this, ZhuCe3Activity.class);
                intent.putExtra("shoujihao", shoujihao);
                intent.putExtra("mima", mMima.getText().toString());
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
    public void registerSuccess(String code, String msg) {

    }

    @Override
    public void registerFail(String code, String msg) {

    }

    @Override
    public void failure(Call call, IOException e) {

    }
}
