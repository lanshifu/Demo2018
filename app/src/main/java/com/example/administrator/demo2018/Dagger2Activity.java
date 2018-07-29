package com.example.administrator.demo2018;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.administrator.demo2018.injection.module.UserModule;
import com.example.administrator.demo2018.service.LoginService;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Administrator on 2018\4\22 0022.
 */

public class Dagger2Activity extends AppCompatActivity {

//    @Inject
//    ApiService apiService;

    @Inject
    UserManager userManager;

    @UserModule.Dev
    @Inject
    LoginService loginServiceByPhone;

   @UserModule.Dev
    @Inject
    LoginService loginServiceByPhon2;

    @UserModule.Release
    @Inject
    LoginService loginServiceByToken;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dagger2);
        //普通的注册，实例化
//        ApiService service = new ApiService();
//        service.register();

//        DaggerUserComponent.builder().userModule(new UserModule()).inject(this);

//        apiService.register();

//        DaggerUserComponent.builder().appComponent(MyApplication.cl).userModule(new UserModule(this)).build().inject(this);

//        DaggerUserComponent.builder()
//                .appComponent(((MyApplication)getApplication()).getAppComponent())
//                .userModule(new UserModule(this))
//                .build()
//                .inject(this);

        userManager.register();
        Log.d("lanshifu", "onCreate: ");
        Log.d("lanshifu", "loginServiceByPhone: " +loginServiceByPhone);
        Log.d("lanshifu", "loginServiceByPhon2: " +loginServiceByPhon2);
        Log.d("lanshifu", "loginServiceByToken: " +loginServiceByToken);

        loginServiceByPhon2.login();
        loginServiceByToken.login();

//        userManager.register();
    }

    public void Loing(View view) {
        startActivity(new Intent(this,LoginActivity.class));
    }

    public void Province(View view) {
        startActivity(new Intent(this,ProvinceActivity.class));
    }
}
