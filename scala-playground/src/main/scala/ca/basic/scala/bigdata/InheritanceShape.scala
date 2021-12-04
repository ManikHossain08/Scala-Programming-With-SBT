package ca.basic.scala.bigdata

trait Shape {
  def draw(): String

  override def toString: String = s""""Shape = ${draw()}"""".stripMargin
}


class Circle(private val radius: Double) extends Shape {
  override def draw(): String = s"""this circle has the radius of $radius with the area of ${area()}""".stripMargin

  def area(): Double = PiValue.pi * radius * radius
}


class Cylinder(radius: Double, height: Double) extends Circle(radius: Double) {
  override def draw(): String = {
    s"""this cylinder has the radius of $radius and height of $height with the area of ${area()}""".stripMargin
  }

  override def area(): Double = (2 * super.area()) + (2 * PiValue.pi * radius * height)
}


class Square(side: Double) extends Shape {
  override def draw(): String = s"""this Square has the side of $side with the area of ${area()}""".stripMargin

  def area(): Double = side * side
}


class SquareCuboid(side: Double, height: Double) extends Square(side: Double) {
  override def draw(): String = {
    s"""this SquareCuboid has the length of $side and height of $height with the area of ${area()}""".stripMargin
  }

  override def area(): Double = (side + side) + (2 * height) // NOTE: applied random formula to calculate area
}


object Shape {
  def create(name: String, x: Double, y: Double): Shape = name.toLowerCase match {
    case "circle" => new Circle(x)
    case "cylinder" => new Cylinder(x, y)
    case "square" => new Square(x)
    case "sequrecuboid" => new SquareCuboid(x, y)
  }
}


object PiValue {
  val pi = 3.1416
}

