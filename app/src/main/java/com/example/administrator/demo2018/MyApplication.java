package com.example.administrator.demo2018;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.administrator.demo2018.injection.component.AppComponent;
import com.facebook.stetho.Stetho;
import com.jess.arms.base.BaseApplication;

/**
 * Created by Administrator on 2018\4\22 0022.
 */

public class MyApplication extends BaseApplication {


    @Override
    public void onCreate() {
        super.onCreate();

//        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();

        //  一般使用默认初始化配置足够使用
        Stetho.initializeWithDefaults(this);

        ARouter.init(this); // 尽可能早,推荐在Application中初始化

    }

}
