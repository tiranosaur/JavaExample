package com.example.mandator.configuration;

import com.example.mandator.interceptor.JpaInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ComponentScan(basePackages = {"com.example.mandator"})
public class HibernateConfiguration implements HibernatePropertiesCustomizer {
    @Autowired
    JpaInterceptor jpaInterceptor;

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        hibernateProperties.put("hibernate.ejb.interceptor", jpaInterceptor);
    }
}