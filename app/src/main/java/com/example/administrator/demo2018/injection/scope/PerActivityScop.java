package com.example.administrator.demo2018.injection.scope;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * Created by Administrator on 2018\4\22 0022.
 */

@Scope
@Retention(RUNTIME)
public @interface PerActivityScop {
}
