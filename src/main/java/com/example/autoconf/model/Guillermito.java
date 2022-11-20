package com.example.autoconf.model;

import org.springframework.stereotype.Component;

@Component
public class Guillermito extends Person {
    public Guillermito() {
    }

    public Guillermito(Integer age, String name) {
        super(age, name);
    }
}
