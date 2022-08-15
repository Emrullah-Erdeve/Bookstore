package com.example.Bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/bookstore")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class BookstoreApplication {
    public static void main(String[] args) {
SpringApplication.run(BookstoreApplication.class);
    }
}
