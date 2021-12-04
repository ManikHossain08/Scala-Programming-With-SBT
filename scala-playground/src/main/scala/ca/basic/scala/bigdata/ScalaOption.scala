package ca.basic.scala.bigdata

import ca.basic.scala.bigdata.ScalaLookUp.Geo

object ScalaOption extends App {
  val geos = List(
    Geo("Montreal", "QC"),
    Geo("Toronto", "ON"),
    Geo("Laval", "QC")
  )
  val geoLookUp: Map[String, Geo] = geos.map(geo => geo.city -> geo).toMap // toMap converts List to Map e,g Map(city -> geo)

  // Exception in thread "main" java.util.NoSuchElementException: key not found: Ottawa
  // geoLookup("Ottawa")
  //val p = geoLookUp("Ottowa") // this statement will throw exception of NoSuchElementException

  val p = geoLookUp.getOrElse("Ottowa", "Unknown")
 // val throwExp = geoLookUp.getOrElse("Ottowa", throw new IllegalArgumentException("We don't know which province is Ottawa"))
  println(p)
  //println(throwExp)

  // different code option to get value from Map
  println("==============")
  val value1 = geoLookUp.getOrElse("Ottowa", "Unknown")
  val value2 = geoLookUp.get("Montreal")
  val value3 = geoLookUp("Montreal")
  val value4 = geoLookUp.get("Ottawa").map(x => x.province)
  val value5: Option[String] = geoLookUp.get("Ottawa").map(_.province) // these 2 statement are identical for value4 and value5
  println(value4)
  println(value5.isEmpty)


  // get value according to the condition... [ this will handle the exception without Some() or None value]
  println("==============")
  geoLookUp.get("Montreal") match {
    case Some(geo) => println(geo.province)
    case None => println("geo.province not available")
  }

  val q: Option[Geo] = geoLookUp.get("Toronto")
  if (q.isDefined)
    println(q.get.province)
  else
    println("We don't have information of Ottawa")

  println("==============")
  val x: Option[String] = geoLookUp.get("Ottawa").map(_.province).map(_.toLowerCase())
  println(x)

  // https://stackoverflow.com/questions/1784664/what-is-the-difference-between-declarative-and-imperative-paradigm-in-programmin


}
