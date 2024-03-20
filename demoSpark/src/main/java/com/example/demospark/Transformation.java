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

public final class Transformation {
    private static final Logger log = Logger.getLogger("Transformation");

    public static void main(String[] args) {
        try (
                SparkSession spark = SparkSession.builder().appName("demoSpark").master("local").getOrCreate();
                JavaSparkContext context = new JavaSparkContext(spark.sparkContext());
        ) {
            JavaRDD<Integer> integerJavaRDD = context.parallelize(Arrays.asList(2, 3, 4, 5));
            System.out.println(integerJavaRDD.first());
            System.out.println();

            integerJavaRDD
                    .filter(x -> x % 2 != 0)
                    .foreach(x -> System.out.printf("%d, ", x));

            //flatMap
            System.out.println("\n\nflatMap");
            integerJavaRDD
                    .flatMap(x -> Arrays.asList(x, 0).iterator())
                    .foreach(x -> System.out.printf("%d, ", x));

            //distinct
            System.out.println("\n\ndistinct");
            context.parallelize(Arrays.asList(2, 2, 3, 4, 5))
                    .distinct()
                    .foreach(x -> System.out.printf("%d, ", x));

            //union
            System.out.println("\n\nunion");
            context.parallelize(Arrays.asList(2, 2, 3, 4, 5))
                    .union(context.parallelize(Arrays.asList(3, 5, 7)))
                    .foreach(x -> System.out.printf("%d, ", x));

            //join
            System.out.println("\n\njoin");
            List<Tuple2<String, String>> list1 = new ArrayList<>(Arrays.asList());
            list1.add(new Tuple2<>("2", "two"));
            list1.add(new Tuple2<>("7", "seven"));
            list1.add(new Tuple2<>("3", "three"));
            List<Tuple2<String, String>> list2 = new ArrayList<>(Arrays.asList());
            list2.add(new Tuple2<>("2", "tttt"));
            list2.add(new Tuple2<>("7", "ssssssssssssssss"));
            list2.add(new Tuple2<>("3", "ttttttttttttttttttttttttttttt"));
            JavaPairRDD<String, String> parallelizePairRdd1 = context.parallelizePairs(list1);
            JavaPairRDD<String, String> parallelizePairRdd2 = context.parallelizePairs(list2);
            JavaPairRDD<String, Tuple2<String, String>> result = parallelizePairRdd1.join(parallelizePairRdd2);
            System.out.println(result.collect());


            //intersection
            System.out.println("\n\nintersection");
            context.parallelize(Arrays.asList(2, 2, 3, 4, 5))
                    .intersection(context.parallelize(Arrays.asList(3, 5, 7)))
                    .foreach(x -> System.out.printf("%d, ", x));

            //subtract
            System.out.println("\n\nsubtract");
            context.parallelize(Arrays.asList(2, 2, 3, 4, 5))
                    .subtract(context.parallelize(Arrays.asList(3, 5, 7)))
                    .foreach(x -> System.out.printf("%d, ", x));
        } catch (Exception e) {
            log.error("An exception occurred:", e);
        }
    }
}