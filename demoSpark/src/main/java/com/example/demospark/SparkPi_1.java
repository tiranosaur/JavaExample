package com.example.demospark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.log4j.Logger;

import java.util.Random;

public final class SparkPi_1 {
    private static final Logger log = Logger.getLogger("SparkPi_1");
    private static final Random random = new Random();

    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf()
                .setMaster("local")
                .setAppName("demoSpark");

        try (JavaSparkContext context = new JavaSparkContext(sparkConf)) {
            JavaRDD<String> userJavaRDD = context.textFile("src/main/resources/users.json");
            System.out.println(userJavaRDD.count());
        } catch (Exception e) {
            log.error("An exception occurred:", e);
        }
    }
}