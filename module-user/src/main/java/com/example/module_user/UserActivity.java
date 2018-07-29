package com.example.module_user;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;

import me.jessyan.armscomponent.commonsdk.core.RouterHub;

@Route(path = RouterHub.USER__USERFCENTERACTIVITY)
public class UserActivity extends BaseActivity {

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_user_center;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }
}
