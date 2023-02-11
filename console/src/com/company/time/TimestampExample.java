package com.company.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TimestampExample {
    public static void main(String[] args) {
        Long timeStamp = System.currentTimeMillis();
        LocalDateTime date2 = Instant.ofEpochMilli(timeStamp).atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(timeStamp);
        System.out.println(LocalDateTime.from(date2));
    }
}
