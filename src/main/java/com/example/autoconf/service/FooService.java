package com.example.autoconf.service;

import org.springframework.stereotype.Service;

@Service
public class FooService {
    public Object getHeader() {
        return "body";
    }

    public Object getBody() {
        return "body";
    }
}
