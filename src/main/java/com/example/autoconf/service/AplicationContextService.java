package com.example.autoconf.service;

import com.example.autoconf.model.Guillermito;
import com.example.autoconf.model.Jesusito;
import com.example.autoconf.model.Raulito;
import com.example.autoconf.utils.BEANSPACKAGE;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.GenericWebApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class AplicationContextService {
    private GenericWebApplicationContext context;

    public AplicationContextService(GenericWebApplicationContext ac)
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
                    if (beanIsOnDesiredPackage) {
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
                break;
            case DOMAIN:
                filter = "com.example.autoconf";
                break;
            case CONTROLLER:
                filter = "com.example.autoconf.controller";
                break;
            case SERVICE:
                filter = "com.example.autoconf.service";
                break;
            case CONF:
                filter = "com.example.autoconf.conf";
                break;
            case MODEL:
                filter = "com.example.autoconf.model";
                break;
        }
        return filter;
    }

    public void destroyBeans(String beanId) {
        BeanDefinitionRegistry factory = (BeanDefinitionRegistry) context.getAutowireCapableBeanFactory();
        factory.removeBeanDefinition(beanId);
    }

    public void createBean(String beanId) {
        switch (beanId) {
            case "guillermito":
                context.registerBean(Guillermito.class, () -> new Guillermito());
                break;
            case "raulito":
                context.registerBean(Raulito.class, () -> new Raulito());
                break;
            case "jesusito":
                context.registerBean(Jesusito.class, () -> new Jesusito());
                break;
        }
    }

}
