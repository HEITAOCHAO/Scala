package com.heitaoc.scala

/**
  * @Author: 郭超
  * @DateTime: 2020/11/15 20:11
  * 1.Scala 中Object 相当于java中的单例，object中定义的全是静态,相当于Java中的工具类。Object不可以传参，如果要传参，使用apply方法.
  * 2.Scala中常量是val，变量是var。类型可以省略不写，会自动推断。
  * 3.Scala中每行后面可以不写分号，有自动推断机制，不用显示写出“;”。
  * 4.Scala命名建议驼峰。
  * 5.Scala类中可以传参，传参一定要指定类型。类中属性默认又getter和setter方法。
  * 6.类中重写构造方法时，构造方法第一行必须先调用默认构造。
  * 7.Scala中当new class时，类中除了方法不执行，其他都执行。（构造方法除外）
  * 8.在同一个Scala中，class和object的名称一样时，这个类叫做对象的伴生类，这个对象叫做这个类的伴生对象，他们之间可以相互访问私有变量。
  *
  */

object Day01 {

  def apply(x: Int, y: Int) = {
    print(x, y)
  }

  def main(args: Array[String]): Unit = {
    var test = new Test("郭超", 18, "女")

    print(test.xname)
    print(test.xage)
    print(test.sex)


    println()
    for (i <- 0 to 10) { //包含10
      print(i + "\t ")
    }
    println()
    for (i <- 0 until 10) { //不包含10
      print(i + "\t ")
    }
    println()

    for (i <- 1 until 10) {
      for (j <- 1 to i) {
        if (j <= i)
          print(s"${j} * ${i} = " + i * j + " \t")
      }
      println()
    }

    for (i <- 1 to 9; j <- 1 to i) {
      print(s"${j} * ${i} = " + i * j + " \t")
      if (i == j)
        println()
    }


    val newVar = for (i <- 1 to 100 if (i % 2 == 0) if (i < 50)) yield i

    print(newVar)
  }

}
class Test(name: String, age: Int) {
  var xname = name;
  var xage = age;
  var sex = "男"

  def this(name: String, age: Int, sex: String) {
    this(name, age)
    this.sex = sex
  }
}