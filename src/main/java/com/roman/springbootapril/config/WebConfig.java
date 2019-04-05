package com.roman.springbootapril.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

import java.io.File;

@Configuration
@ComponentScan
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {


        String path = System.getProperty("user.home") + File.separator + "staticX" + File.separator;


        registry.addResourceHandler("/css/**").addResourceLocations("file:///" + path);
        registry.addResourceHandler("/js/**").addResourceLocations("file:///" + path);


    }
}
