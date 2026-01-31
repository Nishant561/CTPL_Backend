package com.nishant.ctplbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;


@EntityScan("com.nishant.ctplbackend.model")
@SpringBootApplication
public class CtplBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CtplBackendApplication.class, args);
    }

}
