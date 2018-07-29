package com.example.module_demo.mvp.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.module_demo.R;
import com.example.module_demo.di.component.DaggerDemoActivityComponent;
import com.example.module_demo.di.module.DemoActivityModule;
import com.example.module_demo.mvp.contract.DemoActivityContract;
import com.example.module_demo.mvp.presenter.DemoActivityPresenter;
import com.example.module_demo.mvp.ui.adapter.DemoPagerAdapter;
import com.example.module_demo.mvp.ui.fragment.DemoFragment1;
import com.example.module_demo.mvp.ui.fragment.DemoFragment2;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.armscomponent.commonsdk.core.RouterHub;

import static com.jess.arms.utils.Preconditions.checkNotNull;


@Route(path = RouterHub.DEMO__DEMOACTIVITY)
public class DemoActivity extends BaseActivity<DemoActivityPresenter> implements DemoActivityContract.View {

    public static String TAG="lxb";

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerDemoActivityComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .demoActivityModule(new DemoActivityModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_demo; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }



    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }


    @OnClick({R.id.btn_network, R.id.btn_device, R.id.start_server, R.id.change_lanaguage, R.id.picture})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_network:
                mPresenter.request();
                break;
            case R.id.btn_device:
                startActivity(new Intent(this, DeviceActivity.class));
                break;
            case R.id.start_server:
                Intent intent = new Intent();
                intent.setClassName("com.suntek.mway.carrier_configuation", "com.suntek.mway.carrier_configuation.MainService");
                startService(intent);
                break;
           case R.id.change_lanaguage:
               startActivity(new Intent(this, DemoLeakCrashActivity.class));
                break;
            case R.id.picture:
               startActivity(new Intent(this, PictureListActivity.class));
                break;
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");

        String storagePath1 = getStoragePath(this, true);
        String storagePath2 = getStoragePath(this, false);

        Log.d(TAG, "onCreate:storagePath1 = " + storagePath1);
        Log.d(TAG, "onCreate:storagePath1 = " + storagePath2);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    /**
     *
     * @param mContext
     * @param is_removale
     * @return
     */
    private static String getStoragePath(Context mContext, boolean is_removale) {
        StorageManager mStorageManager = (StorageManager) mContext.getSystemService(Context.STORAGE_SERVICE);
        Class<?> storageVolumeClazz = null;
        try {
            storageVolumeClazz = Class.forName("android.os.storage.StorageVolume");
            Method getVolumeList = mStorageManager.getClass().getMethod("getVolumeList");
            Method getPath = storageVolumeClazz.getMethod("getPath");
            Method isRemovable = storageVolumeClazz.getMethod("isRemovable");
            Object result = getVolumeList.invoke(mStorageManager);
            final int length = Array.getLength(result);
            for (int i = 0; i < length; i++) {
                Object storageVolumeElement = Array.get(result, i);
                String path = (String) getPath.invoke(storageVolumeElement);
                boolean removable = (Boolean) isRemovable.invoke(storageVolumeElement);
                if (is_removale == removable) {
                    return path;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
