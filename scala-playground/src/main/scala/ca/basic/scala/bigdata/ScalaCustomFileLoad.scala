package ca.basic.scala.bigdata

import schema.Movie

import scala.io.{BufferedSource, Source}

object ScalaCustomFileLoad extends App {
  val sourceFileName = "https://raw.githubusercontent.com/irajhedayati/mcit/master/hive/movie.csv"

  /** Reads a file (CSV) and applies transformer */
  def customFileLoad (fileName: String, transform: String => String) : List[String] = {
    val source: BufferedSource = Source.fromURL(fileName)
    val lines = source.getLines().toList.tail.map(transform)
    lines
  }

  val lines = customFileLoad(sourceFileName, identity) // Here identity is builtin so it will do nothing input = output same
  lines.foreach(e => println(e))


  // Transformer converts each input to a Movie
  println("==========Transformer converts each input to a Movie========")
  def getMovieObj(line: String): String = {
    val fields = line.split(",", -1)
    Movie(fields(0).toInt, fields(1), fields(2).toInt, fields(3)).toString
  }
  customFileLoad(sourceFileName, getMovieObj).foreach(e => println(e))

}
