package com.example.autoconf.prod;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "prod")
public class ProdProfile {
}
