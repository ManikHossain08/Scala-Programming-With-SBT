package ca.basic.scala.bigdata

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
   *
   * Question: What is apply and unapply method?
   * =>
   * Whereas the apply method is like a constructor which takes arguments and creates an object,
   * the unapply takes an object and tries to give back the arguments. This is most often used in pattern matching
   * and partial functions.

      apply is probably the easier to explain. Essentially, when you treat your object like a function,
      apply is the method that is called, so, Scala turns:

      obj(a, b, c) to obj.apply(a, b, c).


      unapply is a bit more complicated. It is used in Scala's pattern matching mechanism and its most common use
      I've seen is in Extractor Objects.

      For example, here's a toy extractor object:

      object Foo {
        def unapply(x : Int) : Option[String] =
          if(x == 0) Some("Hello, World") else None
      }

      In Scala Extractor is defined as an object which has a method named unapply as one of its part.
      This method extracts an object and returns back the attributes. This method is also used in Pattern matching and
      Partial functions. Extractors also explains apply method, which takes the arguments and constructs an object so,
      it’s helpful in constructing values. The unapply method reverses the construction procedure of the apply method.
   *
   * Source: https://docs.scala-lang.org/tour/extractor-objects.html
   *
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
