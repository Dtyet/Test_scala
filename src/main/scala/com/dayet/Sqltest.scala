package com.dayet

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
/**
  * @author Dayet
  * @date 2019/7/15 0:35
  * @version 1.0
  */
object Sqltest {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    val spark = SparkSession.builder().config(conf).appName("aaa").master("local")
      .getOrCreate()
    val dataFrame = spark.read.format("json").load("")
    dataFrame.cache()
    val unit = dataFrame.createOrReplaceTempView("")



  }
}
