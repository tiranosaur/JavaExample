package org.example.util;

import com.sun.net.httpserver.HttpExchange;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UriUtil {
    public static Map<String, Object> getQueryParamMap(HttpExchange exchange) {
        Map<String, Object> queryParamMap = new HashMap<>();
        String query = exchange.getRequestURI().getQuery();

        if (query != null) {
            String decodedQuery = URLDecoder.decode(query, StandardCharsets.UTF_8);
            String[] pairs = decodedQuery.split("&");

            for (String pair : pairs) {
                String[] keyValue = pair.split("=");
                if (keyValue.length == 2) {
                    String key = keyValue[0];
                    String value = keyValue[1];
                    queryParamMap.put(key, value);
                } else if (keyValue.length == 1) {
                    String key = keyValue[0];
                    queryParamMap.put(key, "");
                }
            }
        }

        return queryParamMap;
    }

    public static UUID getUUID(Object obj) {
        try {
            return UUID.fromString(obj.toString());
        } catch (Exception e) {
            return null;
        }
    }
}
