package com.dayet

import org.apache.spark.storage.StorageLevel
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author Dayet
  * @date 2019/7/18 21:02
  * @version 1.0
  *
  */

object Mypersist {
  /**
    * import scala.annotation.meta.param
    * @param
    * @exception
    *
    * */
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("chche").setMaster("local[1]")
    val sc = new SparkContext()
    val rdd = sc.textFile("F:\\voice2018-12_trans.json")
    sc.setCheckpointDir("hdfs://11.11.:8020/aaa")
    rdd.cache()
    rdd.checkpoint()
    //
    rdd.persist(StorageLevel.MEMORY_ONLY)
    //这个RDD将会在磁盘中执行
    val startime = System.currentTimeMillis()
    val result1 = rdd.count()
    val endtimes = System.currentTimeMillis()
    print("count = "+result1+" ,time = "+(endtimes-startime)+" ")


    val starttime1 = System.currentTimeMillis()
    //这个RDD将会在cache 中读取
    val result2 = rdd.count()
    val endtime1 = System.currentTimeMillis()
    print("count = "+result2+" ,time = "+(endtime1-starttime1)+" ")
    sc.stop()
  }
}
