package com.dayet

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author Dayet
  * @date 2019/7/21 23:30
  * @version 1.0
  */
object Myrdd {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[1]").setAppName("rdd")
    val sc = new SparkContext(conf)
    /**
      * 创建RDD的几种方式
      * 后面参数为分区数
      * 在Java 中没有makeRDD 这样创建RDD的方式
      *
      * */
//    val rdd1 = sc.parallelize(Array(1,2,3,4),4)
//    val rdd2 = sc.makeRDD(Array((1,2),(3,4),(5,6)),3)
//    val rdd3 = sc.textFile("")
    val rdd4 = sc.parallelize(Array(("a","q"),("b","w"),("c","e")))
    val rdd5 = sc.parallelize(Array(("a",1),("b",2),("d",3)))
//    val tp = rdd4.join(rdd5).foreach(print)
    rdd4.subtract(rdd5)

    sc.stop()
  }

}
