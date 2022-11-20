package com.example.autoconf;

import com.example.autoconf.controller.FooController2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;


//Habilitar para hacer override sobre el componentScan AutoConfigurado
@SpringBootApplication
@ComponentScan(
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = FooController2.class)
        })
//@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM, classes = { PackageExcluder.class }))
public class AutoConfApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoConfApplication.class, args);
        System.out.println("Analyse aplication context");
        System.out.println("http://localhost:8080/app/appContextAnalysis");
    }

}
