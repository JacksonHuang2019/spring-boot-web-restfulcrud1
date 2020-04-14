package com.ccic.springboot.config;


import com.ccic.springboot.component.LoginHandlerIntercepter;
import com.ccic.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// 扩展mvc的功能
@Configuration
public class MyMvcConfig  implements  WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 浏览器发送atccic请求来到 success页面
        registry.addViewController("ccic").setViewName("success");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerIntercepter()).addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/user/login");
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer configurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("login");
                registry.addViewController("index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }
        };
        return configurer;
    }

    @Bean
    public LocaleResolver localeResolver() {

        return new MyLocaleResolver();
    }


}