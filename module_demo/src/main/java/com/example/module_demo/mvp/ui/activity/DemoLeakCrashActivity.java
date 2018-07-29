package com.example.module_demo.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.example.module_demo.mvp.ui.adapter.DemoPagerAdapter;
import com.example.module_demo.mvp.ui.fragment.DemoFragment1;
import com.example.module_demo.mvp.ui.fragment.DemoFragment2;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.example.module_demo.di.component.DaggerDemoLeakCrashComponent;
import com.example.module_demo.di.module.DemoLeakCrashModule;
import com.example.module_demo.mvp.contract.DemoLeakCrashContract;
import com.example.module_demo.mvp.presenter.DemoLeakCrashPresenter;

import com.example.module_demo.R;


import java.util.ArrayList;

import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class DemoLeakCrashActivity extends BaseActivity<DemoLeakCrashPresenter> implements
        DemoLeakCrashContract.View ,DemoFragment1.Demo1Host{

    @BindView(R.id.viewpager)
    ViewPager viewpager;

    public static String TAG="lxb";
    private DemoFragment1 fragment1;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerDemoLeakCrashComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .demoLeakCrashModule(new DemoLeakCrashModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_demo_leak_crash; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initViewpager();
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

    private void initViewpager() {
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        fragment1 = new DemoFragment1();
        DemoFragment2 fragment2 = new DemoFragment2();
        fragment1.setHost(this);
        fragments.add(fragment1);
        fragments.add(fragment2);
        viewpager.setAdapter(new DemoPagerAdapter(getSupportFragmentManager(),fragments));
    }

    @Override
    protected void onDestroy() {
        if (fragment1 != null){
            fragment1.setHost(null);
            fragment1 = null;
        }
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }


    @Override
    public void method1() {
        Log.d(TAG, "method1: ");
    }

    @Override
    public void method2() {
        Log.d(TAG, "method2: ");
    }
}
