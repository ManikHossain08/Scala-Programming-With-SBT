package ca.basic.scala.bigdata

object ScalaInheritance extends App {

  val circle = Shape.create("circle", 1.0, 0.0)
  println(circle)

  val cylinder = Shape.create("cylinder", 4.2, 1.0)
  println(cylinder)

  val square = Shape.create("square", 2.0, 4.0)
  println(square)

  val squareCuboid = Shape.create("sequrecuboid", 3.0, 4.0)
  println(squareCuboid)

  val test = new Circle()


}
