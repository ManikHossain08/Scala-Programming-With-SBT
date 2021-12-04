package ca.basic.scala.bigdata

object PatternMatchingByTuples extends App {
  val glazedDonutTuple = Tuple2("Glazed Donut", "Very Tasty")
  val glazedDonut = Tuple3("Glazed Donut", "Very Tasty", 2.50)
  val strawberryDonut = Tuple3("Strawberry Donut", "Very Tasty", 2.51)
  val plainDonut = Tuple3("Plain Donut", "Tasty", 2.0)
  val chocolateDonut: (String, String, Double) = ("Chocolate Donut", "Very Tasty", 3.0)
  val donutList: Seq[(String, String, Double)] = List(glazedDonut, strawberryDonut, plainDonut) // list of tuples

  val priceOfPlainDonut: Unit = donutList.foreach { tuple => {
    tuple match {
      case ("Plain Donut", taste, price) => println(s"Donut type = Plain Donut, taste is = $taste price = $price")
      case d if d._1 == "Glazed Donut" => println(s"Donut type = ${d._1}, price = ${d._3}")
      case (_1, _2, _3) => println(s"Donut type = ${_1}, price = ${_3}")
      case (_, _2, _3) => println(s"Donut type = ${_2}, price = ${_3}")
      case _ => None
    }
  }
  }


  class A
  class B extends A
  class C extends A

  class D (one: A, two: A){

    def patternMatching: Unit = {
      (one, two) match {
        case (o:B, t:C)  => println("BC")
        case (o:B, t:B)  => println("BB")
        case d if d._1.getClass == d._2.getClass  => println("AA")
        case _ => None
      }

    }
  }

  val d1 = new D(new B, new B)
  val d2 = new D(new B, new C)
  val d3 = new D(new A, new A)

  d1.patternMatching
  //BB
  d2.patternMatching
  //BC
  d3.patternMatching
  //AA

}
