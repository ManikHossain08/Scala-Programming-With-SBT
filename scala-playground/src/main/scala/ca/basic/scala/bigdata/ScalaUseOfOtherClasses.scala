package ca.basic.scala.bigdata

object ScalaUseOfOtherClasses extends App {
  println(ObjectWithFunctions.myFunction("Laval"))
  println(new ClassWithFunctions().myFunction("Toronto")) // first create object (instantiate) then call thee method
  println(CaseClassWithFunctions().myFunction("Null"))
}

object ObjectWithFunctions {
  private val lookUpTable = Map(
    ("Montreal", "QC"),
    ("Toronto", "ON"),
    ("Laval", "QC")
  )
  def myFunction(city: String) =  lookUpTable(city)
}

class ClassWithFunctions(){
  private val lookUpTable = Map(
    ("Montreal", "QC"),
    ("Toronto", "ON"),
    ("Laval", "QC")
  )
  def myFunction(city: String) =  lookUpTable(city)
}

case class CaseClassWithFunctions(){
  private val lookUpTable = Map(
    ("Montreal", "QC"),
    ("Toronto", "ON"),
    ("Laval", "QC")
  )
  def myFunction(city: String) =  if(lookUpTable.contains(city)) lookUpTable(city) else null
}