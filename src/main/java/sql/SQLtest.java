package sql;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

/**
 * @author Dayet
 * @version 1.0
 * @date 2019/7/24 21:54
 */
public class SQLtest {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("sql");
        SparkContext sc = new SparkContext(conf);
        SQLContext scq = new SQLContext(sc);
        //不能读取嵌套的json
        Dataset<Row> dataset = scq.read().format("json").json("./json");
        dataset.registerTempTable("persion");
        dataset.createOrReplaceTempView("dada");

        Dataset<Row> sql = scq.sql("select name from persion");
        sql.show();
        dataset.show();

    }
}
