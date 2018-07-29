package com.example.module_demo.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.example.module_demo.mvp.contract.DemoActivityContract;
import com.example.module_demo.mvp.model.DemoActivityModel;


@Module
public class DemoActivityModule {
    private DemoActivityContract.View view;

    /**
     * 构建DemoActivityModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public DemoActivityModule(DemoActivityContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    DemoActivityContract.View provideDemoActivityView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    DemoActivityContract.Model provideDemoActivityModel(DemoActivityModel model) {
        return model;
    }
}