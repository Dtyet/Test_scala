package com.dayet

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author Dayet
  * @date 2019/7/21 23:30
  * @version 1.0
  */
object Myrdd {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    val sc = new SparkContext()
    /**
      * 创建RDD的几种方式
      * 后面参数为分区数
      * 在Java 中没有makeRDD 这样创建RDD的方式
      * */
    sc.parallelize(Array(1,2,3,4),4)
    sc.makeRDD(Array((1,2),(3,4),(5,6)),3)
    sc.textFile("")





    sc.stop()
  }

}
