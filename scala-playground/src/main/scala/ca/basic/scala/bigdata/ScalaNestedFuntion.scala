package ca.basic.scala.bigdata

object ScalaNestedFuntion extends App {

  /** if the input list has any odd number
   *
   * Exists: if there exists any member in the collection which the condition evaluates to true
   **/

  def hasOdd(list: List[Int]): Boolean = {

    def isOdd(in: Int): Boolean = in % 2 == 1
    list.exists(isOdd) // returning boolean type
  }

  /**
   * this isOdd() method is not accessible from outside of the method of hasOdd()
   * hence, this bellow statement is not acceptable and commented it below.
   */
  // def hasOdd(in: List[Int]): Boolean = in.filter(isOdd).nonEmpty

  println("==== Test hasOdd")
  println("Has Odd: "+ hasOdd(List(2, 3, 8)))
  println("Has Odd: "+hasOdd(List(2, 4, 8)))


}
