package com.example.module_demo.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.module_demo.di.module.PictureListModule;

import com.jess.arms.di.scope.ActivityScope;
import com.example.module_demo.mvp.ui.activity.PictureListActivity;

@ActivityScope
@Component(modules = PictureListModule.class, dependencies = AppComponent.class)
public interface PictureListComponent {
    void inject(PictureListActivity activity);
}