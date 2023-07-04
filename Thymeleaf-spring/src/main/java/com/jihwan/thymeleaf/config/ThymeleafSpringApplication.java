package com.jihwan.thymeleaf.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.jihwan.thymeleaf")
public class ThymeleafSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafSpringApplication.class, args);
    }

}
