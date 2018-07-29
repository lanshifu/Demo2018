package com.example.administrator.demo2018.injection.module;

import com.example.administrator.demo2018.Bean.City;
import com.example.administrator.demo2018.Bean.Province;
import com.example.administrator.demo2018.Bean.Street;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018\4\22 0022.
 */

@Module
public class ProvinceModule {


    @Provides
    public Street provideStreet(){
        return new Street();
    }

    @Provides
    public City provideCity(Street street){
        return new City(street);
    }

    @Provides
    public Province provideProvince(City city){
        return new Province(city);
    }

}
