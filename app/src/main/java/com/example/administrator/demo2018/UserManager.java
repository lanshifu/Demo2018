package com.example.administrator.demo2018;

import com.example.administrator.demo2018.service.ApiService;
import com.example.administrator.demo2018.service.UserStroe;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018\4\22 0022.
 */

public class UserManager {

    UserStroe mUserStroe;
    ApiService mApiService;

    @Inject
    public UserManager(ApiService apiService, UserStroe userStroe) {
        mApiService = apiService;
        mUserStroe =  userStroe;
    }

    public void register() {
        mApiService.register();
        mUserStroe.login();
    }
}
