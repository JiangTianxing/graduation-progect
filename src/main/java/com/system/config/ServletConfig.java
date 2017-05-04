package com.system.config;

import com.system.core.interceptor.InitInterceptor;
import freemarker.template.utility.XmlEscape;
import org.hibernate.validator.HibernateValidator;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.*;

/**
 * Created by jx on 2017/4/23.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
    "com.system.controller"
})
public class ServletConfig extends WebMvcConfigurerAdapter{

    /**
     * 视图解析器
     */
    @Bean
    public ViewResolver viewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setCache(true);
        resolver.setPrefix("");
        resolver.setSuffix(".ftl");
        return resolver;
    }

    /**
     * 文件解析器
     */
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        resolver.setMaxUploadSize(10485760000L);
        resolver.setMaxInMemorySize(40960);
        return resolver;
    }

    /**
     * 处理适配器
     * 请求映射处理适配器
     */
//    @Bean
//    public HandlerAdapter requestMappingHandlerAdapter() {
//        List<MediaType> mediaTypes = new ArrayList<>();
//        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
//        mediaTypes.add(MediaType.TEXT_HTML);
//        mediaTypes.add(MediaType.TEXT_PLAIN);
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        List<HttpMessageConverter<?>> converters = new ArrayList<>();
//        converters.add(converter);
//        converter.setSupportedMediaTypes(mediaTypes);
//        RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
//        adapter.setMessageConverters(converters);
//        return adapter;
//    }

    /**
     * 视图引擎配置
     */
    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() throws IOException {
        Resource resource = new PathMatchingResourcePatternResolver().getResource("classpath:freemarker.properties");
        Properties properties = new Properties();
        properties.load(resource.getInputStream());
        Map<String, Object> vars = new HashMap<>();
        vars.put("xml_escape", new XmlEscape());
        FreeMarkerConfigurer res = new FreeMarkerConfigurer();
        res.setTemplateLoaderPath("/WEB-INF/views/");
        res.setFreemarkerVariables(vars);
        res.setFreemarkerSettings(properties);
        return res;
    }

    /**
     * 注册全局拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InitInterceptor());
    }

    /**
     * 配置静态资源的处理
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 配置静态资源路径
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/res").addResourceLocations("/res/**");
    }

    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
        validatorFactoryBean.setProviderClass(HibernateValidator.class);
        return validatorFactoryBean;
    }
}

