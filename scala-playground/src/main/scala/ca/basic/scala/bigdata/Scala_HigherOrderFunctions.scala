package ca.basic.scala.bigdata

object Scala_HigherOrderFunctions extends App {

  println("========== Functions that take arguments as a functions and return as a functions")
  def higherOrderFunctions(action: Int => Int): String = {
    action(10).toString
  }

  println(higherOrderFunctions(addOne))
  println(higherOrderFunctions(minusOne))

  def addOne(in: Int): Int = in + 1
  def minusOne(in: Int): Int = in - 1


  def higherOrderFunction2(action: Int => Int, in: Int): Int = action(in)
  println(higherOrderFunction2(minusOne, 10))


  println("========== Coercing methods into functions")
  val temperatures = Seq(15.0, 20.0, 25.0)
  private def convertCtoF(temp: Double) = temp * 1.8 + 32
  def forecastInFahrenheit: Seq[Double] = temperatures.map(convertCtoF) // <-- passing the method convertCtoF
  println(forecastInFahrenheit)

  println("========== Higher Order Functions, Functions that accept functions")
  // please review later : https://docs.scala-lang.org/tour/higher-order-functions.html
  // these functions can also be converted as 'lambda functions'

  val salaries = List(20000.0, 70000, 40000)
  private def promotion(salaries: List[Double], promotionFunction: Double => Double): List[Double] =
    salaries.map(promotionFunction)

  def smallPromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * 1.1)

  def greatPromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * math.log(salary))

  def hugePromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * salary)

  println(smallPromotion(salaries))

}
