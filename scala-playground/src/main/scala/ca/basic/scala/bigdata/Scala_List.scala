package ca.basic.scala.bigdata

object Scala_List extends App {
  val fruits: List[String] = List("Manik", "Hossain")
  val numbers : List[Int] = List(1,2,3,4,5);
  println(fruits)
  println(numbers)

  // this statement will append the value at the end of the list.
  // https://stackoverflow.com/questions/6566502/whats-the-difference-between-and-in-scala/6566523

  val numbers2 = numbers ++ List(4)
  println(numbers2)

  // you can have list of lists
  /*
    - List(1,2,3)
    - List(4,5,6)
    like a matrix
    1 2 3
    4 5 6
   */

  val nestedList = List(fruits, numbers2)
  println(nestedList)

  val singleItemList2 =  4 :: List()
  println(singleItemList2)

  // Frequently used API of List
  val head = numbers.head

  println(s"original list of the list is $numbers")
  println(s"head of the list is $head")
  println(s"last of the list is ${numbers.last}")
  println(s"reverse of the list is ${numbers.reverse}")
  println(s"tail of the list is ${numbers.tail}")
  println(s"Head of the list is ${numbers.init}")
  println(s"Head of the list is ${numbers.isEmpty}")


  // --------- loop with list--------

  def listOfProfessor(list: List[Int]): Unit = {
    if(list.isEmpty) println("the list is completely empty")
    else if(list == List(1)) println("A list with only one element and it is 1")
    else if (list.size >= 2 && list.head == 1 && list.tail.head == 2) println("It's a list starting with 1 and 2")
    else if (list.size == 1) println("It's a list with single element")
    else println("the list is unknown")
  }

  listOfProfessor(List(1))
  listOfProfessor(Nil)
  listOfProfessor(List(1,2,3,4))

  // https://github.com/irajhedayati/mcit/blob/master/scala/src/main/scala/ca/mcit/bigdata/scala/Scala10List.scala

}
