package com.zjt.springboot.configuration;

import com.zjt.springboot.Interceptor.UserLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfigurer implements WebMvcConfigurer {
    // 拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserLoginInterceptor()).addPathPatterns("/user/**");
    }

    // 跨域访问配置
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/user/**")
        .allowedOrigins("http://www.zhss.com")
        .allowedMethods("POST", "GET");
    }

    // 格式化
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }

    // URI到视图的映射
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/addUserUI").setViewName("/addUser.jsp");
    }

}
