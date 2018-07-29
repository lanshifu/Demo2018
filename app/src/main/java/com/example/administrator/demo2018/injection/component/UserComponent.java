package com.example.administrator.demo2018.injection.component;

import android.app.Activity;

import com.example.administrator.demo2018.Dagger2Activity;
import com.example.administrator.demo2018.injection.module.UserModule;
import com.example.administrator.demo2018.injection.scope.PerActivityScop;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2018\4\22 0022.
 */

//module 的 provide 方法使用了 scope ，那么 component 就必须使用同一个注解

//    @Singleton的生命周期依附于 component同一个 module provide singleton ,不同 component 也是不一样

@PerActivityScop
@Component(modules = {UserModule.class},dependencies = {AppComponent.class})
public interface UserComponent {

    void inject(Dagger2Activity activity);
}
