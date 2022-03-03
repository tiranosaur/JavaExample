package com.utils.retryLibrary.annotation;

import com.utils.retryLibrary.aspect.PerfomanceAspect;
import com.utils.retryLibrary.aspect.RetryClientAspect;
import com.utils.retryLibrary.aspect.TestAspect;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({
        PerfomanceAspect.class,
        RetryClientAspect.class,
        TestAspect.class})
public @interface EnableRetryLibrary {
}
