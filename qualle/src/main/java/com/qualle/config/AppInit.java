package com.qualle.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.qualle")
@SpringBootApplication
public class AppInit {

    public static void main(String[] args) {
        SpringApplication.run(AppInit.class, args);
    }
}
