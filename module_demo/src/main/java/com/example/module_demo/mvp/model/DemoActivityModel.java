package com.example.module_demo.mvp.model;

import android.app.Application;

import com.example.module_demo.mvp.model.api.Api;
import com.example.module_demo.mvp.model.entity.RegisterResp;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import com.example.module_demo.mvp.contract.DemoActivityContract;
import com.jess.arms.utils.ArmsUtils;

import io.reactivex.Observable;


@ActivityScope
public class DemoActivityModel extends BaseModel implements DemoActivityContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public DemoActivityModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<RegisterResp> register(){
        return ArmsUtils.obtainAppComponentFromContext(mApplication)
                .repositoryManager()
                .obtainRetrofitService(Api.class)
                .register();
    }
}