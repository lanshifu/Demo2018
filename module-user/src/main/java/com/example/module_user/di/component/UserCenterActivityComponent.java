package com.example.module_user.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.module_user.di.module.UserCenterActivityModule;

import com.jess.arms.di.scope.ActivityScope;
import com.example.module_user.mvp.ui.activity.UserCenterActivityActivity;

@ActivityScope
@Component(modules = UserCenterActivityModule.class, dependencies = AppComponent.class)
public interface UserCenterActivityComponent {
    void inject(UserCenterActivityActivity activity);
}