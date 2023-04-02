package ca.basic.scala.bigdata

object DataStructure extends App {
  /**
   * https://twitter.github.io/scala_school/collections.html
   * https://alvinalexander.com/scala/how-to-choose-collection-class-scala-cookbook/
   *
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

   Maps
It can hold basic datatypes.
   Option : Option itself is generic and has two subclasses: Some[T] or None
Option is a container that may or may not hold something. example
   trait Option[T] {
  def isDefined: Boolean
  def get: T
  def getOrElse(t: T): T
}

   Map.get uses Option for its return type. Option tells you that the method might not return what you’re asking for.

   Now our data appears trapped in this Option. How do we work with it?

A first instinct might be to do something conditionally based on the isDefined method.

// We want to multiply the number by two, otherwise return 0.
val result = if (res1.isDefined) {
  res1.get * 2
} else {
  0
}

   We would suggest that you use either getOrElse or pattern matching to work with this result.

getOrElse lets you easily define a default value.

val result = res1.getOrElse(0) * 2
Pattern matching fits naturally with Option.

val result = res1 match {
  case Some(n) => n * 2
  case None => 0
}

   https://twitter.github.io/scala_school/collections.html

   */


  /**
   * map: has return type
Evaluates a function over each element in the list, returning a list with the same number of elements.
   */

  val numbers = List(1, 2, 3, 4)
  numbers.map(i => i * 2) // List[Int] = List(2, 4, 6, 8)

  /**
   * foreach: dont have any return type
foreach is like map but returns nothing. foreach is intended for side-effects only.
   */

  /**
   * filter
removes any elements where the function you pass in evaluates to false.
  Functions that return a Boolean are often called predicate functions.
   */

  /**
   * zip
zip aggregates the contents of two lists into a single list of pairs.
   */

  val zipEx: List[(Int, String)] = List(1, 2, 3).zip(List("a", "b", "c"))
  zipEx.foreach(println)

  /**
   * partition
partition splits a list based on where it falls with respect to a predicate function.
   */

  val numbers2 = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val partition: (List[Int], List[Int]) = numbers2.partition(_ % 2 == 0) // split the list against true false value of the condition

  /**
   * find
find returns the first element of a collection that matches a predicate function.
   */
  println("find(i => i > 5)")
  numbers2.find(i => i > 5).foreach(println)

  /**
   * drop & dropWhile
   drop drops the first i elements (from first to that index)
   dropWhile
  dropWhile removes the first element that match a predicate function. For example,
  if we dropWhile odd numbers from our list of numbers, 1 gets dropped (but not 3 which is “shielded” by 2).
   */
  println("drop & dropWhile")
  numbers2.drop(5).foreach(println) // res0: List[Int] = List(6, 7, 8, 9, 10)
  numbers2.dropWhile(_ % 2 != 0).foreach(println) // List[Int] = List(2, 3, 4, 5, 6, 7, 8, 9, 10)

  /**
   * foldLeft, using this function wee can generate fibonacci series.
   * 0 is the starting value (Remember that numbers is a List[Int]), and m
acts as an accumulator.
   */
  println("foldLeft: ")
  println(numbers2.foldLeft(0)((m: Int, n: Int) => m + n)) // Int = 55
  println("foldLeft: Fibonacci")
  (1 to 10).foldLeft(0) { (m, n) => println(s"$m  + $n = ${m+n}"); m + n } // fibonacci series print

  /**
   * foldRight
Is the same as foldLeft except it runs in the opposite direction.
   */
  println("foldRight: series")
  (1 to 10).foldRight(0) { (m, n) => println(s"$m  + $n = ${m+n}"); m + n } // fibonacci series print

  /**
   * flatten
flatten collapses one level of nested structure.
   */

  val nestedList = List(List(1, 2), List(3, 4), List(5,6,7))
  nestedList.foreach(println)
  nestedList.flatten.foreach(println)

  /**
   * flatMap
  flatMap is a frequently used combinator that combines mapping and flattening.
  flatMap takes a function that works on the nested lists and then concatenates the results back together.
   */
  println("Flatmap:")
  nestedList.flatMap(_.map(_*2)).foreach(println)

  println("flatten -> Map:")
  // Think of it as short-hand for mapping and then flattening:
  nestedList.map(_.map(_*3)).flatten.foreach(println)
  // that example calling map and then flatten is an example of the “combinator”-like nature of these functions.

  /**
   * Map?
  All of the functional combinators shown work on Maps, too. Maps can be thought of as a list of pairs so the functions
  you write work on a pair of the keys and values in the Map.
   */
  val extensions = Map("steve" -> 100, "bob" -> 101, "joe" -> 201)
  // Now filter out every entry whose phone extension is lower than 200.
  extensions.filter(_._2 <200).mapValues(_*5).foreach(println)
  extensions.filter(_._2 <200).mapValues(_*5).keys.foreach(println)

  println("Map filter")
  extensions.filter(_._2 < 101).mapValues(_*5).values.foreach(println)
  println("Map filter: END")
  /**
   * 6. Iterator (Iterator)
  In Scala, iterator is not a collection, however, provides a way to access a collection.
  When building a collection requires a lot of overhead (such as reading all rows of a file), iterators can play a good role.
  Note that after the above operation is executed, the iterator will move until the end, and it cannot be used again.
  If you continue to execute itprintln(iter.next)I will report an error. In addition, in the above code,
  useiter.nextwithiter.next()It is ok, however,hasNextDon't be added to the back.
   */
  val iter = Iterator("Hadoop","Spark","Scala")
  while (iter.hasNext) {
    println(iter.next())
  }


}
