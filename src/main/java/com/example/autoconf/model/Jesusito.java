package com.example.autoconf.model;

import org.springframework.stereotype.Component;

@Component
public class Jesusito extends Person {
    public Jesusito() {

    }

    public Jesusito(Integer age, String name) {
        super(age, name);
    }
}
