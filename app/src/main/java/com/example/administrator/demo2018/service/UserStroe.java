package com.example.administrator.demo2018.service;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018\4\22 0022.
 */


public class UserStroe {

    String url = "";

    @Inject
    public UserStroe(String url){
        this.url = url;
    }


    public void login(){
        //登录的方法
        Log.i("lanshifu", "login: url="+url);
    }
}
