package com.example.administrator.demo2018;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.administrator.demo2018.Bean.Province;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018\4\22 0022.
 */

public class ProvinceActivity extends AppCompatActivity {

    @Inject
    Province province;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        DaggerProvinceComponent.builder().provinceModule(new ProvinceModule()).build().inject(this);
//        DaggerProvinceComponent.create().inject(this);

        Log.d("lanshifu", " province.show(): " + province.show());
    }




}
