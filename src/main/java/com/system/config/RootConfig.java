package com.system.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by jx on 2017/4/23.
 */
@Configuration
@ComponentScan(
        basePackages = {"com.system"},
        excludeFilters = {
            @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        }
)
@Import(value = {
        MybatisConfig.class
})
public class RootConfig {
}