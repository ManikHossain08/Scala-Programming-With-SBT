package ca.basic.scala.bigdata

object ScalaClassConstructor extends App {
  val oneArgs = new Pizza(10)
  val oneArgs2 = new Pizza("GREEN")
  val twoArgs = new Pizza()

  println(oneArgs)
  println(oneArgs2)
  println(twoArgs)
}

object getDefaultVal {
  val DefaultCrustSize = 12
  val DefaultCrustType = "THIN"
}

class Pizza(var size: Int, var cType: String) {

  def this(size: Int) = this(size, getDefaultVal.DefaultCrustType)

  def this(cType: String) = this(getDefaultVal.DefaultCrustSize, cType)

  def this() = this(getDefaultVal.DefaultCrustSize, getDefaultVal.DefaultCrustType)

  override def toString = s"A $size inch pizza with a $cType crust"
}