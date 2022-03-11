package de.bankenit.commonutils.interceptor;

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
import java.util.List;

@Component
@Scope("singleton")
public class JpaInterceptor extends EmptyInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(JpaInterceptor.class);
    private List<String> mandatens;
    private boolean isMandatenQuery;
    private HashMap<String, Boolean> classCache = new HashMap<>();

    @Override
    public Object getEntity(String entityName, Serializable id) {
        boolean mandatenTrigger = false;
        if (classCache.containsKey(entityName)) {
            mandatenTrigger = classCache.get(entityName);
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

                    for (String mandaten : mandatens) {
                        if (column != null && (column.name().equals(mandaten.toLowerCase()) || column.name().equals(mandaten.toUpperCase()))) {
                            mandatenTrigger = true;
                            break;
                        }
                    }
                }
            } catch (Exception throwables) {
            }
            classCache.put(entityName, mandatenTrigger);
        }

        if (mandatenTrigger && !isMandatenQuery) {
            LOGGER.warn("***   Mandaten class require MANDATENID in query   ***");
        }
        return super.getEntity(entityName, id);
    }

    @Override
    public String onPrepareStatement(String sql) {
        isMandatenQuery = false;
        for (String mandaten : mandatens) {
            if (sql.contains("." + mandaten.toLowerCase() + "=") || sql.contains("." + mandaten.toUpperCase() + "=")) {
                isMandatenQuery = true;
                break;
            }
        }
        return super.onPrepareStatement(sql);
    }

    public void setMandatens(List<String> mandatens) {
        this.mandatens = mandatens;
    }
}
