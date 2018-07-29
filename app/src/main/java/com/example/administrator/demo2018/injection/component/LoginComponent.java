package com.example.administrator.demo2018.injection.component;

import com.example.administrator.demo2018.LoginActivity;
import com.example.administrator.demo2018.injection.module.UserModule;
import com.example.administrator.demo2018.injection.scope.PerActivityScop;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2018\4\22 0022.
 */

@PerActivityScop
@Component(modules = {UserModule.class},dependencies = {AppComponent.class})
public interface LoginComponent {
    void inject(LoginActivity activity);
}
