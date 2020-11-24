package com.heitaoc.scala

import scala.collection.immutable

/**
  * @Author: 郭超
  * @DateTime: 2020/11/19 20:50
  */
object Day04 {

  def main(args: Array[String]): Unit = {

    //可变长set 不导入就是不可变Set
    import scala.collection.mutable.Set
    val set1 = Set[Int](1, 2, 3, 4)
    val set2 = Set[Int](3, 4, 5, 6)

    //+=才加入集合  set1.+(5)返回新集合
    set1.+=(5)
    set1.+(5)

    //交集
    set1.intersect(set2).foreach(print)
    println
    (set1 & set2).foreach(print)
    println
    //差集
    set1.diff(set2).foreach(print)
    println
    (set1 &~ set2).foreach(print)
    println

    //如果想用不可变的 Set找最近的import
    val set3 = immutable.Set[String]("a", "b", "c")


    //定义Map 不可变
    val map1 = Map[String, Int]("a" -> 1, "b" -> 2, ("c", 3), ("d", 4))
    val map2 = Map[String, Int]("a" -> 100, "b" -> 200, ("c", 300), ("e", 500))
    //以后面为主合并，覆盖前面
    (map1.++(map2)).foreach(println)
    //以前面为主合并，覆盖后面
    (map1.++:(map2)).foreach(println)

    //过滤
    map1.filter(m => {
      //_1 key
      val key = m._1
      //_2 value
      val value = m._2
      value == 4
    })

    //可变Map
    import scala.collection.mutable.Map
    val map3 = Map[String, Int]()
    map3.put("a", 2)



    //元组  最大22
    val tuple1: Tuple1[(String, Int)] =new Tuple1("str", 9)
    val tuple2: (String, Int) = Tuple2("Strin", 9)
    val tuple5: (Int, Int, String, Double, Boolean) = (1,2,"3",4.2,true)

  //只有 Tuple2 才有 swap  对换位置
   println(tuple2.swap)

   println("tuple1._1"+tuple1._1)
    println("tuple2._1"+tuple2._1)
    //遍历 1
    val iterator = tuple5.productIterator
//    while(iterator.hasNext){
//      println(iterator.next())
//    }
    //遍历 2
    iterator.foreach(println)

  }





}
