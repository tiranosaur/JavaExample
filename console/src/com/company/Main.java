package com.company;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class Main {
    public static void main(String[] args) {
        Set<String> set = new ConcurrentSkipListSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("5");
        set.add("6");
        set.add("7");
        set.add("8");
        set.add("9");
        for (String str : set) {
            if ("b".equals(str)) {
                set.remove(str);
            }
            System.out.println(str);
        }

        System.out.println(set);
    }
}
