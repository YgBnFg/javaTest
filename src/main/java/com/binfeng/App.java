package com.binfeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by bfyang on 2017/10/17.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.binfeng")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
