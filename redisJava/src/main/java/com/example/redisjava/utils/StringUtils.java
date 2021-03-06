package com.example.redisjava.utils;

import java.util.Random;

public class StringUtils {
    public static String randomString(int limit) {
        char[] alphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz".toCharArray();
        Random random = new Random();
        String generatedString = random.ints(0, alphabet.length)
                .limit(limit)
                .map(x->alphabet[x])
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }

    public static String randomString() {
        return randomString(10);
    }
}