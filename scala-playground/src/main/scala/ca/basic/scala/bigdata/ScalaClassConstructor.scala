package ca.basic.scala.bigdata

/**
 * There are 2 types of constructor in scala
 * 1. Primary constructor (ex: class Pizza(var size: Int, var cType: String))
 * 2. auxiliary constructor (ex: this(size: Int) = this(size, getDefaultVal.DefaultCrustType))
 *
 * AUXILIARY CLASS CONSTRUCTORS
 * You define auxiliary Scala class constructors by defining methods that are named this.
 * There are only a few rules to know:

    Each auxiliary constructor must have a different signature (different parameter lists)
    Each constructor must call one of the previously defined constructors
    Here’s an example of a Pizza class that defines multiple constructors:
 */

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

  // one-arg auxiliary constructor
  def this(size: Int) = this(size, getDefaultVal.DefaultCrustType)

  def this(cType: String) = this(getDefaultVal.DefaultCrustSize, cType)

  // zero-arg auxiliary constructor
  def this() = this(getDefaultVal.DefaultCrustSize, getDefaultVal.DefaultCrustType)

  override def toString = s"A $size inch pizza with a $cType crust"
}