package ca.basic.scala.bigdata

object ScalaAnonymousFunctions extends App {
  /** A function that doesn't have a name, it also may me called aas the lambda functions in this context */

  def higherOrderFunctions(action: Int => Int): Int = {
    action(10)
  }

  /** Increment the input by one */
  def increment(x: Int): Int = x + 1

  val incrementedValue = higherOrderFunctions(increment)
  println(incrementedValue)

  val incrementedValue2 = higherOrderFunctions((x: Int) => x + 1)
  println(incrementedValue)

  (1 to 10).map(x => x + 1).filter(_ % 2 == 1).foreach(println)
  /** instead of using lambda expression 'x => x' we can simply use '_' that will reduce the code and make it easier */
  (1 to 10).map(x => x * 2 ).filter(x => x % 2 == 0).foreach(println)
  (1 to 10).map(_ + 1).filter(_ % 2 == 1).foreach(println)


}
