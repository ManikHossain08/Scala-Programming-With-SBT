package ca.basic.scala.bigdata

class Person(_name: String, _age: Int){
  var name = _name
  private var age = _age

  override def toString = s"New person is $name, your age $age"
  def modifyObject(p: String) : Person = {
    new Person(p, age + 5)
  }

  def copy(p: Person) : Person = {
    new Person(p.name, age)
  }
}

/*


class Address(streetNumber: Int, streetName: String, zipCode: String) {

  def this(streetName: String, zipCode: String) = this(1, streetName, zipCode)
  def this(zipCode: String) = this(1, null, zipCode)

  println(s"$streetNumber $streetName")

}

val a = new Address(2300, "Guy st.", "A3A4H5")
val b = new Address("Guy st.", "A3A4H5")


 */