package ca.basic.scala.bigdata

import scala.io.{BufferedSource, Source}

object ScalaApplyMethod extends App{

  /**
   * Having a parser function is a practice that we do most of the time to
   * either instantiate an object based on external data e.g. CSV, JSON, and etc.
   * or from an internal data model to another internal data model
   * (i.e. create an instance of a case class based on instances of one or
   * more other case classes)
   *
   * Using "apply" function:
   * 1. add a companion object
   * 2. add 'apply' function: def apply(PARAMETERS): Class = ???
   */

  case class PersonWithApply(name:String, age: Int)
  object PersonWithApply {
    def apply(csv: String): PersonWithApply = {
      val csvArr = csv.split(",", -1)
      PersonWithApply(csvArr(0), csvArr(1).trim.toInt)
    }
  }

  val joeAsCSV = "Joe,40"
  val person = PersonWithApply(joeAsCSV)
  println(person)

  /** use map to list bunch of data
   * you can also load data from specific link and map using this class
   * */
  //val source: BufferedSource = Source.fromURL("https://raw.githubusercontent.com/irajhedayati/mcit/master/hive/movie.csv")
  //val lines: List[String] = source.getLines().toList
  val lines: List[String] = List(
    "Joe,30",
    "Manik, 32",
    "Rima,27"
  )
  lines.map( line => PersonWithApply(line)).foreach(println)


  /**
  In order to parse a CSV, extra work is needed.
  We implement a parser function to simplify it
   */
  val joeAsCsv = "Joe biden,30"
  val joe = personFromCsv(joeAsCsv)
  def personFromCsv(line: String): PersonWithApply = {
    val fields = line.split(",", -1)
    PersonWithApply(fields(0), fields(1).toInt)
  }

  println(joe)

}
