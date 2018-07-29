package com.example.administrator.demo2018.injection.component;

import com.example.administrator.demo2018.MyApplication;
import com.example.administrator.demo2018.injection.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2018\4\22 0022.
 */

//AppComponent 已经用@Singleton 修饰就不能再去依赖（dependencies=XXX.class）别的 Component。

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {


    /**
     * 全局单例。所以不用Inject Activity
     *
     * @return 向下返回MyApplication实例
     */
    MyApplication context();
}
