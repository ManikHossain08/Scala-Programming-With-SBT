package ca.basic.scala.bigdata

object Scala_Functions extends App {

  /**
   * accepts an integer and returns it incremented by one
   */
  def addOne(v: Int): Int = v + 1
  println(addOne(5))

  /**
  * accepts an integer and returns the original value along with the incremented value
  */

  def addAndReturnWIthOriginal (i : Int) : (Int, Int) = (i, i+1)

  val tuple = addAndReturnWIthOriginal(5)
  println(tuple._1)
  println(tuple._2)

  //alternative way of getting tuple value
  val (org, newVal) = addAndReturnWIthOriginal(10)
  println(org)
  println(newVal)


}
