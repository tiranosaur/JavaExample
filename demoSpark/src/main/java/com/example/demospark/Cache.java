package com.example.demospark;

import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.storage.StorageLevel;

import java.util.Arrays;

public final class Cache {
    private static final Logger log = Logger.getLogger("Cache");

    public static void main(String[] args) {
        try (
                SparkSession spark = SparkSession.builder().appName("demoSpark").master("local").getOrCreate();
                JavaSparkContext context = new JavaSparkContext(spark.sparkContext());
        ) {
            JavaRDD<Integer> integerJavaRDD = context.parallelize(Arrays.asList(2, 7, 3, 4, 5));
            integerJavaRDD.persist(StorageLevel.MEMORY_ONLY());
            System.out.println(integerJavaRDD.first());
            System.out.println(integerJavaRDD.top(1));
            System.out.println(integerJavaRDD.count());
        } catch (Exception e) {
            log.error("An exception occurred:", e);
        }
    }
}