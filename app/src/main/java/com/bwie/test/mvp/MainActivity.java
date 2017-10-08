package com.bwie.test.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bwie.test.mvp.presenter.LoginPresenter;
import com.bwie.test.mvp.view.LoginView;

import java.io.IOException;

import okhttp3.Call;

public class MainActivity extends AppCompatActivity implements LoginView{

    /**
     * 手机号
     */
    private EditText mEtMobile;
    /**
     * 密码
     */
    private EditText mEtPass;
    private ProgressBar mProgressbarLogin;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();


    }

    private void initData() {
        loginPresenter=new LoginPresenter(this);
    }

    private void initView() {
        mEtMobile = (EditText) findViewById(R.id.et_mobile);
        mEtPass = (EditText) findViewById(R.id.et_pass);
        mProgressbarLogin = (ProgressBar) findViewById(R.id.progressbar_login);
    }
  public void  login(View v){
      loginPresenter.login(mEtMobile.getText().toString(),mEtPass.getText().toString());

  }
public void register(View v){
startActivity(new Intent(MainActivity.this,ZhuCeActivity.class));
}
    @Override
    public void showProgressbar() {
        mProgressbarLogin.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgressbar() {
        mProgressbarLogin.setVisibility(View.GONE);
    }

    @Override
    public void nameError(String msg) {

    }

    @Override
    public void passError(String msg) {

    }

    @Override
    public void loginSuccess(String code, String msg) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void loginFail(String code, String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void failure(Call call, IOException e) {

    }
}
