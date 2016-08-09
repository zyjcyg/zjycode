
package com.zjy.test.spark;


import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

import java.io.Serializable;

import static org.apache.spark.sql.functions.col;


public class JavaSparkSqlObjectDataExample {
    public static class Person implements Serializable {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {

        SparkConf sparkConf = new SparkConf();
        sparkConf.setMaster("local").setAppName("spark sql test");
        JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);
        SQLContext spark = new SQLContext(sparkContext.sc());


        runObjectDataFrameExample(sparkContext, spark);
    }


    public static void runObjectDataFrameExample(JavaSparkContext sparkContext, SQLContext sqlContext) {

        final JavaRDD<Person> map = sparkContext.textFile("E:\\myspace\\code\\zjy-code\\zjy-code-06-spark\\" +
                "zjy-code-06-spark-0604-hellosparksql\\src\\main\\resources\\people.txt").map(new Function<String, Person>() {
            public Person call(String v1) throws Exception {
                final String[] split = v1.split(",");
                Person person = new Person();
                person.setAge(Integer.parseInt(split[1].trim()));
                person.setName(split[0]);

                return person;
            }
        });

        final DataFrame dataFrame = sqlContext.createDataFrame(map, Person.class);
        dataFrame.show();
        dataFrame.registerTempTable("person");

        final DataFrame sql = sqlContext.sql("SELECT name FROM person WHERE age >= 13 AND age <= 19");
        sql.show();
    }


}
