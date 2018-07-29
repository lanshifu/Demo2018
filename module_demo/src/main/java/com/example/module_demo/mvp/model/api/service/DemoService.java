package com.example.module_demo.mvp.model.api.service;

import com.example.module_demo.mvp.model.entity.PictureResp;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DemoService {

    @GET("http://118.24.18.251:9999/api/picture")
    Observable<PictureResp> getDailyList(
            @Query("page") int page,
            @Query("page_count") int page_count
    );
}
