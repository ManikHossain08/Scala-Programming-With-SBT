package ca.basic.scala.bigdata

object Client extends App {
  val person = new Person("John", 30)
  println(person)
  println(person.modifyObject("Manik Hossain"))
  println(person.copy(person))

  //val a = new Address(2300, "Guy st.", "A3A4H5")
  //val b = new Address("Guy st.", "A3A4H5")

}
