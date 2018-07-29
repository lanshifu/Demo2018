package com.example.administrator.demo2018;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.administrator.demo2018.injection.module.UserModule;
import com.example.administrator.demo2018.service.LoginService;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018\4\22 0022.
 */

public class LoginActivity extends AppCompatActivity {

    @UserModule.Dev
    @Inject
    LoginService loginService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        DaggerLoginComponent.builder().userModule(new UserModule(this)).build().inject(this);
//        DaggerLoginComponent.builder()
//                .appComponent(((MyApplication)getApplication()).getAppComponent())
//                .userModule(new UserModule(this))
//                .build()
//                .inject(this);

        Log.d("lanshifu", "LoginActivity: loginService = "+loginService);
    }
}
