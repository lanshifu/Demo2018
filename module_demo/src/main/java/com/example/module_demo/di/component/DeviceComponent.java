package com.example.module_demo.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.module_demo.di.module.DeviceModule;

import com.jess.arms.di.scope.ActivityScope;
import com.example.module_demo.mvp.ui.activity.DeviceActivity;

@ActivityScope
@Component(modules = DeviceModule.class, dependencies = AppComponent.class)
public interface DeviceComponent {
    void inject(DeviceActivity activity);
}