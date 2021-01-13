package ca.basic.scala.bigdata

import scala.io.{BufferedSource, Source}

object Scala_IO extends App {
  // Read a local file
  val source: BufferedSource = Source.fromFile("/Users/manikhossain/downloads/train_loan.csv")
  val lines = source.getLines()
  println(lines)
  source.close()

  // Read file from a URL
  val onlineSource: BufferedSource =
    Source.fromURL("https://raw.githubusercontent.com/irajhedayati/mcit/master/hive/movie.csv")

  val onlineLines = source.getLines()
  println(onlineLines)

  onlineSource.close()


}
