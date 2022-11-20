package com.example.autoconf.conf;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PackageExcluder implements TypeFilter, EnvironmentAware {
    private Environment env;

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
            throws IOException {

        boolean match = false;
        for (String activeProfile : env.getActiveProfiles()) {
            if (activeProfile.equals("dev")) {
                match = isClassInPackage(metadataReader.getClassMetadata(), env.getProperty("devExcludePackage"));
            } else if (activeProfile.equals("prod")) {
                match = isClassInPackage(metadataReader.getClassMetadata(), env.getProperty("prodExcludePackage"));
            }
        }
        return match;
    }

    private boolean isClassInPackage(ClassMetadata classMetadata, String pacakage) {
        return classMetadata.getClassName().startsWith(pacakage);
    }


    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }
}
