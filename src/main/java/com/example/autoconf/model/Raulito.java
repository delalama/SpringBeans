package com.example.autoconf.model;

import org.springframework.stereotype.Component;

@Component
public class Raulito extends Person {
    public Raulito() {
    }

    public Raulito(Integer age, String name) {
        super(age, name);
    }
}
