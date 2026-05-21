package com.wellington;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.wellington.model")
@EnableJpaRepositories("com.wellington.repository")
public class WellingtonEcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WellingtonEcommerceApplication.class, args);
    }
}