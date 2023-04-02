package personal.practice

import scala.io.Source

object Practice extends App {
  val movieUrl = "https://raw.githubusercontent.com/irajhedayati/mcit/master/hive/movie.csv"
  val urlSource = Source.fromURL(movieUrl)
  val movies: List[Movie] = urlSource.getLines().toList.tail.map(Movie(_))
  movies.foreach(p => println(p))
}

case class Movie(mID: Int, title: String, year: Int, director: String)

object Movie {
  def apply(csv: String): Movie = {
    val movie = csv.split(",", -1)
    Movie(movie(0).toInt, movie(1), movie(2).toInt, movie(3))
  }
}



