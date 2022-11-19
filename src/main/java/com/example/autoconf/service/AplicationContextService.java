package com.example.autoconf.service;

import com.example.autoconf.BEANSTYPE.BEANSPACKAGE;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AplicationContextService {
    private static ApplicationContext context;

    public AplicationContextService(ApplicationContext ac)
            throws BeansException {
        this.context = ac;
    }

    public Map<String, String> getBeans(String beansPackage) {
        BEANSPACKAGE beanspackageEnum = BEANSPACKAGE.valueOf(beansPackage);

        switch (beanspackageEnum) {
            case ALL:
            case CONTROLLER:
            case SERVICE:
        }

        List<String> beanDefinitionNames = List.of(context.getBeanDefinitionNames());

        Map<String, String> beansMap = new HashMap<>();

        beanDefinitionNames.stream()
                .forEach(st -> beansMap.put(st, context.getBean(st).toString()));

        return beansMap;
    }
}
