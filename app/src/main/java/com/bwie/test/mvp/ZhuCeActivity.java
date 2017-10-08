package com.bwie.test.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.bwie.test.mvp.presenter.RegisterPresenter;
import com.bwie.test.mvp.view.RegisterView;

import java.io.IOException;

import okhttp3.Call;

import static com.bwie.test.mvp.R.id.shoujihao;

public class ZhuCeActivity extends AppCompatActivity implements RegisterView, View.OnClickListener {

    private EditText mShoujihao;
    /**
     * 下一步
     */
    private Button mXiayibu;
    private LinearLayout mActivityZhuce;

private RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);

        initView();
        initdata();


    }

    private void initdata() {
        registerPresenter=new RegisterPresenter(this);
    }

    @Override
    public void nameError(String msg) {

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

    private void initView() {
        mShoujihao = (EditText) findViewById(shoujihao);
        mXiayibu = (Button) findViewById(R.id.xiayibu);
        mXiayibu.setOnClickListener(this);
        mActivityZhuce = (LinearLayout) findViewById(R.id.activity_zhuce);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xiayibu:
registerPresenter.regist(mShoujihao.getText().toString());
                Intent intent = new Intent(ZhuCeActivity.this, ZhuCe2Activity.class);
                intent.putExtra("shoujihao", mShoujihao.getText().toString());
                startActivity(intent);
                break;
        }
    }
}
