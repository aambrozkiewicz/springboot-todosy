package com.example;

import com.lyncode.jtwig.mvc.JtwigViewResolver;
import com.lyncode.jtwig.services.api.assets.AssetResolver;
import com.lyncode.jtwig.services.impl.assets.BaseAssetResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public ViewResolver viewResolver() {
        JtwigViewResolver viewResolver = new JtwigViewResolver();
        viewResolver.setPrefix("classpath:/templates/");
        viewResolver.setSuffix(".twig.html");
        viewResolver.setEncoding("UTF-8");

        return viewResolver;
    }

    @Bean
    public AssetResolver assetResolver() {
        BaseAssetResolver assetResolver = new BaseAssetResolver();

        return assetResolver;
    }
}
