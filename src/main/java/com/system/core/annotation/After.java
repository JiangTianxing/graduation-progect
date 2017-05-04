package com.system.core.annotation;

import com.system.core.interceptor.BaseInterceptor;
import java.lang.annotation.*;

/**
 * Created by jx on 2017/4/23.
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface After {
    Class<? extends BaseInterceptor> value();
}