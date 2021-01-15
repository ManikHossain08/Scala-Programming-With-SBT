package ca.basic.calculator.rational.number

object RationalAlternativeClient extends App {
  val n1 = new RationalAlternative(1, 3)
  val n2 = new RationalAlternative(2, 7)
  val n3 = new RationalAlternative(5, 7)
  println( n1 + n2 + n3)
  println(n1 - n2 * n3)
}
