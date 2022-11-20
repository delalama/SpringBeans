package com.example.autoconf.conf;

import com.example.autoconf.model.Guillermito;
import com.example.autoconf.model.Jesusito;
import com.example.autoconf.model.Raulito;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

//@Conditional(Java8Condition.class)
//@Conditional(Java17Condition.class)
//@Conditional(NotJava17.class)
@Component
public class ApplicationConfiguration implements ApplicationContextAware {
    @Bean
    public Guillermito getMyGuillermitoBean() {
        return new Guillermito();
    }
    @Bean
    public Raulito getMyRaulitoBean() {
        return new Raulito();
    }
    @Bean
    public Jesusito getMyJesusitoBean() {
        return new Jesusito();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    }
}


