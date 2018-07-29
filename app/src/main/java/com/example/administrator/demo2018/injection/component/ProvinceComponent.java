package com.example.administrator.demo2018.injection.component;

import com.example.administrator.demo2018.ProvinceActivity;
import com.example.administrator.demo2018.injection.module.ProvinceModule;

import dagger.Component;

/**
 * Created by Administrator on 2018\4\22 0022.
 */

@Component(modules = {ProvinceModule.class})
public interface ProvinceComponent {
    void inject(ProvinceActivity activity);
}
