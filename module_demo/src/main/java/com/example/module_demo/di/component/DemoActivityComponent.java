package com.example.module_demo.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.module_demo.di.module.DemoActivityModule;

import com.jess.arms.di.scope.ActivityScope;
import com.example.module_demo.mvp.ui.activity.DemoActivity;

@ActivityScope
@Component(modules = DemoActivityModule.class, dependencies = AppComponent.class)
public interface DemoActivityComponent {
    void inject(DemoActivity activity);
}