package com.example.module_demo.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.module_demo.di.module.DemoLeakCrashModule;

import com.jess.arms.di.scope.ActivityScope;
import com.example.module_demo.mvp.ui.activity.DemoLeakCrashActivity;

@ActivityScope
@Component(modules = DemoLeakCrashModule.class, dependencies = AppComponent.class)
public interface DemoLeakCrashComponent {
    void inject(DemoLeakCrashActivity activity);
}