package org.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

@EnableJpaRepositories(basePackages = "org.example.Repository")
@ComponentScan(basePackages = "org.example")
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        // Start the Spring application and get the context
        SpringApplication.run(Main.class, args);

    }


}
