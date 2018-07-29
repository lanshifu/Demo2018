package com.example.module_demo.mvp.model.api;

import com.example.module_demo.mvp.model.entity.RegisterResp;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * ================================================
 * 存放一些与 API 有关的东西,如请求地址,请求码等
 * <p>
 * Created by ArmsComponentTemplate
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public interface Api {

    @GET("http://www.wanandroid.com/tools/mockapi/1871/register")
    Observable<RegisterResp> register();

}
