package com.example.module_demo.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.example.module_demo.mvp.contract.PictureListContract;
import com.example.module_demo.mvp.model.PictureListModel;


@Module
public class PictureListModule {
    private PictureListContract.View view;

    /**
     * 构建PictureListModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public PictureListModule(PictureListContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    PictureListContract.View providePictureListView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    PictureListContract.Model providePictureListModel(PictureListModel model) {
        return model;
    }
}