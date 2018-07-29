package com.example.administrator.demo2018.injection.module;

import com.example.administrator.demo2018.MyApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018\4\22 0022.
 */

@Module
public class AppModule {

    private MyApplication context;

    public AppModule(MyApplication context){
        this.context = context;
    }

    @Singleton
    @Provides
    public MyApplication provideContext(){
        return context;
    }
}
