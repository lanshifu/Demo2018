package com.example.module_user.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.example.module_user.mvp.contract.UserCenterActivityContract;
import com.example.module_user.mvp.model.UserCenterActivityModel;


@Module
public class UserCenterActivityModule {
    private UserCenterActivityContract.View view;

    /**
     * 构建UserCenterActivityModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public UserCenterActivityModule(UserCenterActivityContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    UserCenterActivityContract.View provideUserCenterActivityView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    UserCenterActivityContract.Model provideUserCenterActivityModel(UserCenterActivityModel model) {
        return model;
    }
}