package ca.basic.scala.bigdata

/** A method of transforming of functions
 * Currying in Scala is simply a technique or a process of transforming a function.
 * This function takes multiple arguments into a function that takes single argument.
 * It is applied widely in multiple functional languages.
 *
 * Formats/ Syntax:
 * 1. def function name(argument1, argument2) = operation
 * 2. def function name(argument1) = (argument2) => operation
 * 3.
 *
 * */

object ScalaCurrying extends App {

  def add2(a: Int) (b: Int):Int = a + b
  // Partially Applied function.
  val sum = add2(29)_;
  println(sum(5));


  /** A function with two arguments */
  def add(x: Int, y: Int): Int = x + y

  println(add(3, 5))

  /* What if most of the cases the second argument is 5 */

  def curryingAdd(x: Int)(y: Int): Int = x + y

  println(curryingAdd(3)(5))

  def addTo5: Int => Int = curryingAdd(3)

  println(addTo5(5))


}
