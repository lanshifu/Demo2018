package com.example.administrator.demo2018.service;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018\4\22 0022.
 */

public class LoginService {

    int phone;
    String token;

    public LoginService(){

    }

    /**
     * 号码登录
     * @param phone
     */
   public LoginService(int phone){
        this.phone = phone;
   }

    /**
     * token登录
     * @param token
     */
   public LoginService(String token){
       this.token = token;
   }

   public void login(){
       Log.d("lanshifu", "phone: " +phone);
       Log.d("lanshifu", "token: " +token);
   }

}
