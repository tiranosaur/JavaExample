package com.example.demospark;

import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

import java.util.Arrays;

public final class Action {
    private static final Logger log = Logger.getLogger("Action");

    public static void main(String[] args) {
        try (
                SparkSession spark = SparkSession.builder().appName("demoSpark").master("local").getOrCreate();
                JavaSparkContext context = new JavaSparkContext(spark.sparkContext());
        ) {
            JavaRDD<Integer> integerJavaRDD = context.parallelize(Arrays.asList(2, 7, 3, 4, 5));
            System.out.println("reduce - " + integerJavaRDD.reduce((x, y) -> x + y));
            System.out.println("reduce - " + integerJavaRDD.reduce(Integer::sum));
            System.out.println("collect - " + integerJavaRDD.collect());
            System.out.println("take - " + integerJavaRDD.take(2));
            System.out.println("top - " + integerJavaRDD.top(2));
            System.out.println("takeSample - " + integerJavaRDD.takeSample(true, 22));
            System.out.println("takeSample - " + integerJavaRDD.takeSample(false, 22));
            System.out.println("count - " + integerJavaRDD.count());
            System.out.println("countByValue - " + integerJavaRDD.countByValue());
        } catch (Exception e) {
            log.error("An exception occurred:", e);
        }
    }
}