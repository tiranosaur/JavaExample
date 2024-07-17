package org.example.demors.service;


import jakarta.enterprise.context.RequestScoped;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequestScoped
public class MainService {
    public Map<String, Object> getOkStatusMap() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = dateFormat.format(new Date());
        Map<String, Object> map = new HashMap<>();

        map.put("status", "true");
        map.put("message", "OK");
        map.put("date", dateString);
        return map;
    }
}
