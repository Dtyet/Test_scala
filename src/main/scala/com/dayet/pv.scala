package com.dayet

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author Dayet
  * @date 2019/7/22 23:35
  * @version 1.0
  */
object pv {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("adas").setMaster("local[1]")
    val sc = new SparkContext(conf)
    val lines = sc.textFile("./words")
    lines.flatMap(_.split(" ")).foreach(print)
//    val a = lines.map(x=>{
//      x.split(" ")(0)+"++++++++++"+x.split(" ")(1)
//    }).foreach(println)
    sc.stop()
  }
}
