package com.example.demospark;

import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PairRdd {
    private static final Logger log = Logger.getLogger("PairRdd");

    public static void main(String[] args) {
        try (
                SparkSession spark = SparkSession.builder().appName("demoSpark").master("local").getOrCreate();
                JavaSparkContext context = new JavaSparkContext(spark.sparkContext());
        ) {
            JavaRDD<Integer> integerJavaRDD = context.parallelize(Arrays.asList(2, 7, 3, 4, 5));
            JavaRDD<String> stringJavaRDD = context.parallelize(Arrays.asList("two", "seven", "three", "four", "five"));

            JavaPairRDD<String, String> mapToPairRdd = stringJavaRDD.mapToPair(x -> new Tuple2<>(x, x));
            System.out.println("mapToPair - " + mapToPairRdd.collect());

            List<Tuple2<String, String>> list = new ArrayList<>(Arrays.asList());
            list.add(new Tuple2<>("2", "two"));
            list.add(new Tuple2<>("2", "two"));
            list.add(new Tuple2<>("2", "two"));
            list.add(new Tuple2<>("7", "seven"));
            list.add(new Tuple2<>("3", "three"));

            JavaPairRDD<String, String> parallelizePairRdd = context.parallelizePairs(list);
            System.out.println("parallelizePairRdd - " + parallelizePairRdd.collect());

            JavaPairRDD<String, String> reduceByKeyRDD = parallelizePairRdd.reduceByKey((x, y) -> x + "___" + y);
            System.out.println("reduceByKey - " + reduceByKeyRDD.collect());

            JavaPairRDD<String, Iterable<String>> groupByKeyRdd = parallelizePairRdd.groupByKey();
            System.out.println("reduceByKey - " + groupByKeyRdd.collect());
        } catch (Exception e) {
            log.error("An exception occurred:", e);
        }
    }
}