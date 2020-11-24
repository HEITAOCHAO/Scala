package com.heitaoc.scala

/**
  * @Author: 郭超
  * @DateTime: 2020/11/23 20:21
  */
object Day05 {
  def main(args: Array[String]): Unit = {
    val human=new Human();
    human.read("郭超");
    human.listen("刘亦菲");

    val point1=new Point(1,2)
    val point2=new Point(2,2)
    println(point1.isNotEqual(point2))


    val data=(1,1.2,"郭超",true,'a')
    val iterator = data.productIterator
    iterator.foreach(MatchTest)


    //样例类
    val son1=Son("刘德华",18)
    val son2=Son("郭富城",16)
    println(son1.equals(son2))
    println(son1.age)
  }

  /**
    * Match匹配模式
    * 1.case _什么都匹配不上，放在最后
    * 2.match可以匹配值也可以匹配类型
    * 3.匹配过程中会出现数值自动转换问题  比如 1.0:Double 转成 1:Int
    * 4.重上往下匹配，匹配后会自动停止执行
    * 5.模式匹配外面的“{}”可以去掉
    * @param o
    */
  def MatchTest(o:Any)=
    o match {
      case i:Int=>println(s"这是Int:${i}")
      case 1=>println(s"这是1")
      case i:Double=>println(s"Double:${i}")
      case i:String=>println(s"这是String:${i}")
      case 'c'=>println(s"这是c")
      case _=>println("啥也没匹配到！")
    }

  /**
    * 1.偏函数，只能匹配一个值
    * 2.PartialFunction[A,B] A-匹配的值的类型 ，B-返回值的类型
    * @return
    */
  def partial:PartialFunction[String,Int]={
    case "a"=>1
    case "b"=>2
    case "c"=>3
    case "d"=>4
    case _=>0
  }



}

/**
  * 一个类可以继承多个Trait，第一个关键字用extends，后面都用with
  */
class Human() extends Read with Listen {

}

/**
  * trait 不可以传参
  */
trait Read{

  def  read(name:String): Unit ={
    println(s"${name} 正在读取！")
  }

}

trait Listen{

  def listen(name:String): Unit ={
    println(s"${name}正在听！")
  }
}

class Point(xx:Int,yy:Int) extends IsEqual {
  val x=xx;
  val y=yy;

  override def equal(o: Any): Boolean = {
    //先判断o是不是Point实例  如果o作为Point的实例取x和  this.x比   this是指谁调就是谁
    o.isInstanceOf[Point]&&o.asInstanceOf[Point].x==this.x
  }
}

/**
  * trait中可以又实现方法和不实现方法，类继承了Trait要实现没有实现的方法
  */
trait IsEqual{
  def equal(o:Any):Boolean
  def isNotEqual(o:Any):Boolean={
    !equal(o)
  }
}

/**
  * 样例类
  *
  * 1.使用 case关键字的类就是样例类
  * 2.实现了类构造参数的getter方法（构造参数默认val声明 可以修改）
  * 3.当构造参数是var声明时，它会自动生成getter,setter
  * 4.没有其他东西时，可以去掉 “{}”
  * @param name
  * @param age
  */
case class Son(var name:String,var age:Int){

}
