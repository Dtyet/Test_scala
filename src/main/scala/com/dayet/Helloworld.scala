package com.dayet

import org.apache.spark.{SparkConf, sql}
import org.apache.spark.sql.SparkSession

object Helloworld {
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setMaster("local").setAppName("sdsa")
    val spark=new SparkSession.Builder().config(conf).getOrCreate()
    //create a Dataset using spark.range starting from 5 to 100, with increments of 5
    val numDS = spark.range(5, 100, 5)//创建dataset
    val langPercentDF = spark.createDataFrame(List(("Scala", 35), ("Python", 30), ("R", 15), ("Java", 20)))
    val lpDF = langPercentDF.withColumnRenamed("_1", "language").withColumnRenamed("_2", "percent")
    lpDF.createOrReplaceTempView("aaa")
    lpDF.cache()
//    lpDF.orderBy("percent").show(false)
    val aa=spark.sql("select * from aaa")
    aa.show()
  }
}
