package com.company.collection.stream.flatMap;

import java.util.List;
import java.util.stream.Stream;

public class FlatMap0 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 234, 5, 2);
        list.stream()
                .flatMap(x -> Stream.of(x, x * 10))
                .forEach(System.out::println);
    }
}
