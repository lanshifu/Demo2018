package com.example.administrator.demo2018.Bean;

import javax.inject.Inject;

import dagger.Provides;

/**
 * Created by Administrator on 2018\4\22 0022.
 */

public class Province {

    public City city;

    public Province(City city){
        this.city = city;
    }

    public String show(){
        return "江苏省 ："+city.show();
    }
}
