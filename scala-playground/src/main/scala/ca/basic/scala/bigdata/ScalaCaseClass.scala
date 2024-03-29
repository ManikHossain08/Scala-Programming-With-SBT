package ca.basic.scala.bigdata

// why we need Case class instead of traditional class
object CaseClassOOP extends App{

  class Person(val _name: String, val _age: Int) {
    val name: String = _name
    val age: Int = _age
  }

  val p = new Person("Iraj", 30)
  println(p)
  println("====================")

  // add toString

  class Person2(val _name: String, val _age: Int) {
    val name: String = _name
    val age: Int = _age

    override def toString(): String = s"$name has $age year(s) old"
  }

  val p2 = new Person2("Iraj", 30)
  println(p2)
  println("====================")

  // Update an object:
  // 1. by defining properties as "var" (not so Scala style)
  // 2. by making a copy of the object with new value

  class Person3(val _name: String, val _age: Int) {
    val name: String = _name
    val age: Int = _age

    override def toString(): String = s"$name has $age year(s) old"

    def copy(newName: String): Person3 = new Person3(newName, age)

    def copy(newAge: Int): Person3 = new Person3(name, newAge)

    def copy(newName: String, newAge: Int) = new Person3(newName, newAge)
  }

  val p3 = new Person3("Iraj", 30)
  println(p3)
  println(p3.copy("John"))
  println(p3.copy(40))
  println(p3.copy("John", 40))
  println("====================")


  // Comparison
  val p4 = new Person3("Iraj", 30)
  println(s"Is '$p3' == '$p4': ${p3 == p4}")

  class Person4(val _name: String, val _age: Int) {
    val name: String = _name
    val age: Int = _age

    override def toString(): String = s"$name has $age year(s) old"

    def copy(newName: String): Person3 = new Person3(newName, age)

    def copy(newAge: Int): Person3 = new Person3(name, newAge)

    def copy(newName: String, newAge: Int) = new Person3(newName, newAge)


    override def equals(that: Any): Boolean =
      this.name == that.asInstanceOf[Person4].name &&
        this.age == that.asInstanceOf[Person4].age

  }

  val p5 = new Person4("Iraj", 30)
  val p6 = new Person4("Iraj", 30)
  println(s"Is '$p5' == '$p6': ${p5 == p6}")

  println("====================")

  // All can be achieved by
  case class Person5(name: String, age: Int)

  val p7 =  Person5("Iraj", 30)
  val p8 =  Person5("Iraj", 30)
  println(s"Is '$p7' == '$p8': ${p7 == p8}")
}