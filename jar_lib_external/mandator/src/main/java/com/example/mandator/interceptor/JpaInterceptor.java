package com.example.mandator.interceptor;

import com.example.mandator.MandatorTest;
import org.hibernate.EmptyInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;

@Component
@Scope("singleton")
public class JpaInterceptor extends EmptyInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(MandatorTest.class);

    private boolean isMandaten;
    private static final String MANDATEN = "name";
    private HashMap<String, Boolean> classCashe = new HashMap<>();

    @Override
    public Object getEntity(String entityName, Serializable id) {
        boolean mandatenTrigger = false;
        if (classCashe.containsKey(entityName)) {
            mandatenTrigger = classCashe.get(entityName);
        } else {
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
            classCashe.put(entityName, mandatenTrigger);
        }

        if (mandatenTrigger && !isMandaten) {
            LOGGER.error("Mandaten class require MANDATENID in query");
        }
        return super.getEntity(entityName, id);
    }

    @Override
    public String onPrepareStatement(String sql) {
        isMandaten = sql.contains("." + MANDATEN + "=");
        return super.onPrepareStatement(sql);
    }
}
