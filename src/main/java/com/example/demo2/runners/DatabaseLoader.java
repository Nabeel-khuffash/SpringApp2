package com.example.demo2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class DatabaseLoader implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loader called");
    }
}
