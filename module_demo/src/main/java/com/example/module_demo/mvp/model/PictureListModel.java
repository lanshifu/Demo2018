package com.example.module_demo.mvp.model;

import android.app.Application;

import com.example.module_demo.mvp.model.api.service.DemoService;
import com.example.module_demo.mvp.model.entity.PictureResp;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import com.example.module_demo.mvp.contract.PictureListContract;

import io.reactivex.Observable;


@ActivityScope
public class PictureListModel extends BaseModel implements PictureListContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public PictureListModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<PictureResp> getPictureList(int page,int page_count) {
        return mRepositoryManager.obtainRetrofitService(DemoService.class)
                .getDailyList(page,page_count);
    }
}