package com.example.administrator.demo2018.injection.module;

import android.content.Context;

import com.example.administrator.demo2018.UserManager;
import com.example.administrator.demo2018.injection.scope.PerActivityScop;
import com.example.administrator.demo2018.service.ApiService;
import com.example.administrator.demo2018.service.LoginService;
import com.example.administrator.demo2018.service.UserStroe;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Named;
import javax.inject.Qualifier;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Administrator on 2018\4\21 0021.
 */

@Module
public class UserModule {

    /**
     * @Qualifier ：注明是Qualifier(关键词)
     @Documented ：标记在文档
     @Retention(RUNTIME) ：运行时级别
     */

    @Qualifier
    @Documented
    @Retention(RUNTIME)
    public @interface Dev {
    }

    @Qualifier
    @Documented
    @Retention(RUNTIME)
    public @interface Release {
    }

    Context context;

    public UserModule(Context context){
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    public String providerUrl(){
        return "baidu.com";
    }

//    这里为什么我们可以直接引用参数参数中的
// context 和 url 呢？因为我们提供了providerUrl() 和 provideContext() 所以可以直接使用)


    @Provides
    public ApiService provideApiServiceRelease(){
        return new ApiService(context);
    }


//    @Provides
//    @Named("release")
//    public ApiService provideServiceDev(String url){
//        return new ApiService(url);
//    }


//    @Provides
//    public UserStroe provideUserStroe(){
//        return new UserStroe(url);
//    }

    @Provides
    public UserManager provideUserManager(ApiService apiService, UserStroe userStroe){
        return new UserManager(apiService,userStroe);
    }

    @Provides
    public int provideNumber(){
        return 10086;
    }


    @PerActivityScop
    @Dev
    @Provides
    public LoginService providerLoginServiceByPhone(int number){
        return new LoginService(number);
    }

    @Release
    @Provides
    public LoginService providerLoginServiceByToken(String token){
        return new LoginService(token);
    }
}
