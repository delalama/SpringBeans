package com.example.autoconf.dev;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "dev")
public class DevProfile {
}
