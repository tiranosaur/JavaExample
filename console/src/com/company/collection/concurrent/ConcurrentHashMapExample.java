package com.company.collection.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// ConcurrentHashMap	коллекция типа HashMap, реализующая интерфейс ConcurrentMap;
public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");
        map.put(5, "5");
        map.put(6, "6");
        map.put(7, "7");
        map.put(8, "8");
        map.put(9, "9");
        System.out.println("before:\t" + map);
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if ("5".equals(entry.getValue())) {
                map.remove(entry.getKey());
            }
            System.out.printf("%d=%s, ", entry.getKey(), entry.getValue());
        }
        System.out.println();
        System.out.println("after:\t" + map);
    }
}
