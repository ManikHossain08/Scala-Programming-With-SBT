package ca.basic.scala.bigdata

trait Shape {
  def draw(): String

  override def toString = s"Shape = ${draw()}"
}


class Circle(private val radius: Int) extends Shape {
  override def draw(): String = s"this circle has the radius of $radius with the area of ${area()}"

  def area(): Double = PiValue.pi * radius * radius

}

class Cylinder(radius: Int, height: Int) extends Circle(radius: Int) {
  override def draw(): String = s"this cylinder has the radius of $radius and height of $height with the area of ${area()}"

  override def area(): Double = (2 * PiValue.pi * radius * height) + (2 * PiValue.pi * radius * radius)
}

class Square(side: Int) extends Shape {
  override def draw(): String = s"this Square has the side of $side with the area of ${area()}"

  def area(): Double = side * side
}

class SquareCuboid(side: Int, height: Int) extends Square(side: Int) {
  override def draw(): String = s"this SquareCuboid has the length of $side and height of $height with the area of ${area()}"

  override def area(): Double = side * side + height // applied random rules to calculate area
}

object Shape {
  def create(name: String, x: Double, y: Double): Shape = name.toLowerCase match {
    case "circle" => new Circle(x.toInt)
    case "cylinder" => new Cylinder(x.toInt, y.toInt)
    case "square" => new Square(x.toInt)
    case "sequrecuboid" => new SquareCuboid(x.toInt, y.toInt)
  }
}

object PiValue {
  val pi = 3.1416
}

