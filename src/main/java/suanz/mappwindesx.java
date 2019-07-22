package suanz;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.rdd.RDD;

import java.util.Arrays;
import java.util.List;

/**
 * @author Dayet
 * @version 1.0
 * @date 2019/7/22 22:53
 */
public class mappwindesx {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("daas").setMaster("local");
        SparkContext sc = new SparkContext(conf);
//        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        RDD<String> rdd = sc.textFile("/dasd/das", 1);


        sc.stop();

    }
}
