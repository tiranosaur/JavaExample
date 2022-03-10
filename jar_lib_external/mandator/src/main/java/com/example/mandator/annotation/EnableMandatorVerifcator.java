package com.example.mandator.annotation;

import com.example.mandator.configuration.AppConfiguration;
import com.example.mandator.interceptor.JpaInterceptor;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({AppConfiguration.class, JpaInterceptor.class})
public @interface EnableMandatorVerifcator {
}
