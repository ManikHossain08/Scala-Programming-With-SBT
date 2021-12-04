package ca.basic.scala.bigdata

object DataStructure extends App {
  /**
   * Arrays
Arrays preserve order, can contain duplicates, and are mutable.
   Lists
Lists preserve order, can contain duplicates, and are immutable.
   Sets
Sets do not preserve order and have no duplicates
scala> val numbers = Set(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
numbers: scala.collection.immutable.Set[Int] = Set(5, 1, 2, 3, 4)
   Tuple
A tuple groups together simple logical collections of items without using a class.
scala> val hostPort = ("localhost", 80)
hostPort: (String, Int) = (localhost, 80)
In Scala, a tuple is a value that contains a fixed number of elements, each with its own type. Tuples are immutable.
Tuples are especially handy for returning multiple values from a method.

   Tuples and case classes

Users may sometimes find it hard to choose between tuples and case classes. Case classes have named elements.
The names can improve the readability of some kinds of code. In the planet example above, we might define
  case class Planet(name: String, distance: Double) rather than using tuples.

   */
}
