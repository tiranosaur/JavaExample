package de.bankenit.commonutils.annotation;

import de.bankenit.commonutils.configuration.AppConfiguration;
import de.bankenit.commonutils.interceptor.JpaInterceptor;
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
