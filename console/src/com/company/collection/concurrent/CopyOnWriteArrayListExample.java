package com.company.collection.concurrent;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

//CopyOnWriteArrayList	коллекция типа ArrayList с алгоритмом CopyOnWrite;
public class CopyOnWriteArrayListExample {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        System.out.println("before:\t" + list);
        for (String str : list) {
            if ("5".equals(str)) {
                list.remove(str);
            }
            System.out.printf("%s, ", str);
        }
        System.out.println();
        System.out.println("after:\t" + list);
    }
}
