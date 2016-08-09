package com.zjy.test1;

import com.zjy.mongo.MongoInputFormat;
import com.zjy.mongo.MongoOutputFormat;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.VoidFunction;
import org.bson.BSONObject;
import scala.Tuple2;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjylllf
 * Date: 2016/7/28
 * Time: 15:07
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class SparkConnectMongo {
    public static void main(String[] args) {
        contectMongo();
    }
    public static void contectMongo(){
        SparkConf sparkConf = new SparkConf();
        sparkConf.setMaster("local").setAppName("spark mongo test");
        JavaSparkContext sc = new JavaSparkContext(sparkConf);
        Configuration config =new Configuration();
        //解释 主机：端口号/数据库名.Collection名
        config.set("mongo.input.uri","mongodb://192.168.1.115:8888/lydb.userInfo");
        config.set("mongo.output.uri", "mongodb://192.168.1.115:8888/zjy.user");
        //读取
        JavaPairRDD<Object, BSONObject> mongoRDD = sc.newAPIHadoopRDD(config, MongoInputFormat.class, Object.class, BSONObject.class);
        //BasonObject-> text
        JavaRDD<Text> result = mongoRDD.map(
                new Function<Tuple2<Object, BSONObject>, Text>() {
                    public Text call(Tuple2<Object, BSONObject> v1) throws Exception {
//                        String name = (String) v1._2().get("name");
                        String age = (String) v1._2().get("age");
//                        List<String> paragraph = (List<String>) v1._2().get("paragraph");
                        return new Text(age);
                    }
                }
        );
        result.foreach(new VoidFunction<Text>() {
            public void call(Text text) throws Exception {

                System.out.println(text.toString());
            }
        });
        //copy lang.sanlu to lang.output
        mongoRDD.saveAsNewAPIHadoopFile("file:///copy",Object.class, Object.class, MongoOutputFormat.class, config);


    }
}
