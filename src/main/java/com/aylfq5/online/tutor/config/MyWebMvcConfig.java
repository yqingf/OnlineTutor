package com.aylfq5.online.tutor.config;


import com.aylfq5.online.tutor.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/4/2 15:11
 * @Version: 1.0
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    /**
     * 在Spring添加拦截器之前先创建拦截器对象，这样就能在Spring映射这个拦截器前，把拦截器中的依赖注入的对象给初始化完成了。
     * @return
     */
    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(loginInterceptor());
        registration.addPathPatterns("/user/**", "/auth/**");
        registration.excludePathPatterns("/user/toLogin.html", "/static/**", "/user/v1/login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/**");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
