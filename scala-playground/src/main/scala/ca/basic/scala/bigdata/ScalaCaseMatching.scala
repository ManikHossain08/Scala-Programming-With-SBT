package ca.basic.scala.bigdata

object ScalaCaseMatching extends App {

  case class Person(name: String, age: Int)

  val x = Person("John", 30)
  println(findPersonAge(x))

  val y = Person("ABC", 30)
  println(findPersonAge(y))

  def findPersonAge(person: Person): String = person.name match {
    case "John" => s"this person ${person.name} age is ${person.age}."
    case "Joe" => s"this person ${person.name} age is ${person.age}."
    case _ => s"this person is completely unknown."
  }

}
