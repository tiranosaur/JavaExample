package com.example.springconsole.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.EmptyInterceptor;

import javax.persistence.Column;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

@Slf4j
public class JpaInterceptor extends EmptyInterceptor {
    private boolean isMandaten;
    private static final String MANDATEN = "name";

    @Override
    public Object getEntity(String entityName, Serializable id) {
        boolean mandatenTrigger = false;
        try {
            Class cls = Class.forName(entityName);
            for (Field f : cls.getDeclaredFields()) {
                Column column = null;
                Annotation[] as = f.getAnnotations();
                for (Annotation a : as) {
                    if (a.annotationType() == Column.class)
                        column = (Column) a;
                }

                if (column != null && column.name().equals(MANDATEN)) {
                    mandatenTrigger = true;
                    break;
                }
            }
        } catch (Exception throwables) {
        }

        if (mandatenTrigger && !isMandaten) {
            log.error("Mandaten class require MANDATENID in query");
        }
        return super.getEntity(entityName, id);
    }

    @Override
    public String onPrepareStatement(String sql) {
        isMandaten = sql.contains("." + MANDATEN + "=");
        return super.onPrepareStatement(sql);
    }
}
