package com.example.module_demo.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.example.module_demo.mvp.contract.DemoLeakCrashContract;
import com.example.module_demo.mvp.model.DemoLeakCrashModel;


@Module
public class DemoLeakCrashModule {
    private DemoLeakCrashContract.View view;

    /**
     * 构建DemoLeakCrashModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public DemoLeakCrashModule(DemoLeakCrashContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    DemoLeakCrashContract.View provideDemoLeakCrashView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    DemoLeakCrashContract.Model provideDemoLeakCrashModel(DemoLeakCrashModel model) {
        return model;
    }
}