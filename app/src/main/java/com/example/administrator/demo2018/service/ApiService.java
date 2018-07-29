package com.example.administrator.demo2018.service;

import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018\4\22 0022.
 */

public class ApiService {

    Context mContext;
    String url;


    public ApiService(String url) {
        Log.d("lanshifu", "ApiService: url  =" +url);
        this.url = url;
    }

    public ApiService(Context context) {
        this.mContext = context;
    }

    public void register() {
        //注册的方法
        Log.i("lanshifu", "ApiService: register");
    }
}
