package org.example.util;

import org.example.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserUtil {
    public static Map<String, String> validate(User user) {
        Map<String, String> errors = new HashMap<>();
        if (user == null) {
            errors.put("user", "user is null");
            return errors;
        }
        if (user.getName() == null || user.getName().isBlank()) {
            errors.put("name", "name is blank");
        }
        if (user.getAge() == null ||user.getAge() == 0) {
            errors.put("age", "user.age is 0");
        }
        return errors;
    }
}
