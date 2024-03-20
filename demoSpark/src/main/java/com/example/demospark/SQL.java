package com.example.demospark;

import com.example.demospark.model.User;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.UUID;

import static org.apache.spark.sql.functions.col;

// ATTENTION [spark-hive, jackson-core] required
// mySQL https://www.youtube.com/@husivm/search?query=Spark%2012%3A
public final class SQL {
    private static final Logger log = Logger.getLogger("SQL");

    public static void main(String[] args) {
        try (
                SparkSession spark = SparkSession.builder().appName("demoSpark").master("local").getOrCreate();
                JavaSparkContext context = new JavaSparkContext(spark.sparkContext());
        ) {
            Dataset<Row> jsonDataset = spark.read().option("multiline", "true").json("src/main/resources/users.json");
            jsonDataset.select("*").show(5);
            jsonDataset.select("id", "name").show(5);
            jsonDataset.printSchema();

            Dataset<Row> filteredDataset = jsonDataset.filter(col("age").leq(25));
            filteredDataset.select("*").show();

            jsonDataset.createOrReplaceTempView("users");
            Dataset<Row> usersDataset = spark.sql("SELECT * FROM users");
            usersDataset.select("*").show(3);


            JavaRDD<User> csvUserRdd = spark
                    .read()
                    .option("multiline", "true")
                    .textFile("src/main/resources/users.txt")
                    .javaRDD()
                    .map(User::mapFromCSV);
            System.out.println(csvUserRdd.collect());
            System.out.format("\n%s\n", csvUserRdd.filter(x -> x.getAge() == 25).collect());

            JavaRDD<User> customUserRdd = context.parallelize(Arrays.asList(new User(UUID.fromString("11111111-1111-1111-1111-111111111111"), "tiranosaur", "male", 42)));
            Dataset<Row> customUsersDataset = spark.createDataFrame(customUserRdd, User.class);
            customUsersDataset.show();
        } catch (Exception e) {
            log.error("An exception occurred - ", e);
        }
    }
}