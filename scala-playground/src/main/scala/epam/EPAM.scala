package epam

object EPAM extends App {

  val persons = List(Person("Virat","Kohli"), Person("Arun","Kumar"))
  val orderList = persons.sortBy(_.lastName).sortBy(_.firstName).map(_.firstName)
  orderList.foreach(println)

}

case class Person(firstName: String, lastName: String)

