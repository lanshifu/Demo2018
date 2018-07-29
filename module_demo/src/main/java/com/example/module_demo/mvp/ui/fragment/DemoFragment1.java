package com.example.module_demo.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.module_demo.R;
import com.example.module_demo.mvp.ui.activity.IHost;
import com.jess.arms.utils.ArmsUtils;
import com.jess.arms.utils.LogUtils;

public class DemoFragment1 extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.debugInfo("lxb-> DemoFragment -> onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.demo_fragment_demo1,null);
        rootView.findViewById(R.id.btn_fragment1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArmsUtils.snackbarText("点击了");
            }
        });
        LogUtils.debugInfo("lxb-> DemoFragment -> onCreateView");
        return rootView;

    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtils.debugInfo("lxb-> DemoFragment -> onStart");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.debugInfo("lxb-> DemoFragment -> onDestroy");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtils.debugInfo("lxb-> DemoFragment -> onActivityCreated");
        if (mHost != null){
            mHost.method1();
            mHost.method2();
        }
        mHost.method1();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtils.debugInfo("lxb-> DemoFragment -> onDestroyView");
    }

    public interface Demo1Host extends IHost{
        public void method2();
    }
    private Demo1Host mHost;
    public void setHost(final Demo1Host host) {
        mHost = host;
    }
}
