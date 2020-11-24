package com.heitaoc.scala

import java.text.SimpleDateFormat
import java.util.Date

/**
  * @Author: 郭超
  * @DateTime: 2020/11/16 20:49
  */
object Day02 {


  def main(args: Array[String]): Unit = {

    /**
      * 1.方法体中如果使用了return那么方法体的返回类型一定要指定
      * 2.如果方法体中没有return，默认将方法体最后一行当作返回值返回。方法体的返回值可以省略。
      * 3.定义方法传入参数一定要指定类型。
      * 4.方法的方法体如果可以一行搞定，那么方法的“{}”可以省略。
      * 5.如果方法定义时，没有写“=”，那么方法体只会返回Unit
      *
      * @param x
      * @param y
      * @return
      */
    def max(x: Int, y: Int): Int = {
      if (x > y)
        return x
      y
    }
    //简写
    //def max(x: Int, y: Int): Int =if (x>y) x else y

    println(max(3, 4))


    /**
      * 递归函数
      *
      * @param num
      * @return
      */
    def fun(num: Int): Int = {
      if (num == 1)
        return num;
      fun(num - 1) * num
    }

    println(fun(5))

    /**
      * 参数可以又默认值
      *
      * @param a
      * @param b
      * @return
      */
    def sum(a: Int = 10, b: Int = 20) = a + b

    println(s"和为${sum(b = 10)}")

    /**
      * 可变长的参数
      *
      * @param s
      */
    def long(s: String*): Unit = {
      for (item <- s)
        print(item)

      /**
        * 简写0
        */
      println()
      s.foreach(item => {
        print(item)
      })

      /**
        * 简写1(只有一个参数，只用了一次参数)
        */
      println()
      s.foreach(print(_))

      /**
        * 简写2
        */
      println()
      s.foreach(print)

    }

    long("1", "2", "3")


    /**
      * 匿名函数
      * => 就是匿名函数,多用于方法的参数是函数时，常用于匿名函数
      *
      */
    def sum1 = (a: Int, b: Int) => {
      a + b
    }


    println()

    /**
      * 嵌套函数
      *
      * @param num
      * @return
      */
    def nestFun(num: Int) = {
      def count(a: Int): Int = {
        if (a == 1)
          return 1
        a * count(a - 1)
      }

      count(num)
    }

    println(s"嵌套函数${nestFun(5)}")


    /**
      * 偏应用函数
      *
      * 在某些情况下，方法中的参数非常多，每次调用只有固定的几个参数在变化，其他都不变，可以定义偏应用函数来实现
      *
      * @param date
      * @param s
      */
    def printTime(date: Date, s: String) = {
      println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date) + "              String:" + s)
    }

    val date = new Date();
    //偏应用函数
    def printTime1 = printTime(date, _: String)

    printTime1("a")
    printTime1("b")
    printTime1("c")


    /**
      * 高阶函数
      * 1.方法的参数是函数
      * 2.方法的返回是函数 <必须显示的写出返回值类型，加"_" 可以不用显示返回类型 >
      * 3.方法的参数和返回都是函数
      */
    //乘函数
    def ride(a: Int, b: Int): Int = {
      a * b
    }

    def reduce(a: Int, b: Int): Int = {
      a - b
    }

    def high(f: (Int, Int) => Int, s: String): String = {
      val value = f(100, 50)
      value + "---------------------" + s
    }

    println("高阶函数:" + high(ride, "hello!"))
    //匿名函数
    println("高阶函数-匿名函数:" + high((a: Int, b: Int) => a + b, "hello!"))

    //方法的返回是函数
    def returnFun(s: String): (String, String) => String = {
      def funtion(s1: String, s2: String): String = {
        s + "::::::" + s1 + s2
      }

      funtion
      //不指定返回类型可以使用一下骚操作
      //  funtion _
    }
    //  "_" 强制把方法转换成 函数类型
    println("方法的返回是函数;" + returnFun("郭超")("aaa", "bbb"))


    //方法的参数和返回都是函数
    def funAndRet(f: (Int, Int) => Int): (String, String) => String = {
      val i = f(2, 3)
      def result(a: String, b: String): String = {
        a + b + "===" + i
      }
      result
    }
    println("方法的参数和返回都是函数="+funAndRet((a,b)=>a*b)("hello ","world "))


    /**
      * 柯里化函数
      */
    def test2(a:Int,b:Int)(c:Int,d:Int,e:Int):Int={
      a+b+c+d+e
    }
    println(s"柯里化函数=${test2(1,2)(3,4,5)}")

  }

}
