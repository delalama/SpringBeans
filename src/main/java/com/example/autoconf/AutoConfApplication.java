package com.example.autoconf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AutoConfApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoConfApplication.class, args);
        System.out.println("Analyse aplication context");
        System.out.println("http://localhost:8080/app/appContextAnalysis");


    }

}
