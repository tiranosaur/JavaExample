package com.company.collection.concurrent;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

//CopyOnWriteArraySet	реализация интерфейса Set, использующая за основу CopyOnWriteArrayList;
public class CopyOnWriteArraySetExample {
    public static void main(String[] args) {
        Set<String> set = new CopyOnWriteArraySet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("5");
        set.add("6");
        set.add("7");
        set.add("8");
        set.add("9");
        System.out.println("before:\t" + set);
        for (String str : set) {
            if ("5".equals(str)) {
                set.remove(str);
            }
            System.out.printf("%s, ", str);
        }
        System.out.println();
        System.out.println("after:\t" + set);
    }
}
