package com.example.autoconf.service;

import com.example.autoconf.BEANSTYPE.BEANSPACKAGE;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Predicate;

@Service
public class AplicationContextService {
    private static ApplicationContext context;

    public AplicationContextService(ApplicationContext ac)
            throws BeansException {
        context = ac;
    }

    public Map<String, String> getBeans(String beansPackage) {
        List<String> beanDefinitionNames = Arrays.asList(context.getBeanDefinitionNames());

        Map<String, String> beansMap = new TreeMap<>();


        String packageFilter;
        if (beansPackage == null) {
            return null;
        } else {
            packageFilter = getPackageName(beansPackage);
        }

        beanDefinitionNames
                .forEach(st -> {
                    boolean beanIsOnDesiredPackage = context.getBean(st).getClass().toString().contains(packageFilter);
                    if(beanIsOnDesiredPackage){
                        beansMap.put(st, context.getBean(st).getClass().toString());
                    }
                });

        return beansMap;
    }

    private String getPackageName(String beansPackage) {
        BEANSPACKAGE beanspackageEnum = BEANSPACKAGE.valueOf(beansPackage);

        String filter = "";
        switch (beanspackageEnum) {
            case ALL:
                break ;
            case DOMAIN:
                filter = "com.example.autoconf";
                break ;
            case CONTROLLER:
                filter = "com.example.autoconf.controller";
                break ;
            case SERVICE:
                filter = "com.example.autoconf.service";
                break ;
        }

        return filter;
    }

}
