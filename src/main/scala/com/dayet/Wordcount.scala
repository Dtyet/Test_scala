package com.dayet
import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}
object Wordcount {
  def main(args: Array[String]): Unit = {
    val conf= new SparkConf().setAppName("wordcount")
    val sc=new SparkContext(conf)
    sc.textFile("/1.txt").flatMap(_.split(","))
      .map((_,1)).reduceByKey(_+_).sortBy(_._2,false).foreach(println)
    sc.stop()
  }
}
