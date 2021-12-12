package com.pracownia.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories("com.pracownia.spring.repositories")
public class SpringApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringApp.class, args);
    }

}
