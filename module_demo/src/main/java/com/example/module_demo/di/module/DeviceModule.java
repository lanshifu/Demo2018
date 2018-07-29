package com.example.module_demo.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.example.module_demo.mvp.contract.DeviceContract;
import com.example.module_demo.mvp.model.DeviceModel;


@Module
public class DeviceModule {
    private DeviceContract.View view;

    /**
     * 构建DeviceModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public DeviceModule(DeviceContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    DeviceContract.View provideDeviceView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    DeviceContract.Model provideDeviceModel(DeviceModel model) {
        return model;
    }
}