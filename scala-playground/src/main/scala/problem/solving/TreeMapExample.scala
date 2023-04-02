package problem.solving

import scala.collection.immutable.TreeMap
import scala.collection.mutable


object TreeMapExample extends App {
  val treeMap = TreeMap(
    1 -> "Monday",
    2 -> "Tuesday",
    3 -> "Wednesday"
  )
  /**
   * Here a list of map is converted to touple of sequence like bellow statements
   * we 
   */

  val list: Map[Int, String]  = treeMap ++ List(1->"Sunday", 7-> "Saturday")

  list.get(1) match {
    case Some(x) => println(x)
    case None => println("nothing inside")
  }

   println(mutable.HashMap(1 -> "bac", 1 -> "Manik").get(1))

}
