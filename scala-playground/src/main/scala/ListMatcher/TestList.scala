package ListMatcher


object TestList extends App {
  val listCons =  List(1,2,3)
  val listCons1 = List(4, 5, 6)
  val num1 = 1 :: ( 2 :: ( 3 :: Nil ))
  val num2 = 1 :: 2 :: (3 :: Nil)

  val list1 = listCons :: List(4, 5, 6)

  listMatcher(Nil)
  listMatcher(List(1))
  listMatcher(List(1, 2))
  listMatcher(List(1, 2, 3))
  listMatcher(List(4))
  listMatcher(List(4, 5, 6))
  listMatcher(list1)

  /**
   * Pattern matching of list
   * @param in
   */
  def listMatcher(in: List[Any]): Unit = in match {
    case Nil => println("It's an empty list")
    case 1 :: Nil => println("A list with only one element and it is 1")
    case 1 :: 2 :: xs => println("It's a list starting with 1 and 2")
    case List(1,2,3) :: xs => println("It's a list starting with a List")
    case x :: Nil => println("It's a list with single element")
    case _ => println("I don't know what you're talking about")
  }

  if(num2.nonEmpty){
    println(list1)
  }

  val abc: Unit = println((1 :: 2 :: List(3, 4) :: 5 :: Nil).length)
  val cities = List("Montreal", "Toronto")
  val city = cities :: List("New York") :: "Quebec" :: Nil // List(List(Montreal, Toronto), List(New York), Quebec)
  println(city.init) // List(List(Montreal, Toronto), List(New York)) // init remove the last one


  val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
  val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern")

  romanNumerals.filter(x => x._1 == "V").values.foreach(println)



  /**
   * Query
      • capitalOfCountry("US")
      • Applying a map to a non-existing key gives an error
      • capitalOfCountry("Andorra")
   */
  println(capitalOfCountry("US"))
  //println(capitalOfCountry("bangladesh")) // it will through error because this is not optional and this key not exist
  println(capitalOfCountry.get("bangladesh")) // BUT it will give me None value because we use optional function "get"

  /**
   * As Scala is a functional programming, function in scala is the first-class citizen in scala.
   * So function is an expression in scala.
   */

  hasOdd(List(2,3,5))

  def hasOdd (xs: List[Int]) :Unit = {
      val isOdd: Int => Boolean = (x: Int) => x%2 == 1
    xs.filter(v => v%2==1).foreach(println)

    println(xs exists isOdd)
  }

  /**
   * Tail Recursion
    if the last action of a function is a call to another (possibly the same) function, only a single stack
    frame is needed for both functions. Such calls are called “tail calls”
   */

  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a
    else gcd(b, a % b)
  }

  /**
   * Higher-order functions
      A higher-order function is a function that takes another functions as parameters.

   * Use-Case:
      1. Using same method we can pass different functions if input output format
      is the same which will save time in development and development would be
      faster than usual. Help to make better control on the code instead of writing
      redundant/duplicated code for same functionality.
   */

  /**
   * Anonymous Function
      Is a function that does not have a name
   */


}
