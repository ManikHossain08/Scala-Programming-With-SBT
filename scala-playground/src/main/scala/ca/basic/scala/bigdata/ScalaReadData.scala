package ca.basic.scala.bigdata

import schema.Movie

import scala.io.{BufferedSource, Source}

object ScalaReadData extends App {
  val source: BufferedSource = Source.fromURL("https://raw.githubusercontent.com/irajhedayati/mcit/master/hive/movie.csv")
  val lines: List[String] = source.getLines().toList

  lines.foreach { e => println(e) }

  // Convert a CSV line to an instance of Movie
  /** Convert a CSV line to an instance of Movie
   * 1. split the line */
  println("===== convert input to our internal data model for any data processing purpose")

  def convertCSVLineToMovieObject(line: String): Movie = {
    val fields: Array[String] = line.split(",", -1)
    Movie(fields(0).toInt, fields(1), fields(2).toInt, fields(3))
  }

  val movies: List[Movie] = lines.tail.map(convertCSVLineToMovieObject)
  movies.foreach(e => println(e))

  println("===== Movies producer after 2000")

  def recentMovieFilter(movie: Movie): Boolean = movie.year >= 2000

  val filteredMovie: List[Movie] = movies.filter(recentMovieFilter)
  filteredMovie.foreach(e => println(e))
  source.close()

  // A while loop;
  // - condition: continue to execute the code block till the condition evaluates to true
  // - operation code block: business logic

  // The following doesn't print anything as condition evaluates to false always
  // while(false) println("John")
  // The following line prints "Joe" infinitely as the condition evaluates to true always
  // while(true) println("Joe")

  // same buffered source data cannot be used multiple time. so, I had to call again
  println("===== Print csv files line using iterator")
  val sourceA: BufferedSource = Source.fromURL("https://raw.githubusercontent.com/irajhedayati/mcit/master/hive/movie.csv")
  var lineIterator = sourceA.getLines()
  while (lineIterator.hasNext) {
    val line = lineIterator.next()
    println(line)
  }

  sourceA.close()

}
