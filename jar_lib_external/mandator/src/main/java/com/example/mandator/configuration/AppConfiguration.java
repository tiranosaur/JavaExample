package com.example.mandator.configuration;

import com.example.mandator.interceptor.JpaInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = {"com.example.mandator"})
public class AppConfiguration implements HibernatePropertiesCustomizer {
    /*
        mandatens - list of mandaten names. like mandatenid, rzbk etc
     */
    @Value("#{'${mandatens}'.split(',')}")
    private List<String> mandatens;

    @Autowired
    JpaInterceptor jpaInterceptor;

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        jpaInterceptor.setMandatens(mandatens);
        hibernateProperties.put("hibernate.ejb.interceptor", jpaInterceptor);
    }
}