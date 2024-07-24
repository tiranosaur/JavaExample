package org.example;

import org.example.chain.Chain;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ServiceLoader<Chain> chains = ServiceLoader.load(Chain.class);
        for (Chain c : chains) {
            c.printName();
        }
    }
}