package com.example.administrator.demo2018.Bean;

import com.example.administrator.demo2018.Bean.Street;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018\4\22 0022.
 */

public class City {

    Street street;

    public City(Street street){
        this.street = street;
    }

    public String show(){
        return " 南京;"+ street.show();
    }
}
