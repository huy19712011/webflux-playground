package org.example.webfluxplayground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication(scanBasePackages = "org.example.webfluxplayground.${sec}")
@EnableR2dbcRepositories(basePackages = "org.example.webfluxplayground.${sec}")
public class WebfluxPlaygroundApplication {

    public static void main(String[] args) {

        SpringApplication.run(WebfluxPlaygroundApplication.class, args);
        System.out.println("running...");
    }

}
