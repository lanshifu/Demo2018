package com.example.administrator.demo2018;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.LogUtils;

import me.jessyan.armscomponent.commonsdk.core.RouterHub;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_user).setOnClickListener(v -> {
            navigation(MainActivity.this, RouterHub.USER__USERFCENTERACTIVITY);
        });
        findViewById(R.id.btn_demo).setOnClickListener(v -> {
            LogUtils.debugInfo("onclick");
            navigation(MainActivity.this, RouterHub.DEMO__DEMOACTIVITY);
        });
    }


    public static void navigation(Context context, String path) {
        ARouter.getInstance().build(path).navigation(context);
    }

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return 0;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }
}
