package com.example.module_demo.mvp.presenter;

import android.annotation.SuppressLint;
import android.app.Application;

import com.example.module_demo.mvp.model.entity.RegisterResp;
import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import me.jessyan.armscomponent.commonsdk.utils.RxUtil;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

import javax.inject.Inject;

import com.example.module_demo.mvp.contract.DemoActivityContract;
import com.jess.arms.utils.LogUtils;


@ActivityScope
public class DemoActivityPresenter extends BasePresenter<DemoActivityContract.Model, DemoActivityContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public DemoActivityPresenter(DemoActivityContract.Model model, DemoActivityContract.View rootView) {
        super(model, rootView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
    }

    @SuppressLint("CheckResult")
    public void request(){

        mModel.register().compose(RxUtil.io_main())
        .subscribe(new Observer<RegisterResp>() {
            @Override
            public void onSubscribe(Disposable d) {
                LogUtils.debugInfo("onSubscribe = ");
            }

            @Override
            public void onNext(RegisterResp registerResp) {
                LogUtils.debugInfo("result = " + registerResp.toString());
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.debugInfo("onError = " + e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
