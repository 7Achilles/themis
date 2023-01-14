package com.achilles.themis.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.achilles.themis.command"
        ,"com.achilles.themis.client"
        ,"com.achilles.themis.query"
        ,"com.achilles.themis.domain"
        ,"com.achilles.themis.infrastructure"})
public class ThemisClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThemisClientApplication.class, args);
    }

}
