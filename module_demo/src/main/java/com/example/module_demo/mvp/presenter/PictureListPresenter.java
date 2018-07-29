package com.example.module_demo.mvp.presenter;

import android.app.Application;

import com.example.module_demo.mvp.model.entity.PictureResp;
import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;

import me.jessyan.armscomponent.commonsdk.utils.RxUtil;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;

import javax.inject.Inject;

import com.example.module_demo.mvp.contract.PictureListContract;
import com.jess.arms.utils.RxLifecycleUtils;


@ActivityScope
public class PictureListPresenter extends BasePresenter<PictureListContract.Model, PictureListContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public PictureListPresenter(PictureListContract.Model model, PictureListContract.View rootView) {
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

    public void getPictureList(int page,int page_count){
        mModel.getPictureList(page,page_count)
                .compose(RxUtil.io_main())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用 Rxlifecycle,使 Disposable 和 Activity 一起销毁
                .subscribe(new ErrorHandleSubscriber<PictureResp>(mErrorHandler) {
                    @Override
                    public void onNext(PictureResp pictureResp) {
                        mRootView.queryPictureSuccess(pictureResp.getData());
                    }

                    @Override
                    public void onError(Throwable t) {
                        super.onError(t);
                        mRootView.queryPictureError(t.getMessage());
                    }
                });
    }
}
