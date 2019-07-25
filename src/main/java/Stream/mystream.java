package Stream;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

import java.util.Iterator;

/**
 * @author Dayet
 * @version 1.0
 * @date 2019/7/25 23:08
 */
public class mystream {
    public static void main(String[] args) throws InterruptedException {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("ad");
        SparkContext sc = new SparkContext(conf);
        JavaStreamingContext jsc = new JavaStreamingContext(conf,Durations.seconds(5));
        JavaReceiverInputDStream<String> socketTextStream = jsc.socketTextStream("cdh01", 9999);
        JavaDStream<String> stringJavaDStream = socketTextStream.flatMap(new FlatMapFunction<String, String>() {

            @Override
            public Iterator<String> call(String line) throws Exception {
                return null;
            }
        });
        stringJavaDStream.print();
        jsc.start();
        jsc.awaitTermination();
        jsc.stop();
    }
}
