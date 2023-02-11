package com.company.collection.stream.flatMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlatMap1 {
    public static void main(String[] args) {
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "first");
        map1.put(2, "second");
        map1.put(3, "third");

        Map<Integer, String> map2 = new HashMap<>();
        map2.put(4, "forth");
        map2.put(5, "fifth");
        map2.put(6, "sixth");

        List<Map<Integer, String>> list = new ArrayList<>();
        list.add(map1);
        list.add(map2);

        System.out.println("map1 - " + map1);
        System.out.println("map2 - " + map2);
        list.stream()
                .flatMap(x -> x.entrySet().stream())
                .forEach(x -> System.out.printf("{%s=%s}\n", x.getKey(), x.getValue()));
    }
}
