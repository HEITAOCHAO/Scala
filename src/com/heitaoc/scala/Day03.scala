package com.heitaoc.scala

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

/**
  * @Author: 郭超
  * @DateTime: 2020/11/18 20:17
  */
object Day03 {


  def main(args: Array[String]): Unit = {

    //创建不可变数组
    val array=Array[String]("a","b","c","d")
    array.foreach(println)

    //二维数组
    val arrar2=new Array[Array[Int]](3)
    arrar2(0)=Array[Int](1,2,3)
    arrar2(1)=Array[Int](4,5,6)
    arrar2(2)=Array[Int](7,8,9)

    arrar2.foreach(arr=>{arr.foreach(print)})


    //Array.concat 两个数组合并成一个新数组


    //生成长度为5，内容都是hello的数组
    val arr3: Array[String] = Array.fill(5)("hello")


    println()
    //可变数组
    var arr4= ArrayBuffer[Int](1,2,3,4)
    //加到数组后面
    arr4.+=(5,6)
    arr4.append(7)
    //加到数组最前面
    arr4.+:=(0)
    arr4.foreach(print)






    println
    val list=List[String]("hello world","hello java","hello scala")
    // list.map 一对一
    val stringses: List[Array[String]] = list.map(s =>s.split(" "))
    //stringses.foreach(s=> s.foreach(print))
    for(l<-stringses){
      for(s<-l){
        print(s+"\t")
      }
      println
    }


    // list.p 一对多
    val flatMap: List[String] = list.flatMap(s=>s.split(" "))
    //flatMap.foreach(println)
    for(s<-flatMap){
      println(s)
    }

    //返回匹配到的数据集合    true才返回
    val newStr: List[String] = list.filter(s => {
      s.equals("hello world")
    })

  //返回匹配到的总数
    val count: Int = list.count(s => {
      s.length > 10
    })
    println(count)



    //可变集合
    var list2=ListBuffer[Int](1,2,3)
    list2.append(4)
    list2.+=(5,6)
    list2.+=:(0)
  }




}
