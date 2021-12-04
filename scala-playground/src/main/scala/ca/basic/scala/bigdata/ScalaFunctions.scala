package ca.basic.scala.bigdata

object ScalaFunctions extends App {

  /**
   * accepts an integer and returns it incremented by one
   */
  def addOne(v: Int): Int = v + 1
  println(addOne(5))

  /**
  * accepts an integer and returns the original value along with the incremented value
  */

  def addAndReturnWIthOriginal (i : Int) : (Int, Int, Int) = (i, i+1, i+2)

  val tuple = addAndReturnWIthOriginal(5)
  println(tuple._1)
  println(tuple._2)
  println(tuple._3)

  //alternative way of getting tuple value and this is the standard approach because previous approach does not make any
  // sense of which value i am getting
  val (org, newVal, modifiedMore) = addAndReturnWIthOriginal(10)
  println(org)
  println(newVal)
  println(modifiedMore)

}
